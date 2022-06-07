<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	int num=0 ; //  변수 초기화
	BoardDto dto = new BoardDto();
	String pageNum = request.getParameter("pageNum");
	if(pageNum ==null) {
		pageNum = "1";
	}
	if (request.getParameter("num")!=null) { // 답변글을 위해 들어왔다면 원글의 정보를 dto에서 가져온다.
		num = Integer.parseInt(request.getParameter("num"));
		BoardDao dao = BoardDao.getInstance();
		dto = dao.getBoardOneLine(num); // 원글에 대한 정보
	    System.out.println("writeForm.jsp에서 원글의 ref : " + dto.getRef());
	    System.out.println("writeForm.jsp에서 원글의 reStep : " + dto.getReStep());
	    System.out.println("writeForm.jsp에서 원글의 reIndent : " + dto.getReIndent());
	}
%>
	<form action="writePro.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="ref" value="<%=dto.getRef() %>">
		<input type="hidden" name="reStep" value="<%=dto.getReStep() %>">
		<input type="hidden" name="reIndent" value="<%=dto.getReIndent() %>">
		<table>
			<caption>게 시 판</caption>
			<tr><th>작성자</th><td><input type="text" name="writer" required="required"></td></tr>
			<tr>
				<th>글 제목</th>
				<td>
					<input type="text" name="subject" required="required" value="<%
					if (dto.getSubject()!=null) { // 답변글
						out.print("답 : " + dto.getSubject());
					}	
						%>">
					
				</td>
			</tr>
			<tr><th>이메일</th><td><input type="email" name="email"></td></tr>
			<tr><th>본문</th>
				<td><textarea name="content" rows="5" cols="5" required="required"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required">
			</tr>
			<tr>
				<td colspan="2"> 
					<input type="submit" value = "글쓰기" class="btn">
					<input type="reset" value = "취소" class="btn">
					<input type="button" value = "목록" class="btn" 
					onclick="location.href='list.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>