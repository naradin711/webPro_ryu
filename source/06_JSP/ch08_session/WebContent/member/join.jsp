<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">	
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br>
	<br>
	<br>
	<form action="joinPro.jsp" id="joinForm_wrap" name="joinFrm" method="post">
		<div id="join_title">회원가입</div>
		<table>
		
		<tr>
			<th>아이디</th><td><input type="text" name="id" required="required" autofocus="autofocus"></td>
		</tr>
		<tr>
			<th>이름</th><td><input type="text" name="name" required="required"  ></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="password" name="pw" required="required"  ></td>
		</tr>
		<tr>
			<th>비밀확인</th><td><input type="password" name="pwC" required="required"  ></td>
		</tr>
		<tr>
			<th>생  일</th><td><input type="date" name="birth" required="required"  ></td>
		</tr>
		<tr>
			<th>취  미</th>
			<td>
				<input type="checkbox" name="hobby" id="reading" value="독서">독서
				<input type="checkbox" name="hobby" id="cooking" value="요리">요리
				<input type="checkbox" name="hobby" id="talking" value="수다">수다
				<input type="checkbox" name="hobby" id="gaming" value="게임">게임
				<input type="checkbox" name="hobby" id="swimming" value="수영">수영		
			</td>
		</tr>
		<tr>
			<th>성  별</th>
			<td>
				<input type="radio" name="gender" id="m" value="m"> 남자
				<input type="radio" name="gender" id="f" value="f"> 여자
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" id="email" name="email" required="required"></td>
		</tr>
		<tr>
			<th>메일수신</th>
			<td>
				<select name="mailSend" multiple="multiple"> 
					<option>광고</option>
					<option>배송</option>
					<option>공지</option>
					<option>뉴스</option>
					<option>수신 거부</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			</td>
		</tr>	
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입" class="joinBtn_style">
				<input type="reset" value="다시하기" class="joinBtn_style">
				<input type="button" value="뒤로가기" class="joinBtn_style" onclick="history.back()">
			</td>
		</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"/>
</body>

</html>