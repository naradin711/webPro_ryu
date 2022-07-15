<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Form</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="${conPath }/input2.do" method="get">
		<p>이름 : <input type="text" name="name" value=${student.name }> </p>	
		<input type="hidden" name="id" value='1' >
		<p>국어 : <input type="number" name="kor" value=${student.kor }  > </p>
		<p>영어 : <input type="number" name="eng" value=${student.eng }  > </p>
		<p>수학 : <input type="number" name="mat" value=${student.mat }  > </p>  
		<input type="submit" value="제출하기">		
	</form>
	<hr><br>
	<h4>${nameError }</h4>
	<h4>${korError }</h4>
	<h4>${engError }</h4>
	<h4>${matError }</h4>
</body>
</html>