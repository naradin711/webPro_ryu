<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	if (session.getAttribute("member")!=null){ //이미 로그인이 된 상태
		response.sendRedirect("main.jsp"); // 바로 메인으로 보내버림
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<table>
			<caption>로 그 인</caption>
			<tr><th>아 이 디</th>
			<td><input type="text" name="id" required="required" 
			    value="<%
			    		String id = (String)session.getAttribute("id");
						out.println(id!=null? id:"");
			           %>"> 
			</td>
			</tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw" required="required"> </td></tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="로그인"> 
				<input type="button" value="회원가입" onclick="location.href='join.jsp'"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

















