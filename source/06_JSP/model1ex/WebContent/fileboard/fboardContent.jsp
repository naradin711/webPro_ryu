<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="sun.misc.FDBigInteger"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 상세보기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<style>
		#content_form{
			height: 570px; 
			padding-top:30px;
		}
	</style>
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br>
	<br>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao fbDao = FileboardDao.getInstance();
		fbDao.hitUp(fnum); // 조회수 먼저 올리기!
		FileboardDto fbDto = fbDao.getBoard(fnum);
				
	%>
	<table>
		<caption>글 상세보기</caption>
		<tr> <th>글번호</th> <td><%=fbDto.getFnum() %></td> </tr>
		<tr> 
			<th>작성자</th> 
				<td>
					<%=fbDto.getCname() %> : (<%=fbDto.getCid() %>)
					(<a href="mailto:<%=fbDto.getCemail() %>">
					<%=fbDto.getCemail()==null? "없음" : fbDto.getCemail() %>
					</a>) 
				</td>
		</tr>
		<tr> 
		<th>첨부파일</th> 
			<td>
			<%
				if(fbDto.getFfilename()==null){
					out.println("첨부파일 없음");
					
				}else {
					out.println("<a href='../fileboardUpload/"+fbDto.getFfilename()+"'>"+ fbDto.getFfilename() +"</a>");
				}
			%>
			</td>
		</tr> 
		<tr> 
		<th>본문</th>  <td><pre><%=fbDto.getFcontent() %></pre> </td> </tr>
		<tr> <th>작성일시</th> <td><pre><%=fbDto.getFrdate() %></pre></td></tr> 
		<tr> <th>조회수</th> <td><pre><%=fbDto.getFhit() %></pre></td> </tr>
		<tr> <th>IP</th> <td><pre><%=fbDto.getFip() %></pre></td></tr>
		<tr>
			<td colspan="2"><!-- 목록 수정 답변 삭제 -->
				<button onclick="location='fboardList.jsp?pageNum=<%=pageNum %>'">목록</button>
				<%
					String cid = null;
					CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					if (customer!=null){
						cid = customer.getCid();
					}
					if(fbDto.getCid().equals(cid)){ //세선에서 가져온 아이디와 해당 글의 작성자가 아이디가 같을때 참
					%>
					<button onclick="location='fboardUpdateForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">수정</button>	
					<%}%>
				<%if(customer!=null){ %>
				<button onclick="location='fboardWriteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">답변</button>
				<%} %>				
				<button onclick="location='fboardDeleteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">삭제</button>
			</td>
		</tr>	
	</table>
	
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>





