<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<form action="agree.jsp" method="post">
		<table>
			<caption>회 원 가 입</caption>
			<tr>
				<th>아이디</th><td><input type="text" name="id" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<th>비밀확인</th><td><input type="password" name="pwC" required="required"></td>
			</tr>
			<tr>
				<th>이 름</th><td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="sub" value="가입" class="btn">
					<input type="reset" name="cancel" value="취소" class="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>