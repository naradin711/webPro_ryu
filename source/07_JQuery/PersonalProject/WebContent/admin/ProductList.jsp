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
<title>상 품 목 록</title>
<link href="${conPath }/css/stylep1.css " rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
		$(document).ready(function () {
			
		});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<c:set var="SUCCESS" value="1"/>
		<c:set var="FAIL" value="0"/>
	<table>
	<caption>물품 목록</caption>
		<tr>
			<th> ID </th> <th> 물품명 </th> <th> 물품 종류 </th> <th> 물품 설명 </th> <th> 물품 사진 </th> <th> 물품 가격 </th> <th> 등록일자 </th>
		</tr>
		<c:if test="${list.size() eq 0 }">
			<tr><th>등록된 회원이 없습니다</th></tr>
		</c:if>
		<c:if test="${list.size() != 0 }">
		 
			<c:forEach var="dto" items="${list }">	
			<tr>	
				<td> 
					${dto.pid } 
				</td>
				<td> 
					${dto.pname } 
				</td>
				<td> 
					${dto.ptype } 
				</td>
				<td> 
					${dto.pcontent } 
				</td>
				<td>
					<img alt="productImg" src="${conPath }/productFileUp/${dto.pphoto}" width="120">			
				</td>
				<td> 
					${dto.pprice } 
				</td>
				<td>
					<fmt:formatDate value="${dto.prdate }" pattern="yy년 MM월dd일"/>
				</td>
		    </tr>		
			</c:forEach>
			
		</c:if>
		<tr>
			<td colspan="7">
				<input type="button" value="물품 등록" onclick="location ='${conPath}/product/addProductView.jsp '">
				<input type="button" value="물품 삭제" onclick="location ='${conPath}/main.do'">
			</td>
		</tr>
	</table>
			<div class="paging">
				<a href="${conPath }/CustomerList.do?pageNum=1">◀◀</a>
					&nbsp; &nbsp; &nbsp;
				<c:if test="${startPage > BLOCKSIZE }" >
					<a href="${conPath }/ProductList.do?pageNum=${startPage-1 }">◀</a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:if test="${i eq pageNum }">
						[<b> ${i } </b>]
					</c:if>
					<c:if test="${i != pageNum }">
						[<a href="${conPath }/ProductList.do?pageNum=${i}"> ${i } </a>]
					</c:if>
				</c:forEach>
				<c:if test="${endPage < pageCnt }">
					<a href="${conPath }/ProductList.do?pageNum=${endPage + 1}"> ▶ </a>
				</c:if>
				&nbsp; &nbsp; &nbsp;
				<a href="${conPath }/ProductList.do?pageNum=${pageCnt}">▶▶</a>
				<br> 
			</div> 
		</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>