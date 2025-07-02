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
	
	<%-- 입력된 이름이 포함된 모든 학생의 정보를 화면 또는 콘솔에 출력 --%>
	<%-- 화면 출력의 경우 studentSearch.jsp로 보내서 출력 --%>
	
	<form action="<c:url value='/student/search' />" method="get">
		<input type="text" name="student_name">
		<input type="submit" value="이름 기준 검색">
	</form>
</body>

</html>