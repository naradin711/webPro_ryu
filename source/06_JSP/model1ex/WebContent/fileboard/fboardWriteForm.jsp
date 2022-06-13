<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 작성하기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<style>
		#content_form{
			height: 550px; 
			padding-top:50px;
		}
	</style>
	
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<br>
<br>
	<div id="content_form">
	<%
		if(session.getAttribute("customer")==null){
			response.sendRedirect(conPath+"/customer/loginForm.jsp");
		}
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		int fnum = 0; // 글 번호는 0으로 초기화
		FileboardDto fbDto = new FileboardDto();
		if(request.getParameter("fnum")!=null){//원글이 있어서 답글을 작성할 경우
			fnum=Integer.parseInt(request.getParameter("fnum"));
			FileboardDao fbDao = FileboardDao.getInstance();
			fbDto = fbDao.getBoard(fnum); // 원글에 대한 정보 fref fre step fre level 필요
		}
	%>
		<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="fnum" value="<%=fnum %>">
			<input type="hidden" name="fref" value="<%=fbDto.getFref() %>">
			<input type="hidden" name="frestep" value="<%=fbDto.getFrestep() %>">
			<input type="hidden" name="frelevel" value="<%=fbDto.getFrelevel() %>">
			<table>
				<caption><%=fnum==0? "글쓰기":"답글 쓰기" %></caption>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="fsubject" required="required" autofocus="autofocus" 
						value="<%
						if (fbDto.getFsubject()!=null){
							out.print("답) " + fbDto.getFsubject());
						}
						%>">
					</td>
				</tr>
				<tr><th>첨부파일</th><td><input type="file" name="ffilename"></td></tr>
				<tr><th>본문</th><td><textarea rows="5" cols="20" name="fcontent"> </textarea> </td></tr>
				<tr><th>작성비밀번호</th><td><input type="password" name="fpw" required="required"></td></tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="<%=fnum==0? "글쓰기":"답글 쓰기"  %>" name="submit" class="btn">
						<input type="reset"  value="다시 쓰기" name="ffilename" class="btn">
						<input type="button" value="목록" name="flist" class="btn"
							   onclick="location.href='fboardList.jsp?pageNum=<%=pageNum %>'">
					</td>
				</tr>
			</table>
		</form>
	</div>
<br>
<br>
<br>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>








