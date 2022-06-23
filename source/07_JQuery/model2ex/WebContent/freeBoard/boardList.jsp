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
<title>자 유 게 시 판</title>
<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
		$(document).ready(function () {
			
		});
</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${writeResult eq SUCCESS}">
		<script type="text/javascript">
			alert('글쓰기 성공');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL}">
		<script type="text/javascript">
			alert('글쓰기 실패');
			history.back();
		</script>
	</c:if>
	<c:if test="${FileBoardModifyResult eq SUCCESS}">
		<script type="text/javascript">
			alert('수정하기 성공');
		</script>
	</c:if>
	<c:if test="${FileBoardModifyError eq FAIL}">
		<script type="text/javascript">
			alert('수정하기 실패');
			history.back();
		</script>
	</c:if>
	<c:if test="${FileBoardDeleteResult eq SUCCESS}">
		<script type="text/javascript">
			alert('삭제 성공');
		</script>
	</c:if>
	<c:if test="${FileBoardDeleteResult eq FAIL}">
		<script type="text/javascript">
			alert('삭제 실패');
			history.back();
		</script>
	</c:if>
	<c:if test="${replyResult eq SUCCESS}">
		<script type="text/javascript">
			alert('답글쓰기 성공');
		</script>
	</c:if>
	<c:if test="${replyResult eq FAIL}">
		<script type="text/javascript">
			alert('답글쓰기 실패');
			history.back();
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<table>
		<caption>자 유 게 시 판</caption>
		<tr>
			<td>
				<c:if test="${empty member && empty admin}">
					<h3>글쓰기는 로그인 이후에 가능합니다.</h3>
				</c:if>	
				<c:if test="${ member != null }">
			 		<a href="${conPath }/write_view.do">글쓰기</a>
				</c:if>
				<c:if test="${ admin != null }">
			 		<a href="${conPath }/write_view.do">글쓰기</a>
				</c:if>
			
			</td>
		</tr>
	</table>
	<table>
		<tr><th>글 번호</th><th>작성자</th><th>글 제목</th><th>IP</th><th>작성일</th><th>조회수</th></tr>
		<c:if test="${blist.size() eq 0 }">
		<tr><td colspan="6">해당 페이지에 글이 존재하지 않습니다.</td></tr>
		
		</c:if>
		<c:if test="${blist.size() != 0 }">
			<c:forEach var="dto" items="${blist }">
			<tr>
				<td>${dto.fid }</td>
				<td>${dto.mname }</td>
				<td class="left">
					<c:forEach var="i" begin="1" end="${dto.findent }">
						<c:if test="${i eq dto.findent }">
							ㄴ
						</c:if>
						<c:if test="${i != dto.findent }">
							&nbsp; &nbsp;
						</c:if>
					</c:forEach><!-- 답변글 들여쓰기 -->
					<a href="${conPath }/content_view.do?fid=${dto.fid}&pageNum=${pageNum}">
					 ${dto.ftitle } </a>
					 <c:if test="${dto.fhit > 10 }">
					 <b> * </b>
					 </c:if>
					 
				</td><!-- 글제목 -->
				<td>${dto.fip }</td>
				<td><fmt:formatDate value="${dto.frdate }" pattern="yy년 MM월dd일"/> </td>
				<td>${dto.fhit }</td>
			</tr>
			</c:forEach>	
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }" >
			[<a href="${conPath }/boardList.do?pageNum=${startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
			[<b> ${i } </b>]
			</c:if>
			<c:if test="${i != pageNum }">
			[<a href="${conPath }/boardList.do?pageNum=${i}"> ${i } </a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
		[<a href="${conPath }/boardList.do?pageNum=${endPage + 1}"> 다음 </a>]
		</c:if>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>