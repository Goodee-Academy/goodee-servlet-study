<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>닉네임 저장하기</title>
</head>

<body>
	<h1>닉네임 저장하기</h1>
	
	<%
		Cookie[] cookies = request.getCookies();
		String nickname = "____";
		
		for (Cookie cookie : cookies) {
			if ("nickname".equals(cookie.getName())) {
				nickname = cookie.getValue();
				break;
			}
		}
	%>
	
	<h2>닉네임: <%= nickname %></h2>
	<form action="/saveNick" method="POST">
		<input type="text" name="nickname">
		<button>닉네임 저장</button>
	</form>
	<form action="/removeNick" method="POST">
		<button>닉네임 삭제</button>
	</form>
</body>

</html>