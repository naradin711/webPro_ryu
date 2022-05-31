<%@page import="com.lec.member.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ㅇㅇㅇ</title>
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
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.confirmId(dto.getId());
	if (result == MemberDao.MEMBER_NONEXISTENT) { // 사용 가능한 아이디
		result = mDao.joinMember(dto); // 회원가입
		if (result == MemberDao.SUCCESS) { // 회원가입 성공
			session.setAttribute("id", dto.getId());
%>
	      <script type="text/javascript">
	      	alert("회원가입 감사합니다. 로그인 후 서비스를 이용하세요. ");
	      	location.href = "login.jsp";
	      </script>
<%		} else { // 회원가입 실패
%>
    	  <script type="text/javascript">
    		alert("회원가입에 실패하였습니다. 다시 가입해주세요. ");
    		location.href = "join.jsp";
    	  </script>
<%			
		}
	} else { // 중복된 ID %> 
		<script type="text/javascript">
	    	alert("중복된  ID입니다. 다른 아이디를 사용하세요. ");
	    	history.back();
	    </script>	
	<%}%>


</body>
</html>











