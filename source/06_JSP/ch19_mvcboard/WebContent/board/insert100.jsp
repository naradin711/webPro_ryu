<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert Title here</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<% BoardDao dao = BoardDao.getInstance();
		for (int i=0; i<100; i++){
			String bname = "홍길동" +i;
			String btitle = "글제목" +i;
			String bcontent= "글 본문"+i;
			String bip = "111.111.11.11"+i;
			dao.write(bname, btitle, bcontent, bip);
			
		}
		response.sendRedirect("../list.do");
	%>
</body>
</html>








