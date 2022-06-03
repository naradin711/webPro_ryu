<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>삭제 진행</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pw = request.getParameter("pw");
	BoardDao dao = BoardDao.getInstance();
	int result = dao.deleteBoard(num, pw);
	if(result == BoardDao.SUCCESS){
	%>	
		<script type="text/javascript">
			alert('<%=num %>번 글  삭제가 완료되었습니다.');
			location.href = '<%=conPath %>/board/list.jsp';
			
		</script>
	
	<%} else {%>
		<script type="text/javascript">
			alert('<%=num %>번 글  삭제 실패, 비밀번호를 확인하세요');
			history.back();		
		</script>
	<%}%>
</body>
</html>