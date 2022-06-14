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
	<title>Insert Title here</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<H2>예외처리</H2>
	<c:catch var="error"><!-- catch절에서 예외가 발생할 경우 예외 타입과 예외 메세지가 error저장 -->
	<H2>테스트</H2>
	<%=8/0 %>
	<p>예외가 발생되면 예외가 발생되는 즉시 catch절을 빠져나감. 이 태그 출력시 예외가 발생안됨</p>
	</c:catch>
	예외 타입과 예외 메시지 : <c:out value="${error }" default="예외 발생 없음"></c:out>
</body>
</html>














