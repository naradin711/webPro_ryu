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
			// list.jsp 또는 list.jsp?pageNum ==11 또는  list.jsp?pageNum=1
			/***********************************************************/
			final int PAGESIZE = 10, BLOCKSIZE = 10 ;
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1"; // 전달받은 숫자 없으면 1페이지로
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1) * PAGESIZE+1;
			int endRow = startRow + PAGESIZE - 1;
			/***********************************************************/
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt(); // 등록된 글 갯수
			if (totalCnt == 0) { // 글이 없으면!
				out.println("<tr><td colspan='5'>등록된 글이 없습니다.</td></tr>");
			} else { // 글이 1개라도 있으면!			
				ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow); /**첫행 끝행 넣고 바로 실행**/
				for (BoardDto dto : dtos) {
					// 글번호 작성자 글제목 메일 조회수 순서
					out.println("<tr> <td>"+dto.getNum()+"</td> <td>"+dto.getWriter()+"</td>");
					out.println("<td class='left'>");
					// 답변글 RE_INDENT값에 따라 들여쓰기 - RE.GIF 출력
					if (dto.getReIndent() > 0) {
						int width = dto.getReIndent() * 20;
						out.println("<img src= '"+ conPath +"/img/re.gif' width='"+width+"', height='10'>");
					}
					
					// 조회수가 10 초과시 HOT.GIF 출력
					if(dto.getReadCount() > 10){
						out.println("<img src= '"+ conPath +"/img/hot.gif'>");		
					}
					out.println("<a href='"+conPath+"/board/content.jsp?num="+dto.getNum()+
											"&pageNum="+pageNum+"'>" 
					                        + dto.getSubject()+"</a></td>");
					out.println("<td>"+dto.getEmail()+"</td> <td>"+dto.getReadCount()+"</td></tr>");
				}//for
			}//if
		%>
	</table>
	<div class="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totalCnt/ PAGESIZE); // 페이지 갯수 (다음 블록 여부 계산)
		int startPage = ((currentPage-1)/BLOCKSIZE * BLOCKSIZE +1 );
		int endPage = startPage + BLOCKSIZE -1;
		if (endPage > pageCnt) { // 페이지 수보다 엔드 페이지 값이 클 경우 페이지 수에 엔드 페이지를 맞춘다
			endPage = pageCnt;
		}
		if (startPage > BLOCKSIZE) { // 이전 블록이 있는지 여부 <a href="list.jsp=10">이전</a>
			out.println("[<a href='list.jsp?pageNum="+(startPage-1)+"'> 이전 </a>]");	
		}
		for(int i=startPage ; i <= endPage ; i++) {
			if (i==currentPage){ // 페이지 숫자만 출력 <b>사용
				out.println("[<b> "+ i +" </b>]");	
			} else { // a 태그를 포함한 페이지 수 출력
				out.println("[<a href='list.jsp?pageNum="+ i +"'> "+ i +" </a>]");	
			}
		}
		if ( endPage < pageCnt ){ // 다음 블록 있는지 여부
			out.println("[<a href='list.jsp?pageNum="+(endPage+1)+"'> 다음 </a>]");		
			
		}
	%>	
	</div>
</body>
</html>















