<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<jsp:useBean id="dto" class="com.lec.ex.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<h2>bean태그를 이용한 정보 출력</h2>
	<h3>이름 : <jsp:getProperty property="name" name="dto"/> </h3>
	<h3>ID  : <jsp:getProperty property="id" name="dto"/> </h3>
	<h3>비번 : <jsp:getProperty property="pw" name="dto"/> </h3>
	<br><br><br>
	<h2> 표현식을 이용한 정보 출력</h2>
	<h3>이름 : <%=dto.getName() %> </h3>
	<h3>ID  : <%=dto.getId() %> </h3>
	<h3>비번 : <%=dto.getPw() %> </h3>
	<br><br><br>
	<h2> EL 표현식을 이용한 정보 출력</h2>
	<h3>이름 : ${ dto.name } </h3>
	<h3>ID  : ${ dto.id } </h3>
	<h3>비번 : ${ dto.pw } </h3>
</body>
</html>















