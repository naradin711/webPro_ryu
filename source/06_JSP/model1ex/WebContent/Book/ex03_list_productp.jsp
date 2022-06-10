<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 목 록</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<table>
		<tr>
<%
	final int PAGESIZE = 6, BLOCKSIZE=2;
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum="1";
	int currentPage = Integer.parseInt(pageNum);
	int startRow =(currentPage-1)*PAGESIZE+1;
	int endRow = startRow + PAGESIZE-1;
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	for (int i=0 ; i<books.size() ; i++){
%>
	<td>
		<a href="ex04_detail.jsp?bid=<%=books.get(i).getBid() %>&pageNum=<%=pageNum %>">
		<img src="<%=conPath %>/bookImg/<%=books.get(i).getBimage1()%>"><br>
		<%=books.get(i).getBtitle() %><br>
		</a>
		<%if(books.get(i).getBdiscount()!=0){ %>
			<del><%=books.get(i).getBprice() %>원</del> (<%=books.get(i).getBdiscount()%>%할인)<br>
			<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %>원</b>
		<%}else if (books.get(i).getBdiscount()==0){%>
			<b><%=books.get(i).getBprice() %>원</b>
		<%}%>
	</td>
	<%if(i%3==2) out.println("</tr><tr>"); //3번째 글이 나올때마다 줄바꿈 %>
 <% } %>
 		</tr>
 	</table>
 	<div class="paging">
 	<% 
 		int TotalCnt 	= bDao.getBookTotCnt(); // 전체글
 		int pageCnt 	= (int)Math.ceil((double)TotalCnt/PAGESIZE);
 		int startPage 	= ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
 		int endPage 	= startPage + BLOCKSIZE -1;
 		if(endPage>pageCnt){
 			endPage = pageCnt;
 		}
 		if(startPage > BLOCKSIZE){
 			%>
 					[<a href="ex03_list_productp.jsp?pageNum=<%=startPage-1%>">이전</a>]
 			<%  
 			    }for(int i=startPage ; i<=endPage ; i++){
 			    	if(i==currentPage){
 			    		out.println("[<b> "+i+" </b>]");
 			    	}else {
 			    		out.println("[<a href='ex03_list_productp.jsp?pageNum="+i+"'>"+i+"</a>]");
 			    	}//if
 			    }//for
 				if(endPage<pageCnt){
 			%>
 					[<a href="ex03_list_productp.jsp?pageNum=<%=endPage+1%>">다음</a>]
 			<%}%>	
 	</div>
 	
</body>
</html>

















