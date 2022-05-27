<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그아웃</title>
	<link href="<%=conPath %>/css/style1.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		#mainForm_wrap {
						width : 430px; margin : 0 auto;
						height : 330px; padding : 100px; color : #D4A190;
						text-align: center; font-size: 2.0em; font-weight: bold;
					   }	
	</style>
</head>
<body>
<% session.invalidate(); %>
<jsp:include page="header.jsp"/>
	<br>
	<br>
	<div id="mainForm_wrap">
	<script>
        setTimeout(function () {
            location.href = "main.jsp";
        }, 3000); // 3000mls 3초 후에 펑션 실행
    	</script>
<%   
		
		out.println("성공적으로 로그아웃되었습니다.<br><br>");
		out.println("3초 뒤에 메인 페이지로 이동됩니다.<br>");
	 
%>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>