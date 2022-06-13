<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 목 록</title>
	<link href="<%=conPath %>/css/style1.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<table><tr>
<%
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.listBook();
	for (int i=0 ; i<books.size() ; i++){
%>
	<td>
		<img src="../bookImg/<%=books.get(i).getBimage1()%>"><br>
		<%=books.get(i).getBtitle() %><br>
		<del><%=books.get(i).getBprice() %></del> (<%=books.get(i).getBdiscount()%>%할인)<br>
		<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %></b>
	</td>
	<%if(i%3==2) out.println("</tr><tr>"); // %>
 <% } %>
 	</tr></table>
</body>
</html>