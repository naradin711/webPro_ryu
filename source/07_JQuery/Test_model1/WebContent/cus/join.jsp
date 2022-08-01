<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회 원 가 입</title>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br>
	<div class="section" style="margin : 0 auto;"> 
		<form action="joinPro.jsp" method="post" name="frmJoin" onsubmit="return chkJoinInfo()">
			<h2 align="center">회원가입</h2>
			<br>
			<table style="margin : 0 auto;">
				<tr>
					<th><label for="custno">회원번호</label></th>
					<td><input type="number" name="custno" id="custno" readonly="readonly"></td>
				</tr>
				<tr>
					<th><label for="custname">회원성명</label></th>
					<td><input type="text" name="custname" id="custname" required="required"></td>
				</tr>
				<tr>
					<th><label for="phone">회원전화</label></th>
					<td><input type="text" name="phone" id="phone" ></td>
				</tr>
				<tr>
					<th><label for="address">회원주소</label></th>
					<td><input type="text" name="address" id="address" required="required"></td>
				</tr>
				<tr>
					<th><label for="joindate">가입일자</label></th>
					<td>
						<input type="tel" name="joindate" id="joindate" required="required" value="010-">
					</td>
				</tr>
				<tr>
					<th><label for="grade">고객등급<br>(A:VIP, B:일반, C:직원)</label></th>
					<td><input type="text" name="grade" id="grade"></td>
				</tr>
				<tr>
					<th><label for="city">도시코드</label></th>
					<td><input type="text" name="city" id="city"></td>
				</tr> 
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록" >
						<input type="button" value="조회"  
											onclick="location.href='../main/main.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>