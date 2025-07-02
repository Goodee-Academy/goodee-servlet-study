<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	
	<script src="<c:url value='/resources/js/jQuery-3.7.1.js' />"></script>
</head>

<body>
	<h1>회원 가입</h1>
	<%@ include file="/views/include/nav.jsp" %><br>
	
	<form id="createMemberFrm">
		<input type="text" id="member_id" placeholder="아이디"> <br>
		<input type="password" id="member_pw" placeholder="비밀번호"> <br>
		<input type="password" id="member_pw_check" placeholder="비밀번호 확인"> <br>
		<input type="submit" value="회원가입"> 
	</form>
	
	<script>
		$(document).ready(() => {
			$("#createMemberFrm").submit((event) => {
				event.preventDefault();
				
				// 1. 사용자 입력값 가져오기
				const memberId = $("#member_id").val();
				const memberPw = $("#member_pw").val();
				const memberPwChk = $("#member_pw_check").val();
				
				// 2. 유효성 검사(비어있는 값이 아닐 것, 정규식을 통과할 것, ...)
				const idRegex = /^[a-z0-9]{4,12}$/;
				const pwRegex = /^[a-zA-Z0-9!@#$%^&*]{4,20}$/;
				
				if (!memberId) {
					alert("아이디를 입력하세요.");
				} else if (!idRegex.test(memberId)) {
					alert("아이디는 영문 소문자와 숫자로 구성된 4자 이상 12자 이하의 문자만 사용 가능합니다.");
				} else if (!memberPw) {
					alert("비밀번호를 입력하세요.");
				} else if (!pwRegex.test(memberPw)) {
					alert("비밀번호는 영문 대소문자와 숫자, 특수문자(!, @, #, $, %, ^, &, *)로 구성된 4자 이상 20자 이하의 문자만 사용 가능합니다.");
				} else if (memberPw !== memberPwChk) {
					alert("비밀번호가 일치하지 않습니다.");
				} else {
					// 3. ajax로 회원 가입 요청 전송
					$.ajax({
						url : "/memberCreate",
						type : "POST",
						data : {
							memberId : memberId,
							memberPw : memberPw
						},
						dataType : "JSON",
						success : function(data) {
							alert(data.res_msg);
						},
						error : function() {
							
						}
					});
				}
				
			});
		});
	</script>
</body>

</html>