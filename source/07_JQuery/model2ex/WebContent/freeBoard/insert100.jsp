<%@page import="com.lec.dao.FileBoardDao"%>
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
	<% FileBoardDao fDao = FileBoardDao.getInstance();
		for (int i=0; i<100; i++){
			String mid = "aaa" ;
			String ftitle = "글제목 00" +i;
			String fcontent= "글 본문 00"+i;
			String ffilename = null;
			String fip = "111.111.11.11"+i;
			fDao.writeFileBoard(mid, ftitle, fcontent, ffilename, fip);
			response.sendRedirect("../boardList.do");
		}
	%>
</body>
</html>








