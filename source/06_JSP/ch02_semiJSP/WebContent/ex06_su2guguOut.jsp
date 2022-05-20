<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>단수 출력</title>
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
	int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h3><%=su1%>단 부터 <%=su2%>단 까지 구구단 출력</h3>
	<table>
	<%for (int i = 1; i <=9; i++) { // 먼저 2부터 9까지 세로로 출력할 값 배열%> 
		<tr>
		<%for (int j = su1; j<=su2; j++) { %>
		<td><%=j %> *<%=i %> = <%=i*j %></td>
		<%} %>
		</tr>
		
	<%} %>
	
	</table>
	<br>
	<button onclick="history.back()"> 뒤로가기 </button>
	<button onclick="location.href='ex06_dansu2input.html'"> 새로가기 </button>
</body>
</html>