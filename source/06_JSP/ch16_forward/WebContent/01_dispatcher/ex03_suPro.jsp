<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>누적합 도출</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	int su = Integer.parseInt(request.getParameter("su"));
	int sum = 0;
	for (int i=1; i<=su ; i++){
		sum += i;
	}
	// 프로세스 부분
%>

	<!-- 출력하는 부분 -->
	<h2> 1부터 ${param.su }까지의 누적합은 <%=sum %> 입니다.  </h2>


</body>
</html>



















