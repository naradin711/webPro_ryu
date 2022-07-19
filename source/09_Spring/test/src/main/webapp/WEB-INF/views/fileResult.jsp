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
	<h2>파일 업로드 결과 : ${fileResult }</h2>
	<p>file1 : ${filenames[0] }</p>
	<p>file2 : ${filenames[1] }</p>
	<p>file3 : ${filenames[2] }</p>
	<c:if test="${not empty filenames[0] }">
		<img src="upload/${filenames[0] }">
	</c:if>
	<c:if test="${empty filenames[0] }">
		첫번째 첨부파일 첨부 안 함
	</c:if>
	<c:if test="${not empty filenames[1] }">
		<img src="upload/${filenames[1] }">
	</c:if>
	<c:if test="${empty filenames[1] }">
		두번째 첨부파일 첨부 안 함
	</c:if>
	<c:if test="${not empty filenames[2] }">
		<img src="upload/${filenames[2] }">
	</c:if>
	<c:if test="${empty filenames[2] }">
		세번째 첨부파일 첨부 안 함
	</c:if>
</body>
</html>