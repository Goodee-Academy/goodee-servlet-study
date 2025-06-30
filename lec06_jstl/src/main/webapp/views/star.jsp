<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Stars</title>
</head>

<body>
	<c:set var="number" value="${ requestScope.number }" />
	
	<c:forEach var="i" begin="1" end="${ number }">
		<c:forEach var="j" begin="1" end="${ i }">
			⭐
		</c:forEach>
		<br>
	</c:forEach>
</body>

</html>