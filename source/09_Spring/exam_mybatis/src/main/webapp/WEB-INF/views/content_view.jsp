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
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
<!--${board} ${param.bid}  ${param.pageNum} --> 
	<c:set var="SUCCESS" value ="1"/>
	<c:set var="FAIL" value ="0"/> 
	<table>
		<caption>상세보기</caption>
		<tr> <th>글번호</th> <td>${board.bid }</td> </tr>
		<tr> <th>작성자</th> <td>${board.bname }</td> </tr>
		<tr> <th>글제목</th> <td>${board.btitle }</td> </tr>
		<tr> <th>본문</th><td><pre>${board.bcontent }</pre></td></tr>
		<tr> 
			<th>작성일</th> 
			<td><fmt:formatDate value="${board.bdate }" pattern="yy년 MM월dd일"/></td>
		</tr>
		<tr> <th>IP</th> <td>${board.bip }</td> </tr>
		<tr> <th>조회수</th> <td>${board.bhit }</td> </tr>
		<tr>
		<td colspan="2">
			<button onclick="location='${conPath }/modifyView.do?bid=${param.bid}&pageNum=${param.pageNum}'">수정</button>
			<button onclick="location='${conPath }/delete.do?bid=${param.bid}&pageNum=${param.pageNum}'">삭제</button>
			<button onclick="location='${conPath }/replyView.do?bid=${param.bid}&pageNum=${param.pageNum}'">답변</button>
			<button onclick="location='${conPath }/boardList.do?pageNum=${param.pageNum}'">목록</button>
		</td>
		</tr>
	</table>
	
</body>
</html>