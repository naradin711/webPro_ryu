<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
<br>
<br>
	<div id="loginForm_wrap">
	<form action="loginPro.jsp" method="post">
	
	<table>
		<tr>
		<td colspan="2"> </td>
		</tr>
		<tr>
			<th>아이디</th><td><input type="text" id="id" name="id" required="required" autofocus="autofocus"></td>	
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="pw" name="pw" required="required"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" class="loginBtn_style" value="로그인">
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<%
				String msg = request.getParameter("msg");
				if(msg!=null){%>
					<h2 id="login_findIdPw" onclick="alert('아이디는 aaa/pw는 111');">
						<%=msg %>
					</h2>
				<%}%>
			</td>
		</tr>
	</table> 
	<p id="login_join"><a href="join.jsp">아직 회원이 아니신가요?</a></p>
	</form>
	</div>
	
	<jsp:include page="footer.jsp"/> 
</body>
</html>