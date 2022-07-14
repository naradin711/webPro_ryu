<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${result }</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>member의 ${result } 페이지입니다.</h2>
	<h3>${result } Process</h3>
	<h2><span onclick="location.href='${conPath}/'">메인 페이지로 가기</span></h2>
</body>
</html>