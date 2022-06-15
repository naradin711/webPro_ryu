<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>INDEX</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<h1><a href="${conPath }/emplist">EMPLIST</a></h1><br><br>
	<h1><a href="${conPath }/empSch">EMPSEARCH</a></h1>
	<!-- EmpSch.javadhk empSch.jsp파일을 첨부해서 메일로 보내기 -->
</body>
</html>