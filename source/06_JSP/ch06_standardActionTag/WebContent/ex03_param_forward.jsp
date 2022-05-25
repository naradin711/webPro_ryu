<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex03_param_forward.jsp?n=1 -->
	<h2>ex03_param_forward.jsp 페이지 입니다. </h2>
	<jsp:forward page="ex04.jsp">
		<jsp:param value="hong" name="id"/>
		<jsp:param value="1111" name="pw"/>
	</jsp:forward>
</body>
</html>















