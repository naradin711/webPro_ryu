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
<title>로 그 인</title>
<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
		$(document).ready(function () {
			
		});
</script>
</head>
<body>
	<c:if test="${not empty joinResult }">
		<script type="text/javascript">
			alert('회원가입을 축하드립니다.');
		</script>
	</c:if>
	<c:if test="${not empty joinErrorMsg }">
		<script type="text/javascript">
			alert('${joinErrorMsg}');
			history.back();
		</script>
	</c:if>
  <jsp:include page="../main/header.jsp"/>
  <br> 
  <form action="${conPath }/login.do" method="post" id="content_form1">
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
				<input type="button" value="회원가입" onclick="location ='${conPath}/joinView.do'" class="btn">
			</td>
		</tr>
	</table>
	</form>	
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>