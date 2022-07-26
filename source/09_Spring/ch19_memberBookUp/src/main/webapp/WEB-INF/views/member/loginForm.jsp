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
<title>로 그 인</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content">
  <form action="${conPath }/member.do?method=loginCheck" method="post">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" name=mid value="${mid }" required="required"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name=mpw required="required"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인" class="btn">
				<input type="button" value="회원가입" onclick="location ='${conPath}/member.do?method=joinForm'" class="btn">
			</td>
		</tr>
	</table>
	</form>	
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>