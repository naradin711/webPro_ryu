<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Home</title>
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
<h1>
	Hello world!  
</h1>
<h1>
	${greeting} 
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>2022년 7월 14일</p>
<p><img src="${conPath }/img/faker.png" alt="test"></p>
</body>
</html>
