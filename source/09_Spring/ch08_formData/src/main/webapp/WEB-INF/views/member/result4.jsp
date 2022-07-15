<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result1</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>항상 cnt, list 출력</h2>
	<h3>cnt : ${cnt }</h3>
	<h3>list : ${list } </h3>
	<h2>여기는 result4.jsp 페이지 입니다.</h2>
	<hr><br>
	<h4>이름 : ${member.name }</h4>
	<h4>아이디 : ${member.id }</h4>
	<h4>비밀번호 : ${member.pw }</h4>
	<h4>나이 : ${member.age }</h4>
	<h4>이메일 : ${member.email }</h4>
	<h4>주소 : ${member.address }</h4>
	<button onclick="history.back()">뒤로 가기 </button>
	<button onclick="location.href='${conPath}/'">메인 페이지로 </button>
</body>
</html>