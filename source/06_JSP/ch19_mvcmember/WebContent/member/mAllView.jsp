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
	<title>회원 정보 모두 보기</title>
	<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<table>
	<caption>회원 정보 보기</caption>
		<c:if test="${list.size() eq 0 }">
			<tr><th>등록된 회원이 없습니다</th></tr>
		</c:if>
		<c:if test="${list.size() != 0 }">
		<tr>
			<c:forEach var="dto" items="${list }">		
				<td>
				 <img alt="memberImg" src="${conPath }/memberPhotoUp/${dto.mphoto}" width="120">
					<br>
					<br>
					${dto.mname } 
					<br>
					(${dto.mid })
					<br>
				</td>		
			</c:forEach>
		</tr>	
		</c:if>
		<tr>
			<td colspan="3">
				<input type="button" value="메인화면" onclick="location ='${conPath}/main.do'">
				<input type="button" value="로그아웃" onclick="location ='${conPath}/logout.do'">
			</td>
		</tr>
	</table>
	<div class="paging">
		<a href="${conPath }/allView.do?pageNum=1">◀◀</a>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${startPage > BLOCKSIZE }" >
			<a href="${conPath }/allView.do?pageNum=${startPage-1 }">◀</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
			[<b> ${i } </b>]
			</c:if>
			<c:if test="${i != pageNum }">
			[<a href="${conPath }/allView.do?pageNum=${i}"> ${i } </a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage + 1}"> ▶ </a>
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<a href="${conPath }/allView.do?pageNum=${pageCnt}">▶▶</a>
		<br> 
	</div> 
</body>
</html>


















