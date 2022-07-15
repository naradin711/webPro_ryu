<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	
	<h2>검증이 완료된 결과 페이지입니다.</h2>
	<h3>"현재 총 ${cnt }명"</h3>
	<h3>이름 : ${student.name }</h3>
	<h3>국어  : ${student.kor}</h3>
	<h3>영어  : ${student.eng}</h3>
	<h3>수학  : ${student.mat}</h3>
	<h3>총점  : ${student.kor + student.eng + student.mat  }</h3>
	<h3>평균  : ${Math.round(((student.kor + student.eng + student.mat)/3)*10)/10.00 }</h3>
	<button onclick="history.back()">뒤로 가기</button>
	<button onclick="location.href='${conPath}/inputForm2.do'">처음으로</button>
</body>
</html>