<%@page import="com.lec.dto.AdminDto"%>
<%@page import="com.lec.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  /> 
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
		<c:if test="${empty member && empty admin}">
			<!-- 로그인 전 메뉴 우측부터 고객 센터 회원가입 로그인 -->
			<ul>
				<li><a href="${conPath }/boardList.do">고객센터</a></li>
				<li><a href="${conPath }/joinView.do">회원가입</a></li>
				<li><a href="${conPath }/loginView.do">로그인</a></li>
			</ul>	
		</c:if>	
		<c:if test="${ member != null }">
			<!-- 로그인 후 메뉴 우측부터 고객 센터 로그아웃 정보 수정, 고객이름 -->
			<ul>
				<li><a href="${conPath }/boardList.do">고객센터</a></li>
				<li><a href="${conPath }/logout.do">로그아웃</a></li>
				<li><a href="${conPath }/modifyView.do">정보수정</a></li>
				<li><a href="#">${member.mname }님 반갑습니다.</a></li>
			</ul>	
		</c:if>
		<c:if test="${ admin != null }">
			<ul>
				<li><a href="${conPath }/boardList.do">고객센터</a></li>
				<li><a href="${conPath }/logout.do">관리자 모드 나가기</a></li>
				<li><a href="#">${admin.aname }님 </a></li>
			</ul>		
		</c:if>
		</div>
		<div class="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
			<h1>LOGO</h1>
		</div>
		<div class="lnb">
			<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인 이후) -->
			<ul>
				<c:if test="${empty member && empty admin}">
			 		<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">로그인 전 메뉴 1</a></li>		
					<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">로그인 전 메뉴 2</a></li>	
					<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">로그인 전 메뉴 3</a></li>
					<li><a href='<%=conPath%>/Book/ex03_list_productp.jsp'>로그인 전 메뉴 4</a></li>	
				</c:if>	
				<c:if test="${ member != null }">
			 		<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">로그인 후 메뉴 1</a></li>		
					<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">로그인 후 메뉴 2</a></li>	
					<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">로그인 후 메뉴 3</a></li>
					<li><a href='<%=conPath%>/Book/ex03_list_productp.jsp'>로그인 후 메뉴 4</a></li>	
				</c:if>
				<c:if test="${ admin != null }">
			 		<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">관리자 메뉴 1</a></li>		
					<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">관리자 메뉴 2</a></li>	
					<li><a href="<%=conPath%>/Book/ex03_list_productp.jsp">관리자 메뉴 3</a></li>
					<li><a href='<%=conPath%>/Book/ex03_list_productp.jsp'>관리자 메뉴 4</a></li>
				</c:if>
					
			</ul>
		</div>
	</header>
</body>
</html>









