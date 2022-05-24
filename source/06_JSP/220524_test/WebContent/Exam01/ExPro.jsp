<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동전이 있는 곳을 맞춰봐</title>
<link href="../css/Ex01.css" rel="stylesheet" >
</head>
<body>
	
	<%
		int min = 1;
		int max = 4;
		int random = (int)((Math.random()*(max - min))+min);
		int num = Integer.parseInt(request.getParameter("btn"));
		
		if (num==random){
			String msg1 = "<h2><p>정답입니다!</p><br>동전이 있던 곳은 "+num+"!</h2>";
			out.println(msg1);
			
		} else {
			String msg = "<p>Wrong! Try Again!</p><br>"+num+"은 정답아니고 "+random+"!";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("Ex.jsp?msg="+msg);
		}
	%>
	<br>
	<br>
	<button class="btn2" name="btn" onclick="history.go(-1)">다시 도전</button>
	<br>
</body>
</html>