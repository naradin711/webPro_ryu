<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>원 글 삭제</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<br>
<br>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		String fnum = request.getParameter("fnum");
	%>
	<table>
		<caption><%=fnum %>번 글  삭제</caption>
		<tr>
		<td>
			<fieldset>
				<legend>삭제하기 위한 암호 입력</legend>
					<form action="fboardDeletePro.jsp" method="post">
						<input type="hidden" name="pageNum" value="<%=pageNum %>">
						<input type="hidden" name="fnum" value="<%=fnum  %>">
						<p><input type="password" name="fpw"  required="required" class="btn"></p>
						<input type="submit" name=delete value="삭제" class="btn">
						<input type="reset" name=cancel value="취소" class="btn">
					</form>
			</fieldset>
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


















