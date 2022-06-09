<%@page import="com.lec.book.bookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.bookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 전체 리스트</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%	//ex03_list_boardp.jsp 또는 ex03_list_boardp.jsp?pageNum=1 또는 ex03_list_boardp.jsp?pageNum=5
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum="1";
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE = 3, BLOCKSIZE =4;
	int startRow = (currentPage-1)*PAGESIZE+1;
	int endRow	 = startRow + PAGESIZE-1;
	bookDao bDao = bookDao.getInstance();
	ArrayList<bookDto> books = bDao.listBook(startRow, endRow);
%>
	<table>
		<caption> 책 리스트 </caption>
		<tr> <th>책 ID</th> <th>책 이름</th> <th>책 대표이미지</th> <th>가격</th> <th>할인율</th> </tr>
		<%if(books.size()==0){
			out.println("<tr><td colspan='5'>등록된 책이 없습니다.</td></tr>");
		}else{
			for(bookDto book : books){
				out.println("<tr><td>"+book.getBid()+"</td><td>"+book.getBtitle()+"</td>");
				out.println("<td><img src='../bookImg/"+book.getBimage1()+"' width='15'</td>");
				out.println("<td>"+book.getBprice()+"</td><td>"+book.getBdiscount()+"</td></tr>");
			}
			
		}
		
		%>
	</table>
	<div class="paging">
	<%
		int TotalCnt 	= bDao.getBookTotCnt(); // 전체 글 갯수
		int pageCnt 	= (int)Math.ceil((double)TotalCnt/PAGESIZE);
		int startPage 	= ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage 	= startPage + BLOCKSIZE -1;
		if(endPage>pageCnt){
			endPage = pageCnt;
		}
		if(startPage > BLOCKSIZE){
	%>
			[<a href="ex03_list_boardp.jsp?pageNum=<%=startPage-1%>">이전</a>]
	<%  
	    }for(int i=startPage ; i<=endPage ; i++){
	    	if(i==currentPage){
	    		out.println("[<b> "+i+" </b>]");
	    	}else {
	    		out.println("[<a href='ex03_list_boardp.jsp?pageNum="+i+"'>"+i+"</a>]");
	    	}//if
	    }//for
		if(endPage<pageCnt){
	%>
			[<a href="ex03_list_boardp.jsp?pageNum=<%=endPage+1%>">다음</a>]
	<%}%>	
	</div>
</body>
</html>





