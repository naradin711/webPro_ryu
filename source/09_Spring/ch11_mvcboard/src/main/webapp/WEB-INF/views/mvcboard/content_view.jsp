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
<!--${bDto} ${param.bid}  ${param.pageNum} --> 
	<c:set var="SUCCESS" value ="1"/>
	<c:set var="FAIL" value ="0"/>
	<c:if test="${modifyResult eq SUCCESS }">
		<script type="text/javascript">
			alert("글 수정 성공");
		</script>
	</c:if>
	<table>
		<caption>상세보기</caption>
		<tr> <th>글번호</th> <td>${bDto.bid }</td> </tr>
		<tr> <th>작성자</th> <td>${bDto.bname }</td> </tr>
		<tr> <th>글제목</th> <td>${bDto.btitle }</td> </tr>
		<tr> <th>본문</th><td><pre>${bDto.bcontent }</pre></td></tr>
		<tr> 
			<th>작성일</th> 
			<td><fmt:formatDate value="${bDto.bdate }" pattern="yy년 MM월dd일"/></td>
		</tr>
		<tr> <th>IP</th> <td>${bDto.bip }</td> </tr>
		<tr> <th>조회수</th> <td>${bDto.bhit }</td> </tr>
		<tr>
		<td colspan="2">
			<button onclick="location='${conPath }/mvcboard/modify.do?bid=${param.bid}&pageNum=${param.pageNum}'">수정</button>
			<button onclick="location='${conPath }/mvcboard/delete.do?bid=${param.bid}&pageNum=${param.pageNum}'">삭제</button>
			<button onclick="location='${conPath }/mvcboard/reply.do?bid=${param.bid}&pageNum=${param.pageNum}'">답변</button>
			<button onclick="location='${conPath }/mvcboard/list.do?pageNum=${param.pageNum}'">목록</button>
		</td>
		</tr>
	</table>
	
</body>
</html>