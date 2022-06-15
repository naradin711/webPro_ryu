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
	<title>검색 목록</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
<h2>검색 목록</h2>
<form action="${conPath }/empSch">
<table>
	<tr> 
		<th colspan="8">
			이름 <input type="text" name="scname">
			직책 <input type="text" name="scjob">
			    <input type="submit" value="검색">
		</th>
	</tr>
	<tr> 
		<th>사번</th> 	<th>이름</th> <th>직책</th> <th>상사</th> 
		<th>입사일</th> 	<th>급여</th> <th>상여</th> <th>부서</th>
	</tr>
	 
	<c:if test="${emps.size() eq 0 }">
	<tr><td colspan="8">등록된 사원이 없습니다</td></tr>
	</c:if>
	<c:if test="${emps.size() != 0 }">
		<c:forEach items="${emps }" var="emp" >
		<tr> 
			<td>${emp.empno }</td> 	
			<td>
				<c:if test="${emp.sal > 2000 }">
					<img src="${conPath }/img/hot.gif">
				</c:if> 
				<c:if test="${emp.mgr eq 0 }">
		    		<b style="color:navy; font-weight:bold;">${emp.ename }</b>
				</c:if>
				<c:if test="${emp.mgr != 0 }">
		    		${emp.ename } 
				</c:if>
			</td> 
			<td>${emp.job }</td> 
			<td>${emp.mgr }</td> 
			<td>
				<fmt:formatDate value="${emp.hiredate }" pattern="yyyy년 MM월 dd일(E) (a) hh:mm:ss"/> 
			</td> 	
			<td>
				<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/> 
			</td> 
			<td>
				<c:if test="${emp.comm eq 0 }">
		    		없음
				</c:if>
				<c:if test="${emp.comm != 0 }">
		    		${emp.comm }
				</c:if>	
			</td> 
			<td>${emp.deptno }</td>
		</tr>
		</c:forEach>
	</c:if>
	 
</table>
</form>
</body>
</html>