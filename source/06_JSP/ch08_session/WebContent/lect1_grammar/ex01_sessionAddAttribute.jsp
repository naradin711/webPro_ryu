<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	<style type="text/css">
		body {
			text-align: center;
		}
	</style>
</head>
<body>
<%//세션에 속성 추가 (객체타입으로 추가)
	session.setAttribute("sessionName", "sessionValue");
	session.setAttribute("myNum", 123);
	
%>
<br>
<h1>세션에 sessionName 속성추가</h1>
<h1>세션에 myNum 속성추가</h1>
<a href="ex02_sessionGet.jsp">세션 GET!</a>
</body>
</html>

















