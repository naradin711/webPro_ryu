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
	<title>유저의 방문횟수</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
<c:set var="visitNum" value="${param.visitNum }"/>
<c:if test="${visitNum eq 0 }">
<h2>처음 방문하셨군요! 환영합니다!</h2>
</c:if>
<c:if test="${visitNum > 0 && visitNum<5 }">
<h2>더 자주 뵙고 싶네요!</h2>
</c:if>
<c:if test="${visitNum >=5 }">
<h2>${visitNum}번째 방문 감사드립니다! 자주 와주셔서 감사드립니다.</h2>
</c:if>
<c:if test="${visitNum < 0 }">
<h2>유효한 방문 횟수가 아닙니다</h2>
</c:if>
</body>
</html>

















