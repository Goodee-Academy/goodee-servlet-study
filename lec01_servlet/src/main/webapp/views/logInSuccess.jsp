<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>로그인 결과화면</title>
	
	<style>
		#login-container {
			width: 100vw;
			height: 100vh;
			background-color: #000000;
		}
		
		#login-container > div {
			width: 400px;
			height: 400px;
			background-color: #FFFFFF;
			
			margin: auto auto;
		}
	</style>
</head>

<body>
	<main>
		<article id="login-container">
			<div>
				<h1>반가워요 <%= request.getAttribute("id") %>님</h1>
				<h2>비밀번호가 <%= request.getAttribute("pw") %>이시네요~</h2>
				<a href="/">홈페이지로 이동</a>
			</div>
		</article>
	</main>
</body>

</html>