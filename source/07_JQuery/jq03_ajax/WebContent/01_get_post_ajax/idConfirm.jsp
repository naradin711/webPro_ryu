<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<% // idConfirm.jsp?mid=aaa
	String mid = request.getParameter("mid");
	MemberDao dao = MemberDao.getInstance();
	int result = dao.confirmMid(mid);
	if (result == MemberDao.MEMBER_EXISTENT){
		out.print("중복된 ID입니다.");
	} else {
		out.print("사용가능한 아이디입니다.");
	}
%>
</body>
</html>