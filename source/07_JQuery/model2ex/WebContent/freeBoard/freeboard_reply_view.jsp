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
<title>Insert title here</title>
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
	<form action="${conPath }/freeboard_reply.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" 	value="${param.pageNum}">
		<input type="hidden" name="mid" 		value="${member.mid }">
		<input type="hidden" name="fgroup" 		value="${content_view.fgroup}">
		<input type="hidden" name="fstep" 		value="${content_view.fstep}">
		<input type="hidden" name="findent" 	value="${content_view.findent}">
		<table>
			<caption>답글 쓰기</caption>
			<tr> <th>작성자</th> <td><input type="text" name="mname" value="${member.mname }" readonly="readonly"></td> </tr>
			<tr> 
				<th>글제목</th> 
				<td><input type="text" name="ftitle" required="required" value="답) ${content_view.ftitle} "></td> 
			</tr>
			<tr> <th>본문</th> <td><textarea rows="5" cols="20" name="fcontent"></textarea></td> </tr>
			<tr> 
				<th>파일</th> 
				<td><input type="file" name="ffilename"></td>  
			</tr>
			<tr> 
				<td colspan="2">
					<input type="submit" value="답글 작성하기"  class="btn">
					<input type="reset"  value="초기화"		class="btn">
					<input type="button" value="목록" 		class="btn" onclick="location='${conPath}/boardList.do?pageNum=${param.pageNum}'">
				</td>
			</tr>
			
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>