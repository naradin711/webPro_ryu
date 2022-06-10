<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<script src="<%=conPath %>/js/modify.js"></script>
	
</head>
<body>
<%! String id, name, phone1, phone2, phone3, gender, email, address; Timestamp birth; %>
<%
	MemberDto member = (MemberDto)session.getAttribute("member");
	if(member ==null) {
		response.sendRedirect("login.jsp");
	}else{
		id     = member.getId();
		name   = member.getName();
		phone1 = member.getPhone1();
		phone2 = member.getPhone2();
		phone3 = member.getPhone3();
		gender = member.getGender();  
		email  = member.getEmail(); 
		address = member.getAddress();
		birth   = member.getBirth();
	}
%>
<form action="modifyOk.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()">
		<table>
			<caption>회 원 정 보 수 정</caption>
			<tr><th>아이디</th><td><input type="text" name="id" size="5" value="<%=id%>" readonly="readonly"></td></tr>
			<tr><th>기존 비밀번호</th><td><input type="password" name="oldPw" size="5"  required="required"></td></tr>
			<tr><th>새 비밀번호</th><td><input type="password" name="pw" size="5"   placeholder="비밀번호 수정을 원하지 않으시면 입력하지 않으셔도 됩니다."></td></tr>
			<tr><th>비밀번호 확인</th><td><input type="password" name="pwChk" size="5"  placeholder="비밀번호 수정을 원하지 않으시면 입력하지 않으셔도 됩니다."></td></tr>
			<tr><th>이름</th><td><input type="text" name="name" value=<%=name %> required="required" size="5"></td></tr>
			<tr><th>전화번호</th>
				<td>
					<select name = "phone1">
						<option>    </option>
						<option <%if("010".equals(phone1))
								{out.print("selected ='selected'");
								} %>>010</option>
						<option <%if("02".equals(phone1))
								{out.print("selected='selected'");
								} %>>02</option>
						<option <%if("031".equals(phone1))
								{out.print("selected='selected'");
								} %>>031</option>
						<option <%if("032".equals(phone1))
								{out.print("selected='selected'");
								} %>>032</option>
						<option <%if("063".equals(phone1))
								{out.print("selected='selected'");
								} %>>063</option>
					</select>
					<input type="text" name="phone2" value='<%=phone2!=null? phone2:"" %>'>
					<input type="text" name="phone3" value='<%=phone3!=null? phone3:"" %>'>
				</td>
			</tr>
			<tr><th>성별</th>
				<td>
				<% if("m".equals(gender)) {%>
					<input type="radio" name="gender" value="m" checked="checked">남
					<input type="radio" name="gender" value="f">여
				<%} else if("f".equals(gender)) {%>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f" checked="checked">여
				<%} else {%>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f">여
				<%}%>
				</td>
			</tr>
			<tr><th>이메일</th><td><input type="text" name="email" value='<%=email==null? "":email %>' size="5"></td></tr>
			<tr><th>생년월일</th><td><input type="date" name="tempbirth" size="5" value='<%=birth==null? "":birth.toString().substring(0, 10) %>'></td></tr>
			<tr><th>주소</th><td><input type="text" name="address" size="5" value='<%=address==null? "":address %>'></td></tr>
			<tr><th></th><td></td></tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="정보 수정">
					<input type="reset" name="reset" value="취소">
					<input type="button" name="back" value="뒤로 가기" onclick="history.back()">
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>