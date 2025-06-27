<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>방명록</title>
	
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
	<h1>===== 방명록 =====</h1>
	<ul id="allComments"></ul>
	
	<h2>=== 방명록 작성 ===</h2>
	<label for="userName">이름: </label>
	<input type="text" id="userName">
	<br>
	<label for="userComment">내용: </label>
	<input type="text" id="userComment">
	<button type="button" id="ajaxPostComment">등록</button>
	
	<script>
		$(document).ready(() => {
			$("#ajaxPostComment").click(() => {
				const name = $("#userName").val();
				const comment = $("#userComment").val();
				
				if (name !== "" && comment !== "") {
					$.ajax({
						url : "/sendComment",
						type : "POST",
						data : {
							name : name,
							comment : comment
						},
						dataType : "json",
						success : function(data) {
							$("#allComments").append("<li>이름: " + data.name + "<br>작성 시간: " + data.date + "<br>내용: " + data.comment + "</li>");
							
							$("#userName").val("");
							$("#userComment").val("");
						},
						error : function() {
							alert("오류 발생!!");
						}
					});
				} else {
					alert("내용을 입력해주세요!!");
				}
			});
		});
	</script>
</body>

</html>