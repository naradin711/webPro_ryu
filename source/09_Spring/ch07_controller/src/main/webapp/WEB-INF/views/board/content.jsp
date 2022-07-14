<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 쓰기</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>board의 content.jsp 페이지입니다.</h2>
	<br>
	<hr>
	<br>
	<h3>ID : ${id }</h3>
	<h3>PW : ${pw }</h3>
	<h3>${member } (toString()결과)</h3>
	<h3>member.getId() : ${member.id } </h3>
	<h3>member.getPw() : ${member.pw } </h3>
	<br> 
	<hr>
	<h2><span onclick="history.back()">이전 페이지</span></h2>

</body>
</html>