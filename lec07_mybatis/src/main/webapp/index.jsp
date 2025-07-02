<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>MyBatis</title>
</head>

<body>
	<%-- 
		1. index.jsp에 목록 조회 태그 생성
		2. 목록 조회 요청을 받는 Servlet(Controller) 생성
	--%>
	
	<ol>
		<li>
			<a href="<c:url value='/student/list' />">학생 목록 조회</a>
		</li>
	</ol>
	
	<%-- 입력된 이름이 포함된 모든 학생의 정보를 화면 또는 콘솔에 출력 --%>
	<%-- 화면 출력의 경우 studentSearch.jsp로 보내서 출력 --%>
	
	<form action="<c:url value='/student/search' />" method="get">
		<input type="text" name="student_name">
		<input type="submit" value="이름 기준 검색">
	</form>
	
	<br><br>
	
	<%-- 상품명과 카테고리 기준 상품 검색 --%>
	<form action="<c:url value='/product/search' />" method="GET">
		<label for="product_name">상품명: </label>
		<input type="text" name="productName" id="product_name">
		
		<label for="product_category">카테고리: </label>
		<select name="productCategory" id="product_category">
			<option value="0" selected>-- 선택하세요 --</option>
			<option	value="1">전자제품</option>
			<option value="2">의류</option>
			<option value="3">식품</option>
		</select>
		
		<label for="sort">정렬 기준: </label>
		<select name="sort" id="sort">
			<option value="0" selected>-- 선택하세요 --</option>
			<option value="1">가격 낮은 순</option>
			<option value="2">가격 높은 순</option>
		</select>
		<input type="submit" value="검색">
	</form>
</body>

</html>