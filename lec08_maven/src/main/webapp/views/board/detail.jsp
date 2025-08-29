<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 상세 보기</title>
	
	<script src="<c:url value='/resources/js/jQuery-3.7.1.js' />"></script>
</head>

<body>
	<h1>== 게시판 ==</h1>
	<%@ include file="/views/include/nav.jsp" %>

	<p>제목 : ${ board.boardTitle }</p>
	<p>작성자 : ${ sessionScope.memberMap.get(board.boardWriter).getMemberId() } </p>
	<p>내용 : ${ board.boardContent } </p>
	<p>작성일 : ${ board.boardRegDate } </p>
	
	<c:if test="${ not empty attach }">
	    <h4>첨부파일</h4>
	    <img src="<c:url value='/filePath?attachNo=${ attach.attachNo }' />"><br>
	    <a href="<c:url value='/fileDownload?attachNo=${ attach.attachNo }' />">${ attach.originName } 다운로드</a>
	</c:if>
</body>

</html>