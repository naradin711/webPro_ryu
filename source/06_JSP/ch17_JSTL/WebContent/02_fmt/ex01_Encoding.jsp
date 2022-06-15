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
	<title>인코딩소스</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<fmt:requestEncoding value="utf-8"/>
	<%-- request.setCharacterEncoding("utf_8"); --%>
	<h2>이름 : ${param.name } </h2><!-- request.getParameter("name") -->
</body>
</html>
















