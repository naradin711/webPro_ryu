<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>누적 값 출력 </title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<h2> ex03_suView단입니다</h2>
	<h2> 1부터 ${param.su }까지의 누적합은 ${sum } 입니다.  </h2>
	<button onclick="history.back()"> 이전 </button>
	<button onclick="location='01_dispatcher/ex03_input.jsp'"> 다시 </button>
</body>
</html>
















