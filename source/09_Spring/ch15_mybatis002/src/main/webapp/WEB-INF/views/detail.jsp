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
<title>직원 정보 상세보기</title>
<link href="${conPath }/css/board.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<table>
		<caption>직원 정보</caption>
		<tr><th>사번</th><td>${empDto.empno }</td></tr>
		<tr><th>이름</th><td>${empDto.ename }</td></tr>
		<tr><th>업무</th><td>${empDto.job }</td></tr>
		<tr><th>상사사번</th><td>${empDto.mgr }</td></tr>
		<tr>
			<th>입사일</th>
			<td><fmt:formatDate value="${empDto.hiredate }" pattern="yy년MM월dd일(E)"/></td>
		</tr>
		<tr><th>급여</th><td>${empDto.sal }</td></tr>
		<tr><th>상여</th><td>${empDto.comm }</td></tr>
		<tr><th>부서번호</th><td>${empDto.deptno }</td></tr>
		<tr>
			<td colspan="2">
				<button onclick="location='empDeptList.do?pageNum=${param.pageNum}'" >목록</button>
				<button onclick="location='updateView.do?empno=${empDto.empno }&pageNum=${param.pageNum}'" >수정</button>
				<button onclick="location='delete.do?empno=${empDto.empno }'" >삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>