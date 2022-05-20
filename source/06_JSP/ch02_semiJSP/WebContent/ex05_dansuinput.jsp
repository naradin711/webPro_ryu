<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>단수 입력</title>
	<style type="text/css">
	 h1, p {text-align: center;}
	 su {padding-left: 3px;}
	</style>
</head>
<body>
	<h1>원하는 단수를 입력하시오.</h1>
	<form action="ex05_guguOut.jsp" method="get">
	<p>단 수 <input type="number" name="su" id="su" size="20" min="2" max="9" required="required">  </p>
	<p><input type="submit" name="sbmit" value="원하는 구구단 출력" ></p>
	</form>
	
</body>
</html>