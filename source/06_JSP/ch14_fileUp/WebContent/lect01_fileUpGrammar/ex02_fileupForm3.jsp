<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 첨부</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<style type="text/css">
		.frm {
			border: 3px solid gray;
			width: 500px;
			height : 300px;
			line-height: 65px;
			text-align: center;
			margin: 50px auto;
		}
	</style>
</head>
<body>
	<form action="ex02_fileupPro3.jsp" method="post" enctype="multipart/form-data" class="frm">
		
		<p>파일1<input type="file" name="file1" ></p>
		<p>파일2<input type="file" name="file2" ></p>
		<p>파일3<input type="file" name="file3" ></p>
		<input type="submit" value="파일 업로드" class="btn">
	</form> 
</body>
</html>












