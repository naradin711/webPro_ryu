<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키 리스트</title>
	<link href="<%=conPath %> " rel="style" type="text/css">
	
</head>
<body>
	<h1>쿠키 리스트</h1>
	<h2></h2>
	<%
	Cookie[] cookies = request.getCookies();
	for (int idx=0 ; idx<cookies.length ; idx++ ){
		String name = cookies[idx].getName(); // idx번째 쿠키의 이름
		String value = cookies[idx].getValue();
		out.println("<h2>"+idx+"번째 쿠키 이름 : "+name+", 쿠키 값 : "+value+"</h2>");
	}
	
	%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a> <br>
	<a href="ex02_cookieList.jsp">쿠키들(쿠키이름 쿠키값) 리스트 확인</a> <br>
	<a href="ex03_ThatCookie.jsp">특정 쿠키(쿠키이름 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">특정 쿠키 삭제</a> <!-- 로그아웃 활동 -->
</body>
</html>















