<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Include Tag</title>
</head>

<body>
	<h2> === Start ===</h2>
	<%@ include file="./scripting_element.jsp" %>
	<h2> ==== End ====</h2>
	<% int multiple = sum * 3; %>
	<p>계산 결과: <%= multiple %></p>
</body>

</html>