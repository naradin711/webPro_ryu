<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex06_param_include.jsp의 페이지입니다.</h1>
	<hr>
	<jsp:include page="ex04.jsp">
		<jsp:param value="1" name="n"/>
		<jsp:param value="Faker" name="id"/>
		<jsp:param value="1111" name="pw"/>
	</jsp:include>
	<hr>
	<h1>또 다시 ex06_param_include.jsp의 페이지입니다.</h1>
</body>
</html>