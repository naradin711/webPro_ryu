<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="<%=conPath %>/css/login.css " rel="stylesheet" type="text/css">
	<%if(msg!=null){%>
		<script> 
			alert('<%=msg %>');
		</script>
	<%}%>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br>
	<br>
	<br>
	<form action="loginPro.jsp" id="loginForm_wrap">
		<table>
			<caption>로 그 인</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" autofocus="autofocus"
					value="<%
						String id = (String)session.getAttribute("id");
						if (id!=null){
							out.println(id);
						}
					%>">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2"><%if(msg!=null){out.println(msg);}%></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="로그인" class="loginBtn_style">
					 
				</td>
			</tr>
		</table> 
	</form>
	<br>
	<br>
	<jsp:include page="footer.jsp"/>
</body>
</html>