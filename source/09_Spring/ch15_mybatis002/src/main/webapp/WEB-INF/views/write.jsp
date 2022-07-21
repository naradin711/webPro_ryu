<%@page import="java.sql.Date"%>
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
		$('form').submit(function(){
			var msg = $('span').text();
			if(!msg){
				alert('사번 중복확인 요망합니다.');
				return false;
			}
			if(msg != '사용 가능한 사번입니다.'){
				alert('사용 가능한 사번으로 등록하십시오.')
				frm.empno.focus();
				return false;
			}
			
		});
	});
	function chk() {
		if(! frm.empno.value){
			alert('사번을 입력 후 중복확인 하십시오.')
			frm.empno.focus();
		} else {
			var empno = frm.empno.value;
			location.href = 'confirmNo.do?empno='+empno;
		}
	}
</script>
</head>
<body>
	<c:if test="${not empty updateResult }">
		<script>alert('${writeResult}');</script>
	</c:if>
	<form action="write.do" method="post" name="frm"> <!-- 중복확인 처리용 -->
		<input type="hidden" name = "pageNum" value="${param.pageNum }" >
	<table>
		<caption>직원 정보 수정</caption>
		<tr>
			<th>사번</th>
			<td>
				<input type="text" name="empno" required="required" value="${param.empno }"> 
				<input type="button" value="중복확인" onclick="chk()" class="btn"><br>
				<span> <c:if test="${not empty msg }"> ${msg }</c:if> </span> 
			</td>
		</tr>
		<tr><th>이름</th><td><input type="text" name="ename"></td></tr>
		<tr><th>업무</th><td><input type="text" name="job" required="required"></td></tr>
		<tr>
			<th>관리자</th>
			<td>
				<select name="mgr">
				<c:forEach items="${managerList }" var="mgrEmp">
					<option value="${mgrEmp.empno }">${mgrEmp.empno } / ${mgrEmp.ename }</option>
				</c:forEach>
					
				</select>
			</td>
		</tr>
		<tr>
			<th>입사일</th>
			<td>
				<input type="date" name="tempHiredate" value="<%=new Date(System.currentTimeMillis()) %>">
			</td>
		</tr>
		<tr><th>급여</th><td> <input type="number" name="sal" value="800"></td></tr>
		<tr><th>상여</th><td> <input type="number" name="comm" value="0"></td></tr>
		<tr>
		<th>부서번호</th>
		<td> 
			<select name="deptno">
				<c:forEach items="${deptList }" var="dept">
					<option value="${dept.deptno }">${dept.deptno } /  ${dept.dname } / ${dept.loc }</option>
				</c:forEach> 
			</select> 
		</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록하기">
				<input type="reset" value="취소" onclick="history.back()">
				<input type="button" value="목록" onclick="location='empDeptList.do?pageNum=${param.pageNum}'"> 
			</td>
		</tr>
	</table>
	</form>
</body>
</html>