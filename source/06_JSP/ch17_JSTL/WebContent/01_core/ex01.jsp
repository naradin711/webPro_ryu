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
	<title>Core</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<h2>core 라이브러리 </h2><br>
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>${i }번째, 안녕 클레오파트라 세상에서 제일 예쁜 포테이토칩!</p>
	</c:forEach>
	<br>
	<hr>
	<br>
	<h2>fmt(formatting) 라이브러리 </h2> <br>
	<fmt:formatNumber value="1687.12712" pattern="#,###.00"/>
	<br>
	<hr>
	<br>
	<h2>그외의 functions 라이브러리 </h2> <br> <!-- fn라이브러리는 el표기법 사용 -->
	ID 파라미터를 대문자로 : ${fn:toUpperCase(param.id) }
</body>
</html>

















