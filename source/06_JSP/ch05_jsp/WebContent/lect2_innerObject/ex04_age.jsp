<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	int age = Integer.parseInt(request.getParameter("age"));
	if (age>=19) {
		response.sendRedirect("ex04_pass.jsp?age="+age); //age를 parameter로 넣어서 숫자로 전송
	} else {
		response.sendRedirect("ex04_ng.jsp?age="+age); //age를 parameter로 넣어서 숫자로 전송
	}
	%>
</body>
</html>