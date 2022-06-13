<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
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
<jsp:include page="../main/header.jsp"/>
<br>
<br>
	<div id="content_form">
	<%
	String pageNum = request.getParameter("pageNum");
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	FileboardDao fbDao = FileboardDao.getInstance();
	FileboardDto fbDto = fbDao.getBoard(fnum);
	System.out.println(fbDto+"글 수정 ㄱㄱ");
	%>
	
	<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="dbfilename" value="<%=fbDto.getFfilename() %>">
		<table>
			<caption>글 수정하기</caption>
			<tr> 
				<th>글번호</th> 
				<td>
					<input type="text" name="fnum" value="<%=fnum %>" readonly="readonly">
				</td> 
			</tr>
		    <tr> 
				<th>글제목</th> 
				<td>
					<input type="text" name="fsubject" value="<%=fbDto.getFsubject() %>" 
					       autofocus="autofocus" required="required">
				</td>
		    </tr>
		    <tr> 
		    	<th>첨부파일</th> 
				<td>
			    	<input type="file" name="ffilename" style="width:30%;"> 
			    	 <%
			    	 	if(fbDto.getFfilename()!=null){
			    	 		out.println("첨부파일 : " + fbDto.getFfilename());
			    	 	} else {
			    	 		out.println("첨부파일 없음");
			    	 	}
			    	 %>
				</td>
		    </tr> 
		    <tr>
		    	<th>본문</th>  
		    	<td>
		    		<textarea rows="5" cols="20" name="fcontent">
		    		<%=fbDto.getFcontent() %></textarea> 
		    	</td> 
		    </tr>
		    <tr> 
		    	<th>삭제용 비밀번호</th> 
				<td>
			    	<input type="password" name="fpw" value="<%=fbDto.getFpw() %>" required="required"> 		    	 
				</td>
		    </tr> 
			<tr>
				<td colspan="2">
					<input type="submit" 	value="글 수정" 	class="btn">
					<input type="reset" 	value="수정 취소" 	class="btn" onclick="history.back()">
					<input type="button" 	value="목록" 		class="btn" 
						   onclick="location='fboardList.jsp?pageNum=<%=pageNum %>'">
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










