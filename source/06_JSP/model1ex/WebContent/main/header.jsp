<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
	<link href="<%=conPath %>/css/header.css" rel="stylesheet" type="text/css">
	
</head>
<body> <!-- gnb는 로그인/전후 다르다 -->
	<header>
		<div class="gnb">
		<% if(session.getAttribute("customer")==null){%>
			<!-- 로그인 전 메뉴 우측부터 고객 센터 회원가입 로그인 -->
			<ul>
				<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
				<li><a href="<%=conPath %>/customer/joinForm.jsp">회원가입</a></li>
				<li><a href="<%=conPath %>/customer/loginForm.jsp">로그인</a></li>
			</ul>	
			
		<%} else {%>
			<!-- 로그인 후 메뉴 우측부터 고객 센터 로그아웃 정보 수정, 고객이름 -->
			<ul>
				<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
				<li><a href="<%=conPath %>/customer/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath %>/customer/modifyform.jsp">정보수정</a></li>
				<li><a href="#"><%=((CustomerDto)session.getAttribute("customer")).getCname() %>님 반갑습니다.</a></li>
			</ul>		
			
		<%}%>
		</div>
		<div class="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
			<img src="<%=conPath%>/modelImg/hire.jpg">
		</div>
		<div class="lnb">
			<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인 이후) -->
			<ul>
				<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">도서보기</a></li>
				<% if(session.getAttribute("customer")!=null){%>
				<li><a href="<%=conPath%>/Book/ex01_bookRegisterForm.jsp">도서등록</a></li>
				<%} %>
			</ul>
		</div>
	</header>
</body>
</html>









