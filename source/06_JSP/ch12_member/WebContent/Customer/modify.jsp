<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.member.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>고객 회원 정보 수정</title>
	<link href="<%=conPath %>/Customer/style1.css " rel="stylesheet" type="text/css">
	<script src="<%=conPath %>/Customer/modify.js"></script>
	
</head>
<body>
<%!String cid, cname, ctel, cemail, caddress, cgender; Date cbirth; %>
<%
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if (customer == null){
		response.sendRedirect("login.jsp");
	} else {
		cid = customer.getCid();
		cname = customer.getCname();
		ctel = customer.getCtel();
		cemail = customer.getCemail();
		caddress = customer.getCaddress();
		cgender = customer.getCgender();
		cbirth = customer.getCbirth();
	}
%>
<jsp:include page="header.jsp"/>
<form action="modifyPro.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()"></form>
	<table>
		<caption>고 객 회 원 정 보 수 정</caption>
		<tr><th>아이디</th><td><input type="text" name="cid" size="10" value="<%=cid%>" readonly="readonly"></td></tr>
		<tr><th>기존 비밀번호</th><td><input type="password" size="10" name="oldPw" required="required"></td></tr>
		<tr><th>새 비밀번호</th><td><input type="password" size="10" name="cpw"></td></tr>
		<tr><th>새 비밀번호 확인</th><td><input type="password" size="10" name="pwChk"></td></tr>
		<tr><th>이름</th><td><input type="text" name="cname" size="10" value="<%=cname%>" readonly="readonly"></td></tr>
		<tr><th>전화번호</th><td><input type="text" name="ctel" size="10" value="<%=ctel%>" required="required"></td></tr>
		<tr><th>이메일</th><td><input type="text" name="cemail" size="10" value="<%=cemail%>" required="required"></td></tr>
		<tr><th>성별</th>
				<td>
				<% if("m".equals(cgender)) {%>
					<input type="radio" name="cgender" value="m" checked="checked">남
					<input type="radio" name="cgender" value="f">여
				<%} else if("f".equals(cgender)) {%>
					<input type="radio" name="cgender" value="m">남
					<input type="radio" name="cgender" value="f" checked="checked">여
				<%} else {%>
					<input type="radio" name="cgender" value="m">남
					<input type="radio" name="cgender" value="f">여
				<%}%>
				</td>
			</tr>
		<tr><th>생년월일</th><td><input type="date" name="cbirth" size="10" value="<%=cbirth%>" required="required"></td></tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="고객 정보 수정">
				<input type="reset"  value="정보 수정 취소">
				<input type="button" value="이전 화면" onclick="history.back()">
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp"/>
</body>
</html>












































