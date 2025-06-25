<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Filter</title>
</head>

<body>
	<h1>1. Filter 공부하기</h1>
	<form action="/receive/data" method="POST">
		<input type="text" name="test_data">
		<input type="submit" value="데이터 보내기">
	</form>
	<br>
	<form action="/receive/msg" method="POST">
		<textarea rows="3" cols="20" name="msg"></textarea>
		<button>보내기</button>
	</form>
	<h1>실습: 강제로 공지하기</h1>
	<form action="/board/write" method="POST">
    <input type="text" name="title" placeholder="제목 입력">
    <input type="submit" value="작성">
	</form>
	<h1>과제: Filter로 익명 처리하기</h1>
	<form action="/comment/write" method="post">
    <input type="text" name="writer" placeholder="작성자명 입력">
    <input type="submit" value="댓글 작성">
	</form>
</body>

</html>