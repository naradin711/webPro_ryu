<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style1.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
<jsp:setProperty property="*" name="p"/>
<jsp:forward page="pVIew.jsp"/>
</body>
</html>



















