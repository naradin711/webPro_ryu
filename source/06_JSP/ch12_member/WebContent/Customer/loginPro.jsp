<%@page import="java.net.URLEncoder"%>
<%@page import="com.lec.member.CustomerDto"%>
<%@page import="com.lec.member.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String msg = "";
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	CustomerDao cDao = CustomerDao.getInstance();
	int result =  cDao.loginCheck(cid, cpw);
	if (result == CustomerDao.LOGIN_SUCCESS){
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer", customer);
		session.setAttribute("cid", cid);
		response.sendRedirect("main.jsp");
		
	} else if (result == CustomerDao.LOGIN_FAIL_PW) {
	%>
		<script type="text/javascript">
			alert('비밀번호를 확인하세요.');
		</script>
	<% 	
		msg = URLEncoder.encode("비밀번호를 확인하세요.", "utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	} else if (result == CustomerDao.LOGIN_FAIL_ID){
	%>	
		<script type="text/javascript">
	    	alert('등록되지 않은 고객 아이디입니다.');
		</script>	
	<%
		msg = URLEncoder.encode("등록되지 않은 고객 아이디입니다.", "utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	}%>
</body>
</html>