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
</head>
<body>
<!--${content_view} ${param.bid}  ${param.pageNum} --> 
	<table>
		<caption>상세보기</caption>
		<tr> <th>글번호</th> <td>${content_view.bid }</td> </tr>
		<tr> <th>작성자</th> <td>${content_view.bname }</td> </tr>
		<tr> <th>글제목</th> <td>${content_view.btitle }</td> </tr>
		<tr> <th>본문</th><td><pre>${content_view.bcontent }</pre></td></tr>
		<tr> 
			<th>작성일</th> 
			<td><fmt:formatDate value="${content_view.bdate }" pattern="yy년 MM월dd일"/></td>
		</tr>
		<tr> <th>IP</th> <td>${content_view.bip }</td> </tr>
		<tr> <th>조회수</th> <td>${content_view.bhit }</td> </tr>
		<tr>
		<td colspan="2">
			<button onclick="location='${conPath }/modify_view.do?bid=${param.bid}&pageNum=${param.pageNum}'">수정</button>
			<button onclick="location='${conPath }/delete.do?bid=${param.bid}&pageNum=${param.pageNum}'">삭제</button>
			<button onclick="location='${conPath }/reply_view.do?bid=${param.bid}&pageNum=${param.pageNum}'">답변</button>
			<button onclick="location='${conPath }/list.do?pageNum=${param.pageNum}'">목록</button>
		</td>
		</tr>
	</table>
	
</body>
</html>