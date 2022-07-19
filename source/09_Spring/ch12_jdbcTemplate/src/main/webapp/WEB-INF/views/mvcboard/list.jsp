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
<title>List!</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			/*$('tr').click(function() {
				var bid = Number($(this).children().eq(2).text());
				if(!isNaN(bid)){
					location.href= '${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum}'
				}
				 
			})*/
	});
	function trclicked(bid) {
		location.href= '${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum}'
		
	}
</script>
</head>
<body>
	<h1>list.jsp</h1>
	<c:set var="SUCCESS" value ="1"/>
	<c:set var="FAIL" value ="0"/>
	<!-- 글쓰기 성공 / 실패 -->
	<c:if test="${writeResult eq SUCCESS }">
		<script type="text/javascript">
			alert("글쓰기 성공");
		</script>
	</c:if>
	<!-- 글수정 성공 / 실패 -->
	<!-- 글삭제 성공 / 실패 -->
	<c:if test="${deleteResult eq SUCCESS }">
		<script type="text/javascript">
			alert("글 삭제 성공");
		</script>
	</c:if>
	<!-- 답글쓰기 성공 / 실패 -->
	<c:if test="${replyResult eq SUCCESS }">
		<script type="text/javascript">
			alert("답글 작성 성공");
		</script>
	</c:if>
	<c:set var="oNum" value="${orderNum }"/>
	<c:set var="iNum" value="${inverseNum }"/>
	<table style="margin : 0 auto;">
		<tr>
			<th colspan="7"><a href="${conPath }/mvcboard/writeView.do">글쓰기</a></th> 
		</tr>
		<tr>
			<th>순번</th><th>역순</th><th>글번호</th><th>글쓴이</th>
			<th>제목</th><th>작성일</th><th>조회수</th> <th>아이피</th> 
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr> <th colspan="7">등록된 글이 없습니다.</th> </tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${boardList }" var="bDto">
				<tr onclick="trclicked(${bDto.bid})">
					<td>${oNum }</td>
					<td>${iNum }</td>
					<td>${bDto.bid }</td>
					<td>${bDto.bname }</td>
					<td class = "left">
						<c:forEach var="i" begin="1" end="${bDto.bindent }" step="1">
						 	<c:if test="${i == bDto.bindent  }">
						 		└─
						 	</c:if>
						 	<c:if test="${i != bDto.bindent  }">
						 		&nbsp; &nbsp; &nbsp; 
						 	</c:if> 
						 	
						</c:forEach>
						${bDto.btitle }
					</td>  
					<td>
						<fmt:formatDate value="${bDto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
					 <td>
						<fmt:formatNumber value="${bDto.bhit }" groupingUsed="true"/>
					</td>
					<td>${bDto.bip }</td>
				</tr>
				<c:set var="oNum" value="${oNum + 1 }"/>
				<c:set var="iNum" value="${iNum - 1 }"/>
			</c:forEach>
		</c:if>
	</table>
	${BLOCKSIZE } / ${startPage }
	<div class="paging" style="margin : 0 auto;">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${startPage - BLOCKSIZE}">이 전</a> ]
		</c:if>
		<c:forEach var="i" begin ="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[<b>${i }</b>]
			</c:if>
			<c:if test="${i != pageNum }">
				[<a href="${conPath }/mvcboard/list.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
			<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${endPage + 1}">다음</a> ]
			</c:if>
	</div>
</body>
</html>













