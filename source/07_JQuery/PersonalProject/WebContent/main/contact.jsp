<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONTACT</title>
<link href="${conPath }/css/stylep3.css " rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
		$(document).ready(function () {
			
		});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<br>
	<br>
	<h1>Contact Us</h1>
	<br>
	<br>
	<img alt="main_image" src="${conPath }/main/map.png" width=500px;><br><br>
	<img alt="main_image" src="${conPath }/main/mapAddress.png"><br>
	<br><br>
	<h1>E-mail : youvely1119@google.com</h1><br>
	<h1>TEL :  02-094-0211 </h1><br>
	<h1>FAX :  02-994-0211 </h1><br>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>