<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>누적합 출력하기</title>
</head>
<body>
	<% String su1 = request.getParameter("su"); %>
	<form action="#">
		<fieldset>
			<legend> 숫자입력</legend>
			<table>
				<tr> 
					<th>숫자</th>
					<td><input type="text" name="su" class="su" 
					value="<%if(su1!=null) out.print(su1);%>"></td>
					<td><input type="submit" value="누적"></td>
			</tr>
			
			</table>
			<%
			 if (su1!=null && !su1.equals("")){
				 int s1 = Integer.parseInt(su1);
				 int total = 0;// 누적변수
				 for (int i =1 ; i <=s1; i++){
					 total += i;
				 }
				 out.println("<h2>1부터 "+s1+"까지의 누적합은 "+total+"이다.</h2>");
			 }  
			 %>
		</fieldset>
	</form>
</body>
</html>