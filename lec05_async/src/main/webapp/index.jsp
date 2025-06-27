<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>비동기 연습하기</title>
	
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
	<h1>1. Text Data</h1>
	<h2>(1) GET 방식</h2>
	<br>
	<input type="text" name="user_id" id="user_id">
	<input type="button" value="ID 길이 구하기" id="ajax_get_btn">
	<div id="ajax_get_div"></div>
	
	<script>
		$(document).ready(() => {
			$("#ajax_get_btn").click(() => {
				console.log("1: 클릭 이벤트 동작");
				const userId = $("#user_id").val();
				console.log("2: 사용자 정보가 받아와졌는지 확인");
				
				$.ajax({
					url : "/getTextAjax?userId=" + userId,
					type : "get",
					success : function(data) {
						console.log("3: 요청 정상 동작 여부");
						// $("#ajax_get_div").html(data);
						
						const h3 = $('<h3>').text(data);
						$("#ajax_get_div").html(h3);
					},
					error : function() {
						alert("요청 실패!!");
					}
				});
			});
		});
	</script>
	
	<h2>(2) POST 방식</h2>
	<button type="button" id="ajax_post_btn">아이디 길이 구하기 ver.2</button>
	<div id="ajax_post_div"></div>
	
	<script>
		$(document).ready(() => {
			$("#ajax_post_btn").click(() => {
				const userId = $("#user_id").val();
				
				$.ajax({
					url : "/postTextAjax",
					type : "post",
					data : {
						userId : userId
					},
					success : function(data) {
						const p = $("<p>").text(data);
						$("#ajax_post_div").html(p);
					},
					error : function() {
						alert("요청 실패!!");
					}
				});
			});
		});
	</script>
	
	<h1>과제: 총점과 평균</h1>
	<h2>성적 계산기</h2>

	<label for="kor">국어 : </label>
	<input type="number" id="kor"><br>

	<label for="eng">영어 : </label>
	<input type="number" id="eng"><br>

	<label for="math">수학 : </label>
	<input type="number" id="math"><br>

	<button id="btnPost">계산</button>

	<div id="resultArea"></div>
	
	<script>
		$(document).ready(() => {
			$("#btnPost").click(() => {
				const korPoint = $("#kor").val();
				const engPoint = $("#eng").val();
				const mathPoint = $("#math").val();
				
				$.ajax({
					url : "/gradeCalculator",
					type : "POST",
					data : {
						korPoint : korPoint,
						engPoint : engPoint,
						mathPoint : mathPoint
					},
					success : function(data) {
						$("#resultArea").html(data);
					},
					error : function() {
						alert("오류 발생!!");
					}
				});
			});
		});
	</script>
	
	<h1>JSON + AJAX</h1>
	<input type="text" id="searchName">
	<button type="button" id="json_get_btn">조회</button>
	<div id="json_get_div"></div>
	
	<script>
		$(document).ready(() => {
			$("#json_get_btn").click(() => {
				// 1. 사용자 이름 정보 가져오기
				const keyName = $("#searchName").val();
				
				// 2. get 방식 (비동기) 요청
				
				$.ajax({
					url : "/searchAccount?keyName=" + keyName,
					type: "GET",
					dataType: "json",
					success: function(data) {
						// 4. 화면에 목록 형태로 출력 (data가 json 타입이면 parse를 미리 해서 줌)
						// const no = data.no;
						// const name = data.name;
						
						// $("#json_get_div").append("<p>" + no + "번: " + name + "</p>");
						
						// JSON 배열로 받기
						if (data.jsonArr.length != 0) {
							for (let i = 0; i < data.jsonArr.length; i++) {
								const account = data.jsonArr[i];
								
								$("#json_get_div").append("<p>" + account.no + "번: " + account.name + "</p>");
							}
						}
					},
					error: function() {
						alert("오류 발생!!");
					}
				});
				
				
			});
		});
	</script>
	
	<h1>연습: JSON+Ajax+Get 방식으로 도서 검색하기</h1>
	<h2>도서 검색</h2>
	<label>도서명: </label>
	<input type="text" id="searchBook">
	<button id="book_get_btn">조회</button>
	<div id="book_get_div"></div>
	
	<script>
		$(document).ready(() => {
			$("#book_get_btn").click(() => {
				const keyword = $("#searchBook").val();
				
				$.ajax({
					url : "/searchBook?keyword=" + keyword,
					type : "GET",
					dataType : "json",
					success : function(data) {
						if (data.jsonArr.length != 0) {
							for (let i = 0; i < data.jsonArr.length; i++) {
								const book = data.jsonArr[i];
								
								$("#book_get_div").append("<p>" + book.bookNo + " : " + book.bookTitle + " - " + book.author + "</p>");
							}
						} else {
							alert("검색 결과가 없습니다.");
						}
					},
					error : function() {
						alert("오류 발생!!");
					}
				});
			});
		});
	</script>
	
	<h1>카테고리별 상품 조회</h1>
	<select id="categorySelect">
		<option value="1">전자제품</option>
		<option value="2">생활용품</option>
		<option value="3">패션</option>
	</select>
	<button type="button" id="searchBtn">조회</button>
	<div id="productListArea"></div>
	
	<script>
		$(() => {
			$("#categorySelect").change((event) => {
				// 1. 선택된 카테고리 정보 가져오기
				const categoryCode = $(event.target).val();
				
				// 2. ajax 통신을 통해 목록 조회
				$.ajax({
					url : "/searchProduct",
					type : "POST",
					data : {
						code : categoryCode
					},
					dataType : "json",
					success : function(data) {
						// 3. 화면에 목록 출력
						$("#productListArea").empty();
						
						if (data.jsonArr.length == 0) {
							$("#productListArea").html("해당 카테고리의 상품이 없습니다.");
						} else {
							for (let i = 0; i < data.jsonArr.length; i++) {
								const product = data.jsonArr[i];
								
								$("#productListArea").append("<p>" + product.name + "은 " + product.price + "원 입니다.</p>");
							}
						}
					},
					error : function() {
						alert("오류 발생!!");
					}
				});
				
			});
		});
	</script>
	
	<h1>[과제] 방명록 비동기 통신</h1>
	<a href="/moveCommentPage">방명록 페이지로 이동</a>
</body>

</html>