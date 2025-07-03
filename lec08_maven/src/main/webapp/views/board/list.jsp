<%@page import="com.gn.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	
	<script src="<c:url value='/resources/js/jQuery-3.7.1.js' />"></script>
</head>

<body>
	<h1>== 게시판 ==</h1>
	<%@ include file="/views/include/nav.jsp" %>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach var="board" items="${ boardList }">
				<tr>
					<td>${ board.boardNo }</td>
					<td>${ board.boardTitle }</td>
					<td>${ memberList.get(board.boardWriter).getMemberId() }</td>
					<td>${ board.boardRegDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="<c:url value='/boardWrite' />">게시글 등록</a>
</body>

</html>