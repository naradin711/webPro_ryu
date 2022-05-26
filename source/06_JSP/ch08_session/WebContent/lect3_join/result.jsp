<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입 결과</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	String msg = request.getParameter("msg");
%>	
<%if("success".equals(msg)){ %>
	<h1>가입이 완료되었습니다.</h1>
<%}else { %>
	<h1>가입이 취소되었습니다.</h1>
	<a href="join.jsp">가입화면으로</a>
<%} %>
<br>
<hr>
<button onclick="location.href='login.jsp'">로그인</button>
</body>
</html>