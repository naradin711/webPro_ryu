<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	
</head>
<body>
	<%
	Cookie[] cs = request.getCookies();
	if (cs!=null){
		for (Cookie c : cs){
			if(c.getName().equals("id")){
				//id 이름의 쿠키 삭제
				 c.setMaxAge(0);
				response.addCookie(c); 
				response.sendRedirect("main.jsp");
			} //if
		}//for
	}//if
	%>
</body>
</html>