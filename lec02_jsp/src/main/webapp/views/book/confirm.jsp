<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 윗부분에서 미리 가져와도 됨
	String book = (String) request.getAttribute("book");
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>도서 대출 결과</title>
</head>

<body>
	<h1>도서 대출 내역</h1>
	<h4>[고객 정보]</h4>
	<ul>
		<li>고객명: <%= request.getAttribute("name") %></li>
		<% String phone = (String) request.getAttribute("phone"); // getAttr로 가져올 때 Object형으로 가져옴 %>
		<li>전화번호: <%= phone %></li>
		<li>이메일: <%= request.getAttribute("email") %></li>
	</ul>

	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목: <%= book %></li>
		<li>대출 기간: <%= request.getAttribute("period") %>일</li>
	</ul>

	<h3>대출 금액: <%= request.getAttribute("price") %>원</h3>
</body>

</html>