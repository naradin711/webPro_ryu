<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	
%>
<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<%
	String tempbirth = request.getParameter("tempbirth");
	if (tempbirth != null) {
	dto.setCbirth(Date.valueOf(tempbirth));
	}
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmCid(dto.getCid());
	if (result == CustomerDao.CUSTOMER_NONEXISITENT) {
		result = cDao.insertCustomer(dto);
		if (result == CustomerDao.SUCCESS) {
			session.setAttribute("cid", dto.getCid());	
		%>
			<script type="text/javascript">
				alert("회원가입 감사합니다. 로그인 후 서비스를 이용해주세요.")
				location.href = "loginForm.jsp";
			</script>
		<%} else {%>
			<script type="text/javascript">
				alert("회원가입에 실패하셨습니다. 다시 가입해주세요.")
				location.href = "joinForm.jsp";
			</script>
		<%}
	} else {%>
		<script type="text/javascript">
				alert("중복된 아이디입니다. 다른 아이디를 사용하세요.")
				history.back();
		</script>
	<%}%>

</body>
</html>