<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	
</head>
<body>
	<h2>web.xml을 이용한 예외 페이지 처리</h2>
	<a href="xx.html">없는 파일을 클릭하면 404에러</a><br>
	<br>
<%
	 int param = Integer.parseInt(request.getParameter("param")) ; //NumberformatException 500 error
	int[] arr = {10, 20, 30};									  
	for (int i = 0; i<=arr.length ; i++) { //ArrayIndexOutOfBoundsException errorIndex
		out.print(arr[i]+ ", ");
	}
%>	
</body>
</html>

















