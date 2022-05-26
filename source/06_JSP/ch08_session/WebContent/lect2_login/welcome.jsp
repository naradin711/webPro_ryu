<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<%
		String name = (String)session.getAttribute("name"); //(String)을 통해 문자열로 형변환 이름 받음
		String id = (String)session.getAttribute("id");//(String)을 통해 문자열로 형변환 아이디 입력받음
	%>
	<%if(name!=null){ //로그인 된 상태 %>
		<h2><%=name %>(<%=id %>)님 안녕하세요!</h2>
		<button onclick="location.href='logout.jsp'">로그아웃</button>
	<%} else  {  //비로그인상태%>
		<h2>손님 안녕하세요. 로그인이 필요합니다.</h2>
		<button onclick="location.href='login.jsp'">로그인</button>
	<%} %>
	 	<button onclick="location.href='sessionTest.jsp'">세션 들여다보기</button>
</body>
</html>