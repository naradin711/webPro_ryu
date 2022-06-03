<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게 시 판</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%	
	int num = Integer.parseInt(request.getParameter("num")); // list.jsp에서 num 값을 받아옴
	BoardDao dao = BoardDao.getInstance(); // dao 생성 및 자기 참조하기
	dao.readcountUp(num); // 조회수 올려주기
	BoardDto dto = dao.getBoardOneLine(num); // 글 번호로 글 가져오기 
	
%>
	<table>
		<caption><%= dto.getNum() %>번 글 상세보기</caption>
		<tr><th>글번호</th>	<td><%=dto.getNum() %></td></tr>
		<tr><th>글제목</th>	<td><%=dto.getSubject() %></td></tr>
		<tr><th>이메일</th>	<td><%=dto.getEmail()==null ? "--":dto.getEmail() %></td></tr>
		<tr><th>조회수</th>	<td><%=dto.getReadCount() %></td></tr>
		<tr><th>본문</th>		<td><pre><%=dto.getContent() %></pre></td></tr>
		<tr><th>IP</th>		<td><%=dto.getIp() %></td></tr>
		<tr><th>글쓴 시점</th>	<td><%=dto.getRdate() %></td></tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='<%=conPath %>/board/updateForm.jsp?num=<%=num %>'">수정</button>
				<button onclick="location.href='<%=conPath %>/board/deleteForm.jsp?num=<%=num %>'">삭제</button>
				<button onclick="">답변</button>
				<button onclick="location.href='list.jsp'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>














