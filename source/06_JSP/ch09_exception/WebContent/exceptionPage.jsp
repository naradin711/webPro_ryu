<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
	<%@ page isErrorPage="true" %> 
	<!-- 에러가 나면 여기로 온다 -->
	<!-- 200 : 정상상태 				/ 500 : 문법오류나 예외사항이 발생한 경우
		 400 : 해당 문서를 찾을 수 없을 때    / 407 : 인증을 받지 못한 경우                -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	<script type="text/javascript">
		console.log('예외 메세지 : ' + '<%=exception.getMessage() %>');
		console.log('예외 타입 : ' + '<%=exception.getClass().getName() %>');
	</script>	
</head>
<body>
	<h1>공사중입니다. 0으로 나눈 부분은 아직 처리되지 않았습니다.</h1>
	<h3>문의 주시면 감사드리겠습니다. mail주소 추가</h3>
<%
	System.out.println("예외 메세지 : " + exception.getMessage() );
	System.out.println("예외 타입 : " + exception.getClass().getName());
%>	
</body>
</html>