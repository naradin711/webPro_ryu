<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>누적값을 구할 숫자 입력</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<%int a = 5; %>
	<h2> a : <%=a %></h2>
	<h2> a : ${a } (안나오는가)</h2>
	<!-- <form action="ex03_suPro.jsp"> -->
	<form action="<%=conPath %>/Ex03">
		누적을 원하는 수 <input type="number" min="1" name="su" required="required">
		<input type="submit" value="누적">
	</form>
</body>
</html>
















