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
<title>직원 정보 수정하기</title>
<link href="${conPath }/css/board.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<c:if test="${not empty updateResult }">
		<script>alert('${updateResult}');</script>
	</c:if>
	<form action="update.do" method="post">
		<input type="hidden" name = "pageNum" value="${param.pageNum }" >
	<table>
		<caption>직원 정보 수정</caption>
		<tr><th>사번</th><td><input type="text" name="empno" value="${empDto.empno }" readonly="readonly"> </td></tr>
		<tr><th>이름</th><td><input type="text" name="ename" value="${empDto.ename }"></td></tr>
		<tr><th>업무</th><td><input type="text" name="job" value="${empDto.job }"></td></tr>
		<tr><th>상사사번</th><td><input type="number" name="mgr" value="${empDto.mgr }"></td></tr>
		<tr>
			<th>입사일</th>
			<td><input type="date" name="hiredate" value="${empDto.hiredate }"></td>
		</tr>
		<tr><th>급여</th><td> <input type="number" name="sal" value="${empDto.sal }"></td></tr>
		<tr><th>상여</th><td> <input type="number" name="comm" value="${empDto.comm }"></td></tr>
		<tr><th>부서번호</th><td> <input type="number" name="deptno" value="${empDto.deptno }"></td></tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
				<input type="reset" value="취소" onclick="history.back()">
				<input type="button" value="목록" onclick="location='empDeptList.do?pageNum=${param.pageNum}'"> 
			</td>
		</tr>
	</table>
	</form>
</body>
</html>