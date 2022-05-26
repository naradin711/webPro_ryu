<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>약 관 동 의</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	request.setCharacterEncoding("utf-8"); 		//한국어 가능하게 인코딩
	String id = request.getParameter("id"); 	// 아이디 값 받음
	String pw = request.getParameter("pw"); 	// 비번 값 받음
	String name = request.getParameter("name"); // 이름 값 받음
	session.setAttribute("id", id); 			// 받은 값을 세션으로 전송
	session.setAttribute("pw", pw); 			// 받은 값을 세션으로 전송
	session.setAttribute("name", name); 		// 받은 값을 세션으로 전송
%>
	<h2><%=name %>님 약관에 동의하십니까?</h2>
	<hr>
	<ol>
		<li>회원정보는 웹사이트 운영을 위해서만 쓰입니다.</li>
		<li>운영에 방해되거나 타 회원님의 이용을 방해할 시 강퇴합니다.</li>
	</ol>
	<hr>
	<fieldset>
		<legend>약관 동의</legend>
		<form action="joinOk.jsp">
			<input type="radio" name="agree" value="y">동의
			<input type="radio" name="agree" value="n" checked="checked">거부
			<input type="submit" name="sub" value="확인" class="btn">
			<input type="reset" name="cancel" value="취소" class="btn">
		</form>
	</fieldset>
</body>
</html>












