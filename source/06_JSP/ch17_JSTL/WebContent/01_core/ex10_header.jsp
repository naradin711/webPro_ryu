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
	<title>Header</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 사용자가 로그인 성공 : session.setAttribute("customer") -->
	<!-- 관리자가 로그인 성공 : session.setAttribute("admin") -->
	<% session.setAttribute("admin", "test"); %>
	<c:if test="${empty customer && empty admin }">
		<!-- 로그인 전메뉴 -->
		<ul>
		<li><a href="">로그인</a></li>
		<li><a href="">회원가입</a></li>
		<li><a href="">고객센터</a></li>
		</ul>
	</c:if>
	<c:if test="${not empty customer && empty admin }">
		<!-- 사용자의 로그인 후 -->
		<ul>
		<li><a href="">로그아웃</a></li>
		<li><a href="">회원정보</a></li>
		<li><a href="">고객센터</a></li>
		</ul>
	</c:if>
	<c:if test="${empty customer && not empty admin }">
		<!-- 관리자의 로그인 후 -->
		<ul>
		<li><a href="">로그아웃</a></li>
		<li><a href="">관리자정보</a></li>
		<li><a href="">고객센터</a></li>
		</ul>
	</c:if>
</body>
</html>