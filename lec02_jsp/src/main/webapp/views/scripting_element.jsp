<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Scripting</title>
</head>

<body>
	<%-- Scriptlet: 일반적인 Java 코드 --%>
	<% 
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		
		out.println("총합: " + sum); // JSP 내장 객체 사용
	%>
	<br>
	
	<%-- Expresstion: 화면에 출력 --%>
	<%= "총합: " + sum %> <%-- ";" 쓰면 안됨 + 출력 전용 --%>
	<br>
	
	<%-- Declaration: 선언 --%>
	<%! int visitCount = 0; // Declaration으로 변수 선언 => 컴파일때 딱 한 번 실행됨 (새로고침 해도 유지) %>
	<% 
		int tempCount = 0; // Scriptlet으로 변수 선언 => 해당 jsp가 실행될 때마다 실행됨 (새로고침하면 변수를 다시 선언)
		visitCount++;
		tempCount++;
	%>
	
	<p>Declaration 태그: <%= visitCount %></p>
	<p>Scriptlet 태그: <%= tempCount %></p>
</body>

</html>