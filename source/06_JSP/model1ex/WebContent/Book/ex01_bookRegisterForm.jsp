<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 등 록</title>
	<link href="<%=conPath %>/css/style1.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<form action="ex02_bookRegisterPro.jsp" method="post" 
	      enctype="multipart/form-data" id="book_Form">
	      <table>
	      	<caption>책 등 록</caption>
	      	<tr>
	      		<th>책 제목</th>
	      		<td><input type="text" name="btitle" maxlength="30" required="required"></td>
	      	</tr>
	      	<tr>
	      		<th>책 가격</th>
	      		<td><input type="number" name="bprice" min="0" max="9999999" required="required"></td>
	      	</tr>
	      	<tr>
	      		<th>책 대표 이미지</th>
	      		<td><input type="file" name="bimage1"></td>
	      	</tr>
	      	<tr>
	      		<th>책 부가 이미지</th>

	      		<td><input type="file" name="bimage2"></td>
	      	</tr>
	      	<tr>
	      		<th>책 소개</th>

	      		<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
	      	</tr>
	      	<tr>
	      		<th>할인율</th>
	      		<td><input type="number" name="bdiscount" min="0" max="99" ></td>
	      	</tr>
	      	<tr>
	      		<td colspan="2"> <input type="submit" value="등록하기" > <input type="reset" value="등록취소" ></td>
	      	</tr>
	      </table>	        
	
	</form>
	<br>
	<br>
	<br>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>