<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	<style type="text/css">
		header {
		 width : 1000px; margin: 0 auto;
		}
		header #nav ul {overflow : hide}
		header #nav ul li {
			list-style: none; float : right; padding: 10px 30px;
			
		}
		header #nav ul li a{
			text-decoration: none;
			font-weight: bold;
			font-size: 1.7em;
			color : #D4A190 ;
		}
	</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
			String id = (String)session.getAttribute("id");
			%>
			<%if (id == null){ // 로그인 전 헤더 메뉴 %>
				<ul>
					<li><a href="<%=conPath %>/member/join.jsp">회원가입</a></li>
					<li><a href="<%=conPath %>/member/login.jsp">로그인</a></li>
					<li><a href="<%=conPath %>/member/main.jsp">HOME</a></li>
				</ul>
			<%} else { // 로그인 후 헤더 메뉴%>
				<ul>
					<li><a href="<%=conPath %>/member/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath %>/member/joinPro.jsp">회원정보</a></li>
					<li><a href="<%=conPath %>/member/main.jsp"><%= id %>님</a></li>
				</ul>
			<%} %>
		</div>
	</header>
</body>
</html>

















