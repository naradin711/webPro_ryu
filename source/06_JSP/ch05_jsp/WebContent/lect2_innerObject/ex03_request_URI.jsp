<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>URI 사용</title>
</head>
<body>
	<h2>Context Path = <%=conPath %> </h2>
	<hr>
	<a href="<%=conPath %>/Ex03">Ex03_Servlet</a> <br>
	<button onclick="location.href='<%=conPath %>/Ex03'">Ex03_Servlet</button>
</body>
</html>



















