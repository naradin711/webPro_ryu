<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %><!-- /project_name 콘텍스트 경로! -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모장</title>
	<link href="<%=conPath %>/css/ex02.css" rel="stylesheet" >
</head>
<body>
	<form action="ex02_memoPro.jsp" method="post">
	 <table>
		<tr>
			<th>작성자</th> <th>한줄메모</th>  
		</tr>
		<tr> 
			<td><input type="text" name="writer" size="3"></td>
			<td><input type="text" name="memo" size="30"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit" value="메모작성" size="5"> </td>
		</tr>
	 </table>
	</form>
	
</body>
</html>


