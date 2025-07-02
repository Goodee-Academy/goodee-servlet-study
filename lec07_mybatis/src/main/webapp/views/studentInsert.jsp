<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>학생 등록</title>
</head>

<body>
	<form action="<c:url value='/student/insert' />" method="POST">
		<label for="student_name">이름: </label>
		<input type="text" name="studentName" id="student_name">
		<br>
		<label for="student_age">나이: </label>
		<input type="number" name="studentAge" id="student_age">
		<br>
		<input type="submit" value="등록">
	</form>
</body>

</html>