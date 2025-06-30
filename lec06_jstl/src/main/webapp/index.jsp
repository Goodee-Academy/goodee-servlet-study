<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.gn.dto.Person" %>
<%@ page import="com.gn.dto.Planet"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>                                                                                                                                                                                             
<html>

<head>
	<meta charset="UTF-8">
	<title>EL과 JSTL</title>
</head>

<body>
	<h1>1. EL의 내장객체</h1>
	<%
		pageContext.setAttribute("test", "페이지"); // 페이지 단위 범위
		request.setAttribute("test", "리퀘스트"); // 요청 단위 범위
		session.setAttribute("test", "세션"); // 세션(클라이언트) 단위 범위
		application.setAttribute("test", "애플리케이션"); // 애플리케이션(서버) 단위 범위
	%>
	
	<h2>(1) JSP 방식 (특정 범주 내장객체 지정)</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	
	<h2>(2) EL 방식</h2>
	<%-- 1. ~Scope 로 끝나는 내장객체 사용 --%>
	<%-- 2. 내장객체 지정 없이 key만 사용하면 => 가장 작은 scope부터 탐색 --%>
	<p>${ pageScope.test }</p>
	<p>${ test }</p>
	
	<h1>2. EL로 객체 다루기</h1>
	<%
		Person person = new Person("김철수", 77);
		request.setAttribute("person", person);
	%>
	
	<h2>(1) JSP 방식</h2>
	<%
		Person myPerson = (Person) request.getAttribute("person");
	%>
	<p>이름: <%= myPerson.getName() %></p>
	<p>나이: <%= myPerson.getAge() %></p>
	
	<h2>(2) EL 방식</h2>
	<%-- EL 방식으로 객체를 다룰 경우 key값.필드명 으로 데이터를 가져옴 --%>
	<%-- private 필드를 직접 꺼내는 게 아니라 getter를 통해서 가져오는 것 --%>
	<p>이름: ${ person.name }</p>
	<p>나이: ${ person.age }</p>
	
	<h2>[연습] 행성 정보 출력하기</h2>
	<%
		Planet earth = new Planet("지구", 1.5, true);
		request.setAttribute("earth", earth);
	%>
	
	<p>이름: ${ requestScope.earth.name }</p>
	<p>태양으로부터의 거리: ${ earth.distance }억 km</p>
	<p>거주 가능 여부: ${ earth.canLive ? "O" : "X" }</p>
	
	<h1>4. EL 연산자</h1>
	<%
		request.setAttribute("num1", 7);
		request.setAttribute("num2", 2);
		request.setAttribute("str1", "햄버거");
		request.setAttribute("str2", "피자");
		
		List<String> menu = new ArrayList<String>();
		menu.add("짜장면");
		menu.add("짬뽕");
		request.setAttribute("menuList", menu);
	%>
	
	<p>
		=== 산술 연산 ===<br>
		${ num1 + num2 }
		${ num1 - num2 }
		${ num1 * num2 }
		
		${ num1 div num2 }
		${ num1 mod num2 }
	</p>
	
	<p>
		=== 문자열 연결 ===<br>
		${ str1 }${ str2 } <%-- 붙여서 출력 --%>
		
		=== 일치 비교 ===<br>
		${ str1 eq str2 }
		${ str1 ne str2 }
	</p>
	
	<p>
		=== List Data 확인 ===<br>
		${ empty menuList ? "비어있음" : "비어있지 않음" }
		${ not empty menuList }
	</p>
	
	<p>
		=== 대소 비교 ===<br>
		${ (num1 gt num2) }
		${ num1 lt num2 }
		
		=== 논리 연산 ===<br>
		${ num1 gt num2 and not empty menuList }
	</p>
	
	<h2>EL 연산자 실습</h2>
	<%
	  request.setAttribute("kor", 85);
	  request.setAttribute("eng", 90);
	  request.setAttribute("math", 78);
	  request.setAttribute("name1", "이순신");
	  request.setAttribute("name2", "김유신");
	
	  List<String> heroList = new ArrayList<>();
	  heroList.add("홍길동");
	  request.setAttribute("heroList", heroList);
	%>
	
	<p>1. 산술 연산</p>
	<p>(1) 평균: ${ (kor + eng + math) div 3 }</p>
	<p>(2) ${ ((kor + eng + math) div 3) gt 80 ? "합격" : "불합격" }</p>
	<p>2. 문자열 연결</p>
	<p>(1) ${ name1 }${ name2 }</p>
	<p>(2) ${ name1 eq name2 ? "동일 인물" : "다르다" }</p>
	<p>3. 리스트가 비어있나요?</p>
	<p>(1) ${ empty heroList ? "O" : "X" }</p>
	<p>(2) ${ (kor gt eng) or not empty heroList ? "true" : "" }</p>
	<p>(3) ${ (math lt 80) and (eng ge 90) ? "true" : "" }</p>
	
	
	<h1>5. JSTL Core Library</h1>
	<h2>(1) 변수 선언</h2>
	<%-- c:set 사용 특징 --%>
	<%-- 1. 자료형 선언 X (무조건 String) --%>
	<%-- 2. 반드시 초기값을 넣어야 함 --%>
	<%-- 3. 변수의 scope => EL, JSTL 내에서는 사용 가능, 스크립틀릿(<% %>)에서는 사용 불가 / 반대는 가능 --%>
	<c:set var="num3" value="10" scope="page" /> <%-- scope 지정 안 하면 기본값 page --%>
	<c:set var="num4" value="20" />
	<c:set var="plus" value="${ num3 + num4 }"></c:set>
	
	<h2>(2) 변수 출력</h2>
	<c:set var="result" value="<b>안녕</b>" />
	<c:out value="${ result }" />
	<c:out value="${ result }" escapeXml="false" />
	
	<h2>(3) 조건문: if</h2>
	<c:if test="${ num3 le num4 }">
		<p>num3가 num4보다 작거나 같네요</p>
	</c:if>
	
	<h2>(4) 조건문: choose</h2>
	<c:choose>
		<c:when test="${ num3 gt 20 }">
			<p>num3이 20보다 큽니까?</p>
		</c:when>
		<c:when test="${ num3 ge 10 }">
			<p>num3이 20보다 작거나 같으면서, 10보다 크거나 같습니까?</p>
		</c:when>
		<c:otherwise>
			<p>
				1. num3이 20보다 작거나 같다
				2. num3이 10보다 작다
				=> num3이 10보다 작습니까?
			</p>
		</c:otherwise>
	</c:choose>
	
	<h2>(5) 반복문: forEach</h2>
	<%-- 기본 for문처럼 사용하기 --%>
	<c:forEach var="i" begin="1" end="10" step="2"> <%-- step을 명시하지 않으면 1씩 증가 --%>
		<p>반복 숫자: ${ i }</p>
	</c:forEach>
	
	<%-- 향상된 for문처럼 사용하기 --%>
	<%
		String[] colors = {"red", "green", "blue"};
		request.setAttribute("colors", colors);
	%>
	
	<ul>
		<c:forEach var="color" items="${ requestScope.colors }">
			<li style="color:${ color }">${ color }</li>
		</c:forEach>
	</ul>
	
	<%-- varStatus 속성 --%>
	<c:forEach var="num" begin="0" end="5" varStatus="vs">
		<p>
			숫자: ${ num }, 인덱스: ${ vs.index }, 카운트: ${ vs.count }, 첫번째?: ${ vs.first }, 마지막?: ${ vs.last }
		</p>
	</c:forEach>
	
	<h2>(6) 경로 지정: 기존 방법 vs JSTL 방법</h2>
	<%-- 기존 url 사용 방법 --%>
	<script src="<%= request.getContextPath() %>/resources/js/jQuery-3.7.1.js"></script>
	<a href="<%= request.getContextPath() %>/boardList"></a>
	
	<%-- JSTL c:url 사용 방법 --%>
	<script src="<c:url value='/resources/js/jQuery-3.7.1.js' />"></script>
	<a href="<c:url value='/boardList' />">게시판</a>
	
	<%-- 파라미터 사용하기 --%>
	<c:url var="testUrl" value="/boardList">
		<c:param name="nowPage" value="1" />
	</c:url>
	<a href="${ testUrl }">게시판</a>
	
	<h1>6. 사이트 테마 설정</h1>
	<form method="post" action="/setTheme">
    <button type="submit" name="theme" value="dark">다크모드</button>
    <button type="submit" name="theme" value="light">라이트모드</button>
	</form>

	<h1>8. JSTL Formatting Library</h1>
	<h2>(1) 숫자 정보 포매팅</h2>
	<fmt:formatNumber value="1234.567" type="number" /><br> <%-- 출력 기능을 포함함 --%>
	<fmt:formatNumber value="0.875" type="percent" /><br>
	
	<fmt:formatNumber value="1234.567" pattern="#,###.##" /><br>
	<fmt:formatNumber value="1234.5" pattern="00000.00" /><br>
	
	<h2>(2) 날짜 정보 포매팅</h2>
	<c:set var="now" value="<%= new java.util.Date() %>" />
	<fmt:formatDate value="${ now }" type="date" /><br>
	<fmt:formatDate value="${ now }" pattern="yy-MM-dd HH:mm:ss" /><br>
	
	<h1>9. JSTL Function Library</h1>
	<c:set var="data" value="How Are You? I am fine" />
	<p><c:out value="${ data }" /></p>
	<p><c:out value="${ fn:toUpperCase(data) }" /></p> <%-- JSTL fn은 EL 안에 작성 가능 --%>
	<p><c:out value="${ fn:replace(data, 'fine', 'apple') }" /></p>
	
	<h1>[과제] JSTL의 forEach 사용하여 별찍기</h1>
	<form action="/printStar" method="POST">
		<input type="number" name="starNum">
		<input type="submit" value="별 찍기">
	</form>
</body>

</html>