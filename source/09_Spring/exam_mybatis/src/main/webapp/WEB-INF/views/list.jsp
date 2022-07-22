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
		location.href = '${conPath}/detail1.do?bid=' + bid + '&pageNum=${paging.currentPage}';
		
	}
</script>
</head>
<body>
	<h1 align="center">게 시 판</h1>
	<c:set var="SUCCESS" value ="1"/>
	<c:set var="FAIL" value ="0"/>
	
	<!-- 글수정 성공 / 실패 -->
	<c:if test="${modifyResult eq SUCCESS }">
		<script type="text/javascript">
			alert("글 수정 성공");
		</script>
	</c:if>
	<!-- 글쓰기 성공 / 실패 -->
	<c:if test="${writeResult eq SUCCESS }">
		<script type="text/javascript">
			alert("글쓰기 성공");
		</script>
	</c:if>
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
	<table style="margin : 0 auto;">
		<tr>
			<th colspan="6"><a href="${conPath }/writeView.do">글쓰기</a></th> 
		</tr>
		<tr>
			<th>글번호</th><th>글쓴이</th>
			<th>제목</th><th>작성일</th><th>조회수</th> <th>아이피</th> 
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr> <th colspan="6">등록된 글이 없습니다.</th> </tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${boardList }" var="board">
				<tr onclick="trclicked(${board.bid})"> 
					<td>${board.bid }</td>
					<td>${board.bname }</td>
					<td class = "left">
						<c:forEach var="i" begin="1" end="${board.bindent }" step="1">
						 	<c:if test="${i == board.bindent  }">
						 		└─
						 	</c:if>
						 	<c:if test="${i != board.bindent  }">
						 		&nbsp; &nbsp; &nbsp; 
						 	</c:if> 
						 	
						</c:forEach>
						${board.btitle }
					</td>  
					<td>
						<fmt:formatDate value="${board.bdate }" pattern="yy년MM월dd일(E)"/>
					 <td>
						<fmt:formatNumber value="${board.bhit }" groupingUsed="true"/>
					</td>
					<td>${board.bip }</td>
				</tr> 
			</c:forEach>
		</c:if>
	</table>
	<div id="paging" align="center">
		<c:if test="${paging.startPage> paging.blockSize }">
		[<a href="${conPath }/boardList.do?pageNum=${paging.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage}">
			<c:if test="${i eq paging.currentPage }">
			[<b>${i}</b>]
			</c:if>
			<c:if test="${i != paging.currentPage }">
			[<a href="${conPath }/boardList.do?pageNum=${i}">${i}</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
		[<a href="${conPath }/boardList.do?pageNum=${paging.endPage +1}">다음</a>]
		</c:if>
	</div>
</body>
</html>













