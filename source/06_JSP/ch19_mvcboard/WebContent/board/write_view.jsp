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
	<title>글 작성하기</title>
	<link href="${conPath }/css/style2.css " rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${conPath }/write.do" method="post">
		<table>
			<caption>원글쓰기</caption>
			<tr> <th>작성자</th> <td><input type="text" name="bname" required="required"></td> </tr>
			<tr> <th>글제목</th> <td><input type="text" name="btitle" required="required"></td> </tr>
			<tr> <th>본문</th> <td><textarea rows="5" cols="20" name="bcontent"></textarea></td> </tr>
			<tr> 
				<td colspan="2">
					<input type="submit" value="제출" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" onclick="location='${conPath}/list.do'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>













