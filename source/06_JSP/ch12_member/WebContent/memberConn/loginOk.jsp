<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%> 
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
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDaoConn mDao = new MemberDaoConn();
	int result = mDao.loginCheck(id, pw);
	if(result == MemberDaoConn.LOGIN_SUCCESS) { // 로그인 성공
		MemberDto member = mDao.getMember(id);
		session.setAttribute("member", member);
		response.sendRedirect("main.jsp");
	} else if(result == MemberDaoConn.LOGIN_FAIL_PW) { // 비밀번호 오류
	%> 
		<script type="text/javascript">
			alert('비밀번호를 확인하세요.');
			history.back();
		</script>
	<%		
	} else if(result == MemberDaoConn.LOGIN_FAIL_ID) { // 아이디 오류
	%> 
	    <script type="text/javascript">
	    	alert('등록되지 않은 아이디입니다.');
			history.back();
		</script>	
	<%	
	}
%>
</body>
</html>
















