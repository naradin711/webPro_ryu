<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수정작업</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%  
	request.setCharacterEncoding("UTF-8"); 
	String pageNum = request.getParameter("pageNum"); //pageNum 추가
%>
<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<!-- 들어온 파라미터 : subject, content, email, pw, num -->
<!-- 업데이트에 필요한 파라미터 : subject, content, email, pw, num, ip -->
<%
	dto.setIp(request.getRemoteAddr());
	BoardDao dao = BoardDao.getInstance();
	int result = dao.updateBoard(dto);
	if(result == BoardDao.SUCCESS) {
%>  <script type="text/javascript">
		alert("글 수정 성공");
		location.href = 'list.jsp?pageNum=<%=pageNum%>';		
	</script>
	<!-- location.href =  -->	
	<%} else { %>
	<script type="text/javascript">
		alert("글 수정 실패");
		//
		location.href = '<%=conPath %>/board/updateForm.jsp';
		
	</script>	
	<%}%>
</body>
</html>