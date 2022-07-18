<%@page import="com.lec.ch11.dto.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
<%
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto bDto = new BoardDto();
	for (int i=0 ; i<101; i++){
		bDto.setBname("홍길동"+i);
		bDto.setBtitle("제목"+i);
		bDto.setBcontent("본문입니다");
		bDto.setBip("111.254.55.17"+i);
		int result = boardDao.write(bDto); 
		System.out.println(i +"번째 : " + (result==1? "성공" : "실패"));
	}
	response.sendRedirect("mvcboard/list.do");
%>
</body>
</html>





