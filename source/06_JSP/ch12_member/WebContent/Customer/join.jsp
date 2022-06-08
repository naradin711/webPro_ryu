<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>고객 회원 가입</title>
	<link href="<%=conPath %>/Customer/join.css " rel="stylesheet" type="text/css">
	<script src="<%=conPath %>/Customer/join.js"></script>	
	
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br>
	<br>
	<form action="joinPro.jsp" method="post" name="join_frm">
		<table>
			<caption> 회 원 가 입</caption>
			<tr><th>아이디</th><td><input type="text" name="cid" size= "5" required="required"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="cpw" size= "5" required="required"></td></tr>
			<tr><th>비밀번호확인</th><td><input type="password" name="pwChk" size= "5" required="required"></td></tr>
			<tr><th>이름</th><td><input type="text" name="cname" size= "5" required="required"></td></tr>
			<tr><th>전화번호</th><td><input type="text" name="ctel" size= "5" required="required"></td></tr>
			<tr><th>이메일</th><td><input type="text" name="cemail" size= "5" required="required"></td></tr>
			<tr><th>주소</th><td><input type="text" name="caddress" size= "5" required="required"></td></tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="cgender" value="m" checked="checked">남자
					<input type="radio" name="cgender" value="f">여자
				</td>
			</tr>
			<tr><th>생일</th><td><input type="date" name="tempbirth" size= "5" required="required"></td></tr>
			<tr>
				<td colspan="2">
					<input type="button" onclick="infoConfirm()" value="회원가입">
					<input type="reset" value="취소">
					<input type="button" onclick="location.href='login.jsp'" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="footer.jsp"/>
</body>
</html>










