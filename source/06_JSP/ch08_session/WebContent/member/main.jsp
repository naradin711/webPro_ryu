<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		#mainForm_wrap {
						width : 430px; margin : 0 auto;
						height : 660px; line-height : 660px; color : #D4A190;
						text-align: center; font-size: 2.0em; font-weight: bold;
					   }	
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		Main
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>