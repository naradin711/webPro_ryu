<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지시자</title>
	<link hidden="../css/join.css" rel="stylesheet">
</head>
<body>
<%
	int [] arr = {10, 20, 30};
	out.println(Arrays.toString(arr));
%>
	<div id="header"> </div>
	<h1>회원가입페이지</h1>
	<hr>
	<%@ include file="../member/footer.jsp" %>
	<hr>
	다시 ex03_지시자.jsp로 옮긴다.
</body>
</html>

















