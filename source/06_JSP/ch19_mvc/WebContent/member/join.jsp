<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회 원 가 입</title>
	<link href="${conPath }/css/join.css " rel="stylesheet" type="text/css">
	<script src="${conPath }/js/join.js"></script>
</head>
<body>
	<form action="${conPath }/memberJoin.do" name="join_frm" id="joinForm_wrap" method="post">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"  required="required"></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="pwChk"  required="required"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"  required="required"></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="birth"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="infoConfirm()" class="joinBtn_style">
					<input type="reset" value="초기화" class="joinBtn_style">
					<input type="button" value="회원 목록"  onclick="location='${conPath }/memberList.do'" class="joinBtn_style">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>













