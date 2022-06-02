<%@page import="com.lec.member.FriendDAOConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="dto" class="com.lec.member.FriendDTO"/>
	<jsp:setProperty property="*" name="dto"/>
<%
	FriendDAOConn fDao = new FriendDAOConn();
	int result = fDao.joinFriend(dto);
	if (result == FriendDAOConn.SUCCESS){
	%>
		<script type="text/javascript">
		alert("친구추가 완료되었습니다.");
		location.href = "main.jsp"
		</script>
	<%	
	} else {
	%>
		<script type="text/javascript">
		alert("친구추가에 실패하였습니다.");
		location.href = "main.jsp"
		</script>
	<%		
	}
	
%>	
</body>
</html>