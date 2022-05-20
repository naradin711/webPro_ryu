<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결과 출력</title>
	<style type="text/css">
	caption {
	width : 200px;
	text-align: center;
	margin-bottom :12px; 
	}
	td {
	text-align: center;
	}
	</style>
</head>
<body>
	<%
	// 파라미터는 무조건 String 문자열로 들어온다
	// request는 내장 객체 받은 파라미터 값은 String
	//Integer.parseInt (string)은 해당 string 숫자 취급한다.
	int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h3>전달 받은 파라미터 su값은 <%=su %></h3>
	<table>
	<caption> <%=su %>단 구구단</caption>
	<%for(int i=1 ; i<=9; i++){%>
		<tr><td><%=su %>*<%=i%> = <%=su*i%></tr> </td>	
		<%}%>
	
	</table>
</body>
</html>