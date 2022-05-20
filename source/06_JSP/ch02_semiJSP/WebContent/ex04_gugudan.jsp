<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>단수입력</title>
	<style type="text/css">
		table {
			width : 300px;
			margin : 10px auto;
			border : 1px solid blue;
	}
	</style>
</head>
<body>
	<table>
	<caption> 2단 구구단</caption>
	<%for(int i=1 ; i<=9; i++){%>
		<tr><td>2*<%=i%> = <%=2*i%></tr> </td>	
		<%}%>
	
	</table>
</body>
</html>