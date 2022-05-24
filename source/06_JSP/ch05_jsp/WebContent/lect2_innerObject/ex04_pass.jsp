<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성인 인증 완료</title>
</head>
<body>
<%
	int age = Integer.parseInt(request.getParameter("age"));

%>
<h2><%=age %>살 성인이니 주류 구매가 가능합니다.</h2>
<button onclick="history.go(-1);"> 뒤로가기</button>
<!-- 히스토리는 무언가가 출력된 페이지가 아니면 히스토리에 쓰이지 않는다 -->
</body>
</html>