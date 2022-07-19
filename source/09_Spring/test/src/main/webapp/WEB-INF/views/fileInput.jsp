<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<div align="center">
	<h2>파일 업로드 하기</h2>
	<hr width=500px; color=blue;>
	<form action="fileupload" method="post" enctype="multipart/form-data">
	<p>파일 1<input type="file" name="file1"></p>
	<p>파일 2<input type="file" name="file2"></p>
	<p>파일 3<input type="file" name="file3"></p>
	<input type="submit" value="제출하기">
	</form>
	</div>
	
</body>
</html>