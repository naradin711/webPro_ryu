<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한줄 메모장</title>
	 
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String memo = request.getParameter("memo");
		String ip = request.getRemoteAddr(); //요청한 클라이언트의 ip주소
		Date date = new Date(System.currentTimeMillis());
		response.setContentType("text/html ; charset=utf-8");
	%>
	
	<h2>글쓴이 	: <%=writer %></h2>
	<h2>한줄메모 	: <%=memo %></h2>
	<h2>글쓴 ip 	: <%=ip %></h2>
	<h2>글쓴시점	: <%=date %></h2>
</body>
</html>