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
	<title>회원 정보 수정</title>
	<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="mphoto" 	value="${param.mphoto}">
		<table>
			<caption>회 원 정 보 수 정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" size="5" value="${member.mid }" readonly="readonly"></td>
				<td rowspan="3">
					<img alt="memberimg" src='${conPath}/memberPhotoUp/${member.mphoto}'>
					<br>
					사진
				</td>
			</tr>
			<tr>
			<th>비밀번호</th><td><input type="password" name="mpw" size="5"  value="${member.mpw }" required="required"></td></tr>
			<tr><th>이름</th><td><input type="text" name="mname" value="${member.mname }" required="required" size="5"></td></tr>
			<tr><th>이메일</th><td colspan="2"><input type="text" name="memail" value='${member.memail }' size="5"></td></tr>
			<tr><th>사진</th><td colspan="2"><input type="file" name="mphoto" value='${member.mphoto }' size="20"></td></tr>
			<tr><th>생년월일</th><td colspan="2"><input type="date" name="mbirth" size="5" value='${member.mbirth }'></td></tr>
			<tr><th>주소</th><td colspan="2"><input type="text" name="maddress" size="5" value='${member.maddress }'></td></tr>
			<tr><td colspan="3"></td></tr><tr>
				<td colspan="3">
					<input type="submit" value="정보 수정">
					<input type="reset" name="reset" value="취소">
					<input type="button" name="back" value="뒤로 가기" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>