<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>${greeting }</h1>
	<hr>
	<h3>Board 관련 요청 경로 </h3>
	<h4><a href="${conPath }/board/write">Board의 write로 가기</a></h4>
	<h4><a href="${conPath }/board/content">Board의 content로 가기</a></h4>
	<h4><a href="${conPath }/board/list">Board의 list로 가기</a></h4>
	<h4><a href="${conPath }/board/reply">Board의 reply로 가기</a></h4>
	<br>
	<hr>
	<br>
	<h3>Member 관련 요청 경로 </h3> 
	<button onclick="location.href='${conPath}/member?method=join'">회원가입</button>
	<button onclick="location.href='${conPath}/member?method=login'">로그인</button>
	<button onclick="location.href='${conPath}/member?method=logout'">로그아웃</button>
	<button onclick="location.href='${conPath}/member?method=modify'">정보수정</button>  
</body>
</html>