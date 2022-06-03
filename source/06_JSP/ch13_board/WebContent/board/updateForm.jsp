<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 수정하기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	String num = request.getParameter("num");
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = dao.getBoardOneLine(num);
	
%>
	<form action="<%=conPath %>/board/updatePro.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>"> <!-- 넘버 파라미터를 히든으로 받음 -->
		<table>
			<caption><%=num %>번 글 수정</caption>
			<tr><th>작성자</th>
				<td><input type="text" name="writer" value="<%=dto.getWriter() %>" readonly="readonly"></td>	
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="subject" value="<%=dto.getSubject() %>" required="required"></td>
			</tr>
			<tr><th>이메일</th>
				<td><input type="email" name="email" value="<%=dto.getEmail()==null? "--" : dto.getEmail()%>"></td>
			</tr>
			<tr><th>본문</th>
				<td><textarea rows="5" cols="5" name="content" required="required"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr><th>비밀번호</th>
				<td><input type="password" name="pw" value="<%=dto.getPw() %>" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
					<input type="button" value="목록" class="btn" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>