<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% String color= request.getParameter("color"); %>
	<meta charset="UTF-8">
	<title>배경색바꾸기</title>
	<style type="text/css">
		
		body {
		background-color: <%=color %>;
		}
	</style>
</head>
<body>
 <h1>배경색 바꾸기</h1>
 <form action="##" >
  	<select name="color">
  		<option value="red">빨강</option>
  		<option value="orange">주황</option>
  		<option value="yellow">노랑</option>
  		<option value="green">초록</option>
  		<option value="blue">파랑</option>
  		<option value="navy">남색</option>
  		<option value="purple">보라</option>
  	</select>
  	<input type="submit" value="적용">
 </form>
</body>
</html>






























