<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="style" type="text/css">
	
</head>
<body>
	<%
	Cookie cookie = new Cookie("cookieName","cookieValue"); // 쿠키 아이디 / 쿠키 밸류 아이디는 aaa인 쿠키  생성
	cookie.setMaxAge(60*60); //1시간 유효한 쿠키
	// cookie.setMaxAge(-1); //로그아웃 이전까지 유효한 쿠키
	response.addCookie(cookie); //response에 탑재
	%>
	<h2>지금 막 생성된 쿠키 이름 = <%= cookie.getName() %></h2>
	<h2>지금 막 생성된 쿠키 값 = <%= cookie.getValue()%> </h2>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a> <br>
	<a href="ex02_cookieList.jsp">쿠키들(쿠키이름 쿠키값) 리스트 확인</a> <br>
	<a href="ex03_ThatCookie.jsp">특정 쿠키(쿠키이름 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">특정 쿠키 삭제</a> <!-- 로그아웃 활동 -->
</body>
</html>















