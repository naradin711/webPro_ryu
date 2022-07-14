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
	<h2>board의 list.jsp 페이지입니다.</h2>
	<hr>
	<c:if test="${list.size() eq 0 }">
		<h3>입력된 멤버가 없습니다.</h3>
	</c:if>
	<c:if test="${list.size() != 0 }">
		<c:forEach var="member" items="${list }">
			<h3>ID : ${member.id } / pw : ${member.pw }</h3>
		</c:forEach>
		<h3>이상 ${list.size() }명이 있습니다.</h3>
	</c:if>
	<h2><span onclick="location.href='${conPath}/'">메인 페이지로 가기</span></h2>

</body>
</html>