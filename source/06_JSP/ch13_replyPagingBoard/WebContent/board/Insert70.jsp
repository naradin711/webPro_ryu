<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>70개 넣기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	// 임의로 70개 글 insert 하기 (원글)
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for (int i=0; i<140 ; i++){
		dto.setWriter("홍길동"+i);
		dto.setSubject(i+"번 제목입니다.");
		dto.setContent("본문입니다."+i);
		dto.setEmail("hong"+i+i+"@hong.com");
		dto.setPw("1");
		dto.setIp("192.168.77.41");
		int result = dao.insertBoard(dto);
		System.out.println(result==BoardDao.SUCCESS? i+"번째 글쓰기 성공":i+"번째 글쓰기 실패" );
		
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>




















