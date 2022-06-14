<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>변수 출력</title> 
	
</head>
<body>
	<H2>변수 선언과 출력</H2>
	<c:set var="varName" value="varValue"/>
	varName : ${varName }<br>
	<c:set var="varName" value="abc<varValue>"/>
	varName : ${varName }<br>
	 <!-- c:out / 변수출력 : escapeXml="true" : 특수문자 인식  -->
	varName : <c:out value="${varName }" escapeXml="true"></c:out><br>
	<c:remove var="varName"/><!-- 변수 삭제 -->
	varName : ${varName }<br>
	varName : ${empty varName? "삭제된거냐":"남아있냐" }<br>
	varName : <c:out value="${varName }" default="없어진 변수"></c:out>
</body>
</html>

















