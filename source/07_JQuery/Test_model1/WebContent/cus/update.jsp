<%@page import="com.lec.dao.CustDao"%>
<%@page import="com.lec.dto.CustDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title> 
 
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br><br>
	<div class="section" style="margin : 0 auto;">
	<%
	int custno = Integer.parseInt(request.getParameter("custno")); 
	CustDao cDao = CustDao.getInstance();
	CustDto cust = cDao.getCus(custno);
%>
	<h2 align="center" style="margin : 0 auto;">회원번호 수정하기</h2>
	<form action="updatePro.jsp" method="post">
	<table style="margin : 0 auto;" >
				<tr align="center">
					<th><label for="custno">회원번호</label></th>
					<td>
						<input type="number" name="custno" id="custno" value="<%=cust.getCustno() %>" readonly="readonly">
					</td>
				</tr>
				<tr align="center">
					<th><label for="custname">회원성명</label></th>
					<td><input type="text" name="custname" id="custname" value="<%=cust.getCustname() %>" required="required"></td>
				</tr>
				<tr align="center">
					<th><label for="phone">회원전화</label></th>
					<td><input type="text" name="phone" id="phone" value="<%=cust.getPhone() %>" required="required"></td>
				</tr>
				<tr align="center">
					<th><label for="address">회원주소</label></th>
					<td><input type="text" name="address" id="address" value="<%=cust.getAddress() %>" required="required"></td>
				</tr>
				<tr align="center">
					<th><label for="joindate">가입일자</label></th>
					<td>
						<input type="tel" name="joindate" id="joindate" value="<%=cust.getJoindate() %>" required="required" value="010-">
					</td>
				</tr>
				<tr align="center">
					<th><label for="grade">고객등급<br>(A:VIP, B:일반, C:직원)</label></th>
					<td><input type="text" name="grade" id="grade" value="<%=cust.getGrade() %>"></td>
				</tr>
				<tr align="center">
					<th><label for="city">도시코드</label></th>
					<td><input type="text" name="city" id="city" value="<%=cust.getCity() %>"></td>
				</tr> 
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정" >
						<input type="button" value="조회"  
											onclick="location.href='../main/main.jsp'">
					</td>
				</tr>
			</table>
			</form> 
	</div>
	<br><br>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>