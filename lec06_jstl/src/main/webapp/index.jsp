<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.gn.dto.Person" %>
<%@ page import="com.gn.dto.Planet"%>
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
</body>

</html>