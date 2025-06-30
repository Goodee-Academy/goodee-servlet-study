<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>MyBatis</title>
</head>

<body>
	<%-- 
		1. index.jsp에 목록 조회 태그 생성
		2. 목록 조회 요청을 받는 Servlet(Controller) 생성
	--%>
	
	<ol>
		<li>
			<a href="<c:url value='/student/list' />">학생 목록 조회</a>
		</li>
	</ol>
</body>

</html>