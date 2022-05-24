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
	<form action="ExPro.jsp">
		<button name="btn" class = "btn1" value = 1>1번</button>
		<button name="btn" class = "btn1" value = 2>2번</button>
		<button name="btn" class = "btn1" value = 3>3번</button>
		</form>
		<div id="msg">
		 
		<% String msg = request.getParameter("msg"); 
		if (msg!=null){
			out.print("<h2>"+msg+"</h2>");
		}
		%>
	</div>
</body>
</html>