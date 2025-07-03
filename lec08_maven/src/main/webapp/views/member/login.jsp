<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	
	<script src="<c:url value='/resources/js/jQuery-3.7.1.js' />"></script>
</head>

<body>
	<h1>== 로그인 ==</h1>
	<%@ include file="/views/include/nav.jsp" %><br>
	
	<form id="memberLoginFrm">
    <input type="text" id="member_id" placeholder="아이디"><br>
    <input type="password" id="member_pw" placeholder="비밀번호"><br>
    <input type="submit" value="로그인">
  </form>
  
  <script>
  	$(document).ready(() => {
  		$("#memberLoginFrm").submit((event) => {
  			event.preventDefault();
  			
  			// 1. 사용자가 입력한 값 가져오기
  			const memberId = $("#member_id").val();
  			const memberPw = $("#member_pw").val();
  			
  			// 2. 유효성 검사
  			if (!memberId) {
  				alert("아이디를 입력해주세요.");
  			} else if (!memberPw) {
  				alert("비밀번호를 입력해주세요.");
  			} else {
  				// 3. ajax로 로그인 요청
  				$.ajax({
  					url : "/memberLogin",
  					type : "POST",
  					data : {
  						memberId : memberId,
  						memberPw : memberPw
  					},
  					dataType : "JSON",
  					success : function(data) {
  						alert(data.res_msg);
  						
  						if (data.res_code == 200) {
  							location.href = "<%= request.getContextPath() %>/";
  						}
  					},
  					error : function() {
  						alert("오류 발생!!");
  					}
  				});
  			}
  		});
  	});
  </script>
</body>

</html>