<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>시간 출력하기</title>
	
</head>
<body>
<!-- HTML주석 -->;
<%-- JSP주석 --%>;

	<%
	Date now = new Date();
	// String format을 통해 date의 출력 형식을 변경
	String str = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분", now);
	Calendar now2 = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일은 좋은날입니다.");
	String str2 = sdf.format(now2.getTime());
	%>
	<%=str%><br>
	<%=str2%>
</body>
</html>