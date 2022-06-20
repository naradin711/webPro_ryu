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
	<title>Main</title>
	<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
</head>
<body>
	<c:if test="${not empty LoginResult }">
		<script type="text/javascript">
			alert('로그인 성공!');
		</script>
	</c:if>
	<c:if test="${not empty LoginError }">
		<script type="text/javascript">
			alert('${LoginError}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty ModifyResult }">
		<script type="text/javascript">
			alert('회원 정보 수정 성공!');
		</script>
	</c:if>
	<c:if test="${not empty ModifyErrorMsg }">
		<script type="text/javascript">
			alert('${ModifyErrorMsg }');
			history.back();
		</script>
	</c:if>
	<form action="##" method="post">
	<table>
		<tr>
			<th>
				<c:if test="${not empty LoginResult }">
				${member.mname }(${param.mid })님 반갑습니다!
				</c:if>
				<c:if test="${empty LoginResult }">
				로그인을 해주세요!
				</c:if>
				<br>
				---------------------------------------
			</th>
	    </tr>
	    
		<tr>
			<td>
				<input type="button" value="정보수정" onclick="location ='${conPath}/modifyView.do'">
				<c:if test="${not empty LoginResult }">
				<input type="button" value="로그아웃" onclick="location ='${conPath}/logout.do'">
				</c:if>
				<c:if test="${empty LoginResult }">
				<input type="button" value="로그인" onclick="location ='${conPath}/loginView.do'">
				</c:if>
				<input type="button" value="전체보기" onclick="location ='${conPath}/allView.do'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>