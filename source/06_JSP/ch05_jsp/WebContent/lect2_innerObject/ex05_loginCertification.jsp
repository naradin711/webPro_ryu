<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
<%

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if (id==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
		String msg = "아이디와 비밀번호를 입력하세요!";
		msg = URLEncoder.encode(msg, "utf-8");
		response.sendRedirect("ex05_loginFirm.jsp?msg="+msg);
	}
%>

<h2>
	ID는 <%=id %>이고 <br>
	비밀번호는 <%=pw %> <br>
	반갑습니다.<br>
</h2>
<br>
<input type="button" onclick="history.go(-1);" value=뒤로가기>
</body>
</html>