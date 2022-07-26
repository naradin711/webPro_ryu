<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회 원 가 입</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<br>
<br>
<div id="content">
<form action="${conPath }/member.do?method=joinMember" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mid" id="mid" required="required"> 
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpw" id="mpw" required="required">
				</td>
			</tr> 
			<tr>
				<th>이름</th>
				<td>
				 	<input type="text" name="mname" id="mname" required="required">
				</td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td>
					<input type="email" name="mmail" id="mmail" required="required">
				</td>
			</tr> 
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" name="mpost"> 
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="maddr" id="maddr">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" >
					<input type="button" value="로그인" onclick="location='${conPath}/loginView.do'">
				</td>
			</tr>
		</table>
	</form>
<br>
<br>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>