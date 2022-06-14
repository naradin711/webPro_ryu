<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<style type="text/css">
		form {
			width : 400px;
			margin : 5px auto;
		}
		table {
			width : 400px;
			margin : 5px auto;
			border: 5px solid #1E90FF;
			border-radius: 5px;
		}
		table tr td {
			width : 400px;
			height : 30px;
			line-height : 30px;
			text-align: center;
		}
		.num {
			width : 50px;
			height : 20px;
			line-height : 20px;
			text-align: center;
		}
		b {
			font-size: 1.5em;
			color : red;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<table>
		<form action="">
		<tr>
			<td>
				<input type="number" name="su1" value="<%=(int)(Math.random()*9)+1%>" class="num"> * 
				<input type="number" name="su2" value="<%=(int)(Math.random()*9)+1%>" class="num"> = 
				<input type="number" name="result" class="num">
			</td>
		</tr>
		<tr><td> </td></tr> 
		<tr><td><input type="submit" value="확인"></td></tr>
		<tr><td>  </td></tr>
		<tr>
			<td>
				<b>
				${param.su1 } * ${param.su2 } = 
				${param.result } ${param.su1*param.su2 == param.result ? "true":"false" } 입니다.
				</b>
			</td>
		</tr>
		</form>
	</table>
</body>
</html>