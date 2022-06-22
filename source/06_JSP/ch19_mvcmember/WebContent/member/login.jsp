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
	<title>로그인</title>
	<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ${requestScope.joinResult} -->
	<c:if test="${not empty joinResult }">
		<script type="text/javascript">
			alert('회원가입을 축하드립니다.');
		</script>
	</c:if>
	<!-- ${requestScope.joinErrorMsg} -->
	<c:if test="${not empty joinErrorMsg }">
		<script type="text/javascript">
			alert('${joinErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty Logout }">
		<script type="text/javascript">
			alert('로그아웃이 완료되었습니다.');
		</script>
	</c:if>
	<form action="${conPath }/login.do" method="post">
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
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location ='${conPath}/joinView.do'">
			</td>
		</tr>
	</table>
	</form>
	<!-- ${requestScope.mid } -->
</body>
</html>