<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudentId</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>studentId 페이지입니다.</h2>
	<h4>전송방식 : ${method } </h4>
	<h4>ID : ${id } </h4>
	<h4>파라미터로 넘어온 ID :  ${param.id }  </h4>
</body>
</html>





















