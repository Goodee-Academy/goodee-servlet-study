<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Page Tag</title>
</head>

<body>
	<%
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("바나나");
	%>
	
	<h2>바구니 크기 : <%= list.size() %></h2>
	<ul>
		<%-- 1. 단순 하드코딩 출력 (매우 비효율적) --%>
		<li><%= list.get(0) %></li>
		<li><%= list.get(1) %></li>
	</ul>
	<ul>
		<%-- 2. 반복문 활용 출력 (비효율적) --%>
		<%
			for (int i = 0; i < list.size(); i++) {
				out.println("<li>" + list.get(i) + "</li>");
			}
		%>
	</ul>
	<ul>
		<%-- 3. 반복문 선언부와 내부 코드 분리 (Solution!) --%>
		<% for (int i = 0; i < list.size(); i++) { %>
			<li><%= list.get(i) %></li>
		<% } %>
	</ul>
</body>

</html>