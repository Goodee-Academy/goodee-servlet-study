<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>방문 횟수 추적하기</title>
</head>

<body>

	<p> 당신은 이 페이지를
		<strong> <%= request.getAttribute("visitCount") %> </strong>번 방문했습니다.
	</p>
</body>

</html>