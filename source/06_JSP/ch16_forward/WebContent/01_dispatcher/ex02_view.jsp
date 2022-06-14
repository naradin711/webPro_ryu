<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>RequestDispatcher 출력</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<h2>ex02_view.jsp 파일입니다.</h2>
	<br>
	<hr>
	<br>
	<h2>회원 정보</h2>
	<h3>ID : ${member.id }</h3>
	<h3>PW : ${member.pw }</h3>
	<h3>등록일 : ${member.rdate }</h3>
	<br>
	<hr>
	<br>
	<h3>ID : ${param.id }</h3>
	<h3>PW : ${param.pw }</h3>
	<button onclick="history.back()"> 뒤로 가기 </button>
	
	
</body>
</html>