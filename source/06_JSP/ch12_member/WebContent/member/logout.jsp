<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<script type="text/javascript">
	setTimeout(function(){
		location.href = 'main.jsp';
		
	}, 3000);
	</script>
</head>
<body>
<%
	session.invalidate();
	 
%>
<h2>로그아웃이 완료되었습니다. 잠시후 메인 페이지로 이동합니다.</h2>
</body>
</html>