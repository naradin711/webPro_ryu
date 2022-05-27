<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%response.setStatus(200); %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error 500</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	
</head>
<body>
	<h2>공사 중입니다. 빠른시일내로 복구하겠습니다.</h2>
	<h3>관리자 문의 : hong@hong.com</h3>
<%
	System.out.println(exception.getMessage());
	System.out.println(exception.getClass().getName());
%>	
</body>
</html>