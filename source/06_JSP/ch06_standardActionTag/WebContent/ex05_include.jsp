<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% String conPath = request.getContextPath(); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex05_include.jsp 페이지입니다.</h1>
	<hr>
	<%//@ include file="ex05_includePage.jsp"  %>  <!-- jsp 파일 원본 그대로 -->
	<jsp:include page="ex05_includePage.jsp"/> <!-- jsp 파일의 결과를 -->
	<hr>
	<h1>ex05_include.jsp 페이지입니다.</h1>
	<hr>
	<jsp:include page="ex05_includePage.jsp"/> <!-- jsp 파일의 결과를-->
	<hr>
	<h1>ex05_include.jsp 페이지입니다.</h1>
</body>
</html>