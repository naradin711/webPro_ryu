<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>member의 join.jsp 페이지입니다.</h2>
	<h3>${kind } 가입페이지</h3>
	<h2><span onclick="location.href='${conPath}/'">메인 페이지로 가기</span></h2>
</body>
</html>