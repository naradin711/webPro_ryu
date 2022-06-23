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
<title>글 수정하기</title>
<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
		$(document).ready(function () {
			
		});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<form action="${conPath}/freeboard_modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum}">
		<input type="hidden" name="fid" 	value="${param.fid}">
		<table>
			<caption>${param.fid }번 글 수정하기</caption>
			<tr> 
				<th>작성자</th>
				<td><input type="text" name="mname" value="${content_view.mname }" readonly="readonly"></td> 
			</tr>
			<tr> 
				<th>글제목</th> 
				<td><input type="text" name="ftitle" value="${content_view.ftitle }"></td> 
			</tr>
			<tr> 
				<th>본문</th> 
				<td><textarea rows="5" cols="20" name="fcontent">${content_view.fcontent }</textarea></td> 
			</tr>
			<tr> 
				<th>파일</th> 
				<td><input type="file" name="ffilename" value="${content_view.ffilename }"></td>  
			</tr>
			<tr> 
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="reset" value="초기화" class="btn"
						   onclick="history.back()">
					<input type="button" value="목록" class="btn" 
					       onclick="location='${conPath}/boardList.do?pageNum=${param.pageNum}'">
				</td>
			</tr>
		</table>
	
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>