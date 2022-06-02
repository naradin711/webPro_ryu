
<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/> <!-- dto에서 받은 모든 객체를 한번에 받음 -->
<%
	String tempbirth = request.getParameter("tempbirth");
	if (tempbirth != null) {
		dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00 "));
	}
	MemberDto member =(MemberDto)session.getAttribute("member");
	String sessionPw = null;
	if (member!=null) {
		sessionPw = member.getPw(); // 세션의 pw를 sessionPw에 할당
	}
	String oldPw = request.getParameter("oldPw");
	if (sessionPw.equals(oldPw)) { // 현재 비밀번호를 제대로 입력
		// 새 비밀번호(pw파라미터)가 null
		if(dto.getPw()==null) {
			dto.setPw(sessionPw); // 새로운 비밀번호 값이 없으면 세션에 있는 비밀번호로 대체	
		}
		MemberDaoConn mDao = new MemberDaoConn();
		int result = mDao.modifyMember(dto);
		if (result == MemberDaoConn.SUCCESS) { // 수정 성공
			session.setAttribute("member", dto); // 수정된 DB내용을 기존 session에 Update!
		%> 
			<script type="text/javascript">
				alert('회원 정보 수정이 완료되었습니다.');
				location.href = 'main.jsp';
			</script>		
		<%	
		}else { // 수정 실패
		%> 
			<script type="text/javascript">
				alert('회원 정보 수정에 실패하였습니다.');
				history.go(-1);
			</script>		
		<%		
		}
	} else { // 현재 비밀번호를 틀리게 입력 %> 
	<script type="text/javascript">
		alert('입력하신 기본 비밀번호가 올바르지 않습니다. 다시 입력하세요.')
		history.back();
	</script>	
  <%}%>
</body>
</html>