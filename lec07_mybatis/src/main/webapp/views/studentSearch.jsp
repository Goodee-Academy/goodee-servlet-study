<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>검색 결과</title>
</head>

<body>
	<h2>===== 검색 결과 =====</h2>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach var="student" items="${ resultList }">
				<tr onclick="location.href='/student/detail?no=${student.studentNo}'">
					<td>${ student.studentNo }</td>
					<td>${ student.studentName }</td>
					<td>${ student.studentAge }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>