<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@page import="java.util.List"%>

<%@page import="com.gn.dto.Student"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>학생 목록 조회</title>
</head>

<body>
	<h2>===== 학생 리스트 =====</h2>
	<c:forEach var="i" begin="0" end="${ studentList.size() - 1 }">
		<li>학번: ${ studentList.get(i).getStudentNo() }, 이름: ${ studentList.get(i).getStudentName() }, 나이: ${ studentList.get(i).getStudentAge() }</li>
	</c:forEach>
</body>

</html>