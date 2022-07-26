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
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<br><br>
	<h1 align="center">도서 상세 정보</h1>
	<br><br>
	<c:set var="SUCCESS" value ="1"/>
	<c:set var="FAIL" value ="0"/>
	
	<!-- 글수정 성공 / 실패 -->
	<c:if test="${modifyResult eq SUCCESS }">
		<script type="text/javascript">
			alert("도서 정보 수정 성공");
		</script>
	</c:if>
	<!-- 글쓰기 성공 / 실패 -->
	<c:if test="${registerResult eq SUCCESS }">
		<script type="text/javascript">
			alert("도서 등록 성공");
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
	<form action="${conPath }/book.do?method=registerBook" method="post" enctype="multipart/form-data">
	<table style="margin : 0 auto;"> 
		<tr>
			<th>제목</th> <td>
			<input type="text" name="btitle"></td>
		</tr>
		<tr>
			<th>글쓴이</th><td> 
			<input type="text" name="bwriter"></td>		
		</tr>
		<tr>
			<th>도서정보</th><td> 
			<input type="text" name="binfo"></td>  	
		</tr> 
		<tr> 
			<td align="center" colspan="2">
				<input type="file" name="tempbimg1"> 
			</td> 
		</tr> 
		<tr> 
			<td align="center" colspan="2">
				<input type="file" name="tempbimg2">
			</td> 
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value ="등록하기">
				<input type="button" value ="뒤로가기" onclick="history.back()"> 
			
			</td>
		</tr>
	</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>