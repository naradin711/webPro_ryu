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
	<title>SELECT</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<c:if test="${insertResult == 1}" >
		<script type="text/javascript"> alert('insert 성공');</script>
		<h2>작성 완료</h2>
	</c:if>
	<c:if test="${deleteResult == 1}" >
		<script type="text/javascript"> alert('delete 성공');</script>
		<h2>삭제 완료</h2>
	</c:if>
	<c:if test="${updateResult == 1}" >
		<script type="text/javascript"> alert('update 성공');</script>
		<h2>수정 완료</h2>
	</c:if>
	<h1>select.jsp입니다</h1>
	<h2>Select 결과입니다. ${list }</h2>
</body>
</html>