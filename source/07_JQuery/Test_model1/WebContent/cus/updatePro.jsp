<%@page import="com.lec.dto.CustDto"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.dto.CustDto"/>
	<jsp:setProperty name="dto" property="*" />
	<%
		String tempbirth = request.getParameter("joindate");
		dto.setJoindate(Date.valueOf(tempbirth)); 
		CustDto customer = (CustDto)session.getAttribute("customer"); 
			CustDao cDao = CustDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustDao.SUCCESS){
				session.setAttribute("customer", dto);
%>				<script>
						alert('회원정보 수정이 완료되었습니다');
						location.href = '../main/main.jsp';
					</script>
<%			}else{%>
					<script>
						alert('회원정보 수정이 실패되었습니다. 정보가 너무 깁니다');
						location.href = 'update.jsp';
					</script>
<%			} %>
</body>
</html>