<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<h2>ex02_scope.jsp 페이지입니다</h2>
	<h3>페이지 내  속성 변수값 : ${pageName }  </h3>
	<h3>request  속성 변수값 : ${requestName }  </h3>
	<h3>session  속성 변수값 : ${sessionName } </h3>
	<h3>application  속성 변수값 : ${applicationName } </h3>
	<br>
	<hr>
	<br>
	<h3>이름 : ${param.name } </h3>
	<h3>ID : ${param.id } </h3>
	<h3>비밀번호 : ${param.pw } </h3> 
</body>
</html>