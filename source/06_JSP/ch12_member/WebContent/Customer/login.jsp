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
	<title>회원 로그인</title>
	<link href="<%=conPath %>/Customer/login.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%if(msg!=null){%>
		<script> 
			alert('<%=msg %>');
		</script>
<%}%>
	<jsp:include page="header.jsp"/>
	<br>
	<br>
	<form action="loginPro.jsp" method="post" id="loginForm_wrap" name="loginForm_wrap">
		<table>
			<caption id="login_title">로 그 인</caption>
			<tr><th>아 이 디</th>
				<td>
				<input type="text" name="cid" required="required"
				value="<%
						String cid = (String)session.getAttribute("cid");
						out.println(cid!=null? cid:"");
						%>">
				</td>
			</tr>
			<tr><th>비밀번호 </th><td><input type="password" name="cpw" required="required"> </td></tr>
			<tr>
	 			<td colspan="2"><%if(msg!=null){out.println(msg);}%><td>
	 		</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" class="loginBtn"> 
					<input type="button" value="회원가입" onclick="location.href='join.jsp'" class="loginBtn"> 	
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>