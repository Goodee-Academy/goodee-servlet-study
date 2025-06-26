<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>장바구니 페이지</title>
</head>

<body>
	<h1>=== 장바구니 ===</h1>
	<%
		List<Product> myList = (ArrayList<Product>) session.getAttribute("myProduct");
	%>
	
	<% if (myList == null || myList.size() == 0) { %>
		<p>장바구니가 비어있습니다.</p>
	<% } else { %>
			<% for (Product product : myList) { %>
				<p>▶ 상품코드: <%= product.getCode() %> 상품명: <%= product.getName() %> 가격: <%= product.getPrice() %></p>
			<% } %>
	<% } %>
</body>

</html>