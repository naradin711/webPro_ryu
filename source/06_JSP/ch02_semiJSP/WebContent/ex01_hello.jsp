<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세상아 안녕!</title>
<script>
	
</script>
</head>
<body>
	<h1>hello world!</h1>
	<%
	int total = 0;
	for (int i =1 ; i <=100 ; i++){
		total += i;
	};
	%>
		<h2>1부터 100까지 누적합은 <%=total %>입니다.</h2>
</body>
</html>