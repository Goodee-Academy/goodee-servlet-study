<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>

<body>
	<h1>1. JSP Scripting Element</h1>
	<a href="./views/scripting_element.jsp">
		스크립팅 요소 연습
	</a>
	<br>
	<h1>2. Directive Tag (page)</h1>
	<!-- <a href="./views/page_element.jsp">
		Page Tag 연습
	</a> -->
	<a href="/pageView"> <!-- Servlet을 통한 화면 전환 -->
		Page Tag 연습
	</a>
	
	<br>
	<h1>3. Directive Tag (include)</h1>
	<a href="./views/include_element.jsp">
		Include Tag 연습
	</a>
	<br>
	<h1>실습</h1>
	<a href="/bookReserve">
		도서 대출하기
	</a>
</body>

</html>