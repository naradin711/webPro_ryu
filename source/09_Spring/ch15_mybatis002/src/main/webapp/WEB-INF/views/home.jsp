<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Home</title>
	<link href="${conPath }/css/board.css" rel="stylesheet">
</head>
<body>
<div align="center">
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</div>
</body>
</html>
