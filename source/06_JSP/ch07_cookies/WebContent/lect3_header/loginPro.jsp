<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 성공</title>
	<link href="<%=conPath %>/css/login.css" rel="style" type="text/css">
</head>
<body>
	<%
		Boolean ok = false;
		String msg = "";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id!=null && pw!=null && id.equals("aaa") && pw.equals("111")){ //로그인처리
				Cookie cookie = new Cookie ("id", id);
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
				ok = true;
				System.out.println(cookie.getValue());
				response.sendRedirect("main.jsp");
				
		} else if (!pw.equals("111")){
				msg = "check the PW!";
		}  else if (!id.equals("aaa")) {
				msg = "check the ID!";
		}
		if (!ok) {
				response.sendRedirect("login.jsp?msg="+msg);
		} 
		%>
</body>
</html>