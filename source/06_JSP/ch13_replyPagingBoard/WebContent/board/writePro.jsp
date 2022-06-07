<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); String pageNum = request.getParameter("pageNum"); %>
	<jsp:useBean id="dto" class ="com.lec.dto.BoardDto"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>	
<%-- <%=dto %> --%>	
<% 
	dto.setIp(request.getRemoteAddr());
	BoardDao dao = BoardDao.getInstance();
	int result;
	if (dto.getNum() == 0) {//원글쓰기
		result = dao.insertBoard(dto);
	} else {
		result = dao.reply(dto);
	}
	
	if (result == BoardDao.SUCCESS){
	%>
		<script type="text/javascript">
			alert("글쓰기 완료");
			location.href = 'list.jsp?pageNum=<%=pageNum %>';
		</script>
	<% 	
	}else {
	%>
		<script type="text/javascript">
			alert("글쓰기 실패");
			history.back();
		</script>
	<% 		
		
	}
%> 
</body>
</html>