<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 목록</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<table>
		<caption> 게 시 판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글 쓰 기</a></td></tr>
		
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt();
			if (totalCnt == 0) { // 글이 없으면!
				out.println("<tr><td colspan='5'>등록된 글이 없습니다.</td></tr>");
			} else { // 글이 1개라도 있으면!
				ArrayList<BoardDto> dtos = dao.listBoard();
				for (BoardDto dto : dtos) {
					// 글번호 작성자 글제목 메일 조회수 순서
					out.println("<tr> <td>"+dto.getNum()+"</td> <td>"+dto.getWriter()+"</td>");
					out.println("<td class='left'>");
					if(dto.getReadCount() > 10){
						out.println("<img src= '"+ conPath +"/img/hot.gif'>");		
					}
					out.println("<a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+"'>" 
					                        + dto.getSubject()+"</a></td>");
					out.println("<td>"+dto.getEmail()+"</td> <td>"+dto.getReadCount()+"</td></tr>");
				}//for
			}//if
		%>
	</table>
</body>
</html>