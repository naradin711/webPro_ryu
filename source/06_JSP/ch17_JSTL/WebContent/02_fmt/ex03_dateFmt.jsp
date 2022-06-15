<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
	<title>ex03_dateFmt </title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTime" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowDateUtil" value="<%= new java.util.Date() %>"/>
	${nowDate } <br>
	${nowTime } <br>
	${nowDateUtil } <br>
	<h3>날짜만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/> <br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/> <br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/> <br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/> <br><br>
	
	<h3>시간만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/> <br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/> <br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/> <br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/> <br><br>
	
	<h3>둘 다 출력</h3>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="short" timeStyle="short" /><br>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="medium" timeStyle="medium" /><br>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="long" /><br>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="full" timeStyle="full" /><br>
	<fmt:formatDate value="${nowDate }" pattern="yyyy년 MM월 dd일 (E요일) hh:mm:ss:SS(a)" /><br>
	<fmt:formatDate value="${nowDate }" pattern="yy-MM-dd(E) HH:mm:ss" /><br>
	
	
</body>
</html>







