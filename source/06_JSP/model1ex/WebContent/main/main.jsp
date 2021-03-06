<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<% //main.jsp 또는 main.jsp?pageNum=3  
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum="1";
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE =5, BLOCKSIZE=2;
	int startRow = (currentPage-1)*PAGESIZE+1;
	int endRow = startRow + PAGESIZE-1;
	CustomerDao cDao = CustomerDao.getInstance();
	ArrayList<CustomerDto> customers = cDao.listCustomer(startRow, endRow);
	
	%>
	<table>
		<tr style="height:60px;">
			<th>회원ID</th> <th>비밀번호</th> <th>이름</th> <th>메일</th> <th>주소</th>
		</tr>
		<%if(customers.size()==0){ %>
		<tr> <td colspan="5">해당 회원이 존재하지 않습니다.</td> </tr>
		<%}else{  
			for(CustomerDto c : customers) {
				out.println("<tr style='height:60px;'><td>"+c.getCid()+"</td>");
				out.println("<td>"+c.getCpw()+"</td><td>"+c.getCname()+"</td>");
				out.println("<td>"+(c.getCemail()==null? "불명":c.getCemail())+"</td><td>"+
				(c.getCaddress()==null? "불명":c.getCaddress())+"</td></tr>");
			}
		 } %>
	</table>
	<br><br>
		<div class="paging">
		<%
			int totCnt = cDao.getCustomercnt(); //회원수
			int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); //페이지수
			int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
			int endPage = startPage + BLOCKSIZE - 1;
			if (endPage>pageCnt) endPage=pageCnt;
			if (startPage > BLOCKSIZE) {%>
			[<a href="<%=conPath %>/main/main.jsp?pageNum=<%=startPage-1%>">이전</a>]	
			<%}
				for (int i=startPage ; i<=endPage ; i++){
					if(i==currentPage){
						out.println("<b>["+i+"]</b>");
					} else {
			    		out.println("[<a href='"+conPath+"/main/main.jsp?pageNum="+i+"'>"+i+"</a>]");
			    	}
				}
				if(endPage<pageCnt){
					%>
							[<a href="<%=conPath %>/main/main.jsp?pageNum=<%=endPage+1%>">다음</a>]
					<%}%>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>















