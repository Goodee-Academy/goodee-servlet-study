<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>상품 목록 페이지</title>
</head>

<body>
	<h1>=== 상품 정보=== </h1>
	
	<%
		List<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
	%>
	
	<form action="/addToCart" method="POST">
		<select name="product">
			<% for (Product product: productList) { %>
					<option value="<%= product.getCode() %>"><%= product.getName() %></option>
			<% } %>
		</select>
		<br><br>
		<button>장바구니에 추가</button>
	</form>
	<br>
	<a href="/cartList">장바구니 페이지</a>
</body>

</html>