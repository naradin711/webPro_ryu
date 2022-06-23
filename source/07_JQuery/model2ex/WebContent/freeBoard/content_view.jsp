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
<title>글 상세보기</title>
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
	<table>
		<caption>상세보기</caption>
		<tr> <th>글번호</th> <td>${content_view.fid }</td> </tr>
		<tr> <th>작성자</th> <td>${content_view.mname }</td> </tr>
		<tr> <th>글제목</th> <td>${content_view.ftitle }</td> </tr>
		<tr> <th>본문</th><td><pre>${content_view.fcontent }</pre></td></tr>
		<tr> 
			<th>작성일</th> 
			<td><fmt:formatDate value="${content_view.frdate }" pattern="yy년 MM월dd일"/></td>
		</tr>
		<tr> <th>IP</th> <td>${content_view.fip }</td> </tr>
		<tr> <th>조회수</th> <td>${content_view.fhit }</td> </tr>
		<tr>
		<td colspan="2">
			<button onclick="location='${conPath }/freeboard_modify_view.do?fid=${param.fid}&pageNum=${param.pageNum}'">수정</button>
			<button onclick="location='${conPath }/freeboard_delete.do?fid=${param.fid}&pageNum=${param.pageNum}'">삭제</button>
			<button onclick="location='${conPath }/freeboard_reply_view.do?fid=${param.fid}&pageNum=${param.pageNum}'">답변</button>
			<button onclick="location='${conPath }/boardList.do?pageNum=${param.pageNum}'">목록</button>
		</td>
		</tr>
	</table>
	
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>