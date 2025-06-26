<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Account"%>
<%
	String name = "";
	if (session != null) {
		if (session.getAttribute("account") != null) {
			Account account = (Account) session.getAttribute("account");
			name = account.getUserName();
		}
	}
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Cookie And Session</title>
</head>

<body>
	<h1>[연습] 로그인, 로그아웃</h1>
	<% if ("관리자".equals(name)) { %>
		<p><%= name %>님 환영합니다!<p>
		<a href="/logout">로그아웃</a>
	<% } else { %>
	<form action="/login" method="post">
		<label for="login_id">아이디 : </label>
		<input type="text" name="inputId" id="login_id"><br>
		<label for="login_pw">비밀번호 : </label>
		<input type="password" name="inputPw" id="login_pw">
		<input type="submit" value="로그인">
	</form>
	<% } %>

	<h1>Cookie</h1>
	<ul>
		<li>
			<a href="/makeCookie">쿠키 생성</a>
		</li>
		<li>
			<a href="/editCookie">쿠키 수정</a>
		</li>
		<li>
			<a href="/deleteCookie">쿠키 삭제</a>
		</li>
	</ul>
	
	<h2>현재 쿠키 값 확인</h2>
	<%
		// 1. 클라이언트가 보낸 쿠키 배열 가져오기
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if ("user_id".equals(cookie.getName())) {
					userId = cookie.getValue();
					break;
				}
			}
		}
	%>
	
	<p>user_id 쿠키 값: <%= userId %></p>
	
	<h1>실습</h1>
	<ul>
		<li>
			<a href="/practiceCookie">쿠키 연습하기</a>
		</li>
	</ul>
	
	<h1>과제</h1>
	<a href="/changePage">방문 횟수 추적하기</a>
	
	<h1>Session</h1>
	<ol>
		<li>
			<a href="/createSession">세션 생성</a>
		</li>
		<li>
			<a href="/updateSession">세션 수정</a>
		</li>
		<li>
			<a href="/removeSession">세션 삭제</a>
		</li>
	</ol>
	
	<%
		String memberId = "세션 없음";
		if (session != null) {
			if (session.getAttribute("member_Id") != null) {
				memberId = (String) session.getAttribute("member_Id");
			}
		}
	%>
	<p>세션 정보: <%= memberId %></p>
	
	<h1>과제: 장바구니에 담기</h1>
	<a href="/productList">상품 목록 페이지</a>
	<br>
	<a href="/cartList">장바구니 페이지</a>
</body>

</html>