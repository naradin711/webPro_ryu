<%@page import="com.lec.dao.CustDao"%>
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
<jsp:useBean id="dto" class="com.lec.dto.CustDto" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<%
	String tempbirth = request.getParameter("joindate");
	if (tempbirth != null) {
	dto.setJoindate(Date.valueOf(tempbirth));
	}
	CustDao cDao = CustDao.getInstance(); 
		int result = (int)cDao.insertCust(dto);
		if (result == CustDao.SUCCESS) {
			session.setAttribute("custname", dto.getCustname());	
		%>
			<script type="text/javascript">
				alert("회원 등록이 되었습니다.")
				location.href = "../main/main.jsp";
			</script>
		<%} else {%>
			<script type="text/javascript">
				alert("회원 등록에 실패하셨습니다. 다시 등록해주세요.")
				location.href = "join.jsp";
			</script>
		<%} %>

</body>
</html>