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
	function trclicked(bnum) {
		location.href = '${conPath}/book.do?method=getDetailBook&bnum=' + bnum + '&pageNum=${paging.currentPage}';
		
	}
</script> 
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		
		<form action="${conPath }/book.do">
			<input type="hidden" name="method" value="bookList">
			<table>
			<tr><td>
			<select name="schItem">
				<option value="" 
				<c:if test="${param.schItem=='' }">selected="selected"</c:if> 
				> 검색조건 </option>
				<option value="all" 
				<c:if test="${param.schItem=='all' }">selected="selected"</c:if> 
				> 책이름 + 저자 </option>
				<option value="btitle" 
				<c:if test="${param.schItem=='btitle' }">selected="selected"</c:if> 
				> 책이름 </option>
				<option value="bwriter" 
				<c:if test="${param.schItem=='bwriter' }">selected="selected"</c:if> 
				> 저자 </option>
			</select>
			<input type="text" name="schWord" value="${param.schWord }">
			<input type="submit" value="검색">
			</td></tr>
			</table>
		</form>  
	<table style="margin : 0 auto;"> 
		<tr>
			<th>도서번호</th><th>제목</th><th>글쓴이</th>
			<th>등록일</th><th>이미지</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr> <th colspan="6">등록된 도서가 없습니다.</th> </tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${bookList }" var="bookDto">
				<tr onclick="trclicked(${bookDto.bnum})"> 
					<td>${bookDto.bnum }</td>
					<td>${bookDto.btitle }</td>
					<td> 
						${bookDto.bwriter }
					</td>  
					<td>
						<fmt:formatDate value="${bookDto.brdate }" pattern="yy년MM월dd일"/>
					 </td>
					 <td>
					 	<img alt="책 이미지" src="${conPath }/bookImgFileUpload/${bookDto.bimg1}" width = "100px">
					 </td>
				</tr> 
			</c:forEach>
		</c:if>
	</table>
	</div>
	<div id="paging" align="center">
		<c:if test="${paging.startPage> paging.blockSize }">
		[<a href="${conPath }/book.do?method=bookList&pageNum=${paging.startPage-1}&schItem=${param.schItem }&schWord=${param.schWord}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage}">
			<c:if test="${i eq paging.currentPage }">
			[<b style="color : red;">${i}</b>]
			</c:if>
			<c:if test="${i != paging.currentPage }">
			[<a href="${conPath }/book.do?method=bookList&pageNum=${i}&schItem=${param.schItem }&schWord=${param.schWord}">${i}</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
		[<a href="${conPath }/book.do?method=bookList&pageNum=${paging.endPage +1}&schItem=${param.schItem }&schWord=${param.schWord}">다음</a>]
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>