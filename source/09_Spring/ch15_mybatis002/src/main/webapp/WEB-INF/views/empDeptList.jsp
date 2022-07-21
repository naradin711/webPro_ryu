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
<title>Insert title here</title>
<link href="${conPath }/css/board.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
	function trclicked(empno) {
		location.href = '${conPath}/detail.do?empno=' + empno + '&pageNum=${paging.currentPage}';
		
	}
</script>
<style type="text/css">
	#write {
		text-align: right;
		padding-right: 20px;
	}
</style>
</head>
<body>
	<c:if test="${updateResult eq 1 }">
		<script type="text/javascript">
			alert('수정 성공');
		</script>
	</c:if>
	<c:if test="${deleteResult eq 1 }">
		<script type="text/javascript">
			alert('삭제 성공');
		</script>
	</c:if>
	<c:set var="num" value="${paging.totCnt - paging.startRow +1 }"/>
	<table>
		<caption>직원 목록</caption>
		<tr> <td colspan="7" id="write"> <a href="${conPath}/writeView.do">직원등록</a> </td> </tr>
		<tr>
			<th>번호</th><th>사번</th><th>이름</th><th>직책</th><th>입사일</th><th>급여</th><th>근무지</th>
			 
		</tr>
		<c:forEach items="${empList }" var = "emp">
			<tr onclick="trclicked(${emp.empno})">
				<td>${num }</td>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td><fmt:formatDate value="${emp.hiredate }" dateStyle="long" /></td>
				<td><fmt:formatNumber value="${emp.sal }" groupingUsed="true"/></td>
				<td>${emp.loc }</td>
			</tr>
			<c:set var="num" value="${num-1 }"/>
		</c:forEach>
	</table>
	<br><br>
	<div id="paging">
		<c:if test="${paging.startPage> paging.blockSize }">
		[<a href="${conPath }/empList.do?pageNum=${paging.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage}">
			<c:if test="${i eq paging.currentPage }">
			[<b>${i}</b>]
			</c:if>
			<c:if test="${i != paging.currentPage }">
			[<a href="${conPath }/empList.do?pageNum=${i}">${i}</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
		[<a href="${conPath }/empList.do?pageNum=${paging.endPage +1}">다음</a>]
		</c:if>
	</div>
</body>
</html>