<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<form action="textMail" width=500px>
		<p><input type="text" name="name" required="required"></p>
		<p><input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입(TEXT 단순 메일 값)">
	</form>
	<hr color="green">
	<form action="htmlMail" width=500px>
		<p><input type="text" name="name" required="required"></p>
		<p><input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입(html 단순 메일 값)">
	</form>
</body>
</html>




