<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>header</title>
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
			color : #138e43; ;
		}
	</style>
</head>
<body>
	<header>
		<div id = "nav">
			<%
			String cid = (String)session.getAttribute("cid");
			%>
			<% if (cid == null){ // 로그인 이전%>
				<ul>
					<li><a href="<%=conPath %>/Customer/join.jsp">회원가입</a></li>
					<li><a href="<%=conPath %>/Customer/login.jsp">로그인</a></li>
					<li><a href="<%=conPath %>/Customer/main.jsp"> HOME </a></li>
				</ul>
				
			<%} else {// 로그인 이후%>
				<ul>
					<li><a href="<%=conPath %>/Customer/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath %>/Customer/modify.jsp">회원정보수정</a></li>
					<li><a href="<%=conPath %>/Customer/main.jsp"><%=cid %> 고객님</a></li>
				</ul>
			<%}%>
		</div>
	</header>
</body>
</html>












