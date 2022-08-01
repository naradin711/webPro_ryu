<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.lec.dto.CustDto"%>
<%@page import="com.lec.dao.CustDao"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회 원 조 회</title>
<style type="text/css">
	.section table tr {
		text-align: center;
	}
	a { text-decoration: none; cursor: pointer; font-style: none;}
	.section table tr td a {
		text-decoration: none; cursor: pointer; font-style: none; color : black;
	}
</style> 
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br>
	<div class="section" style="margin : 0 auto;">
	<%
	CustDao cDao = CustDao.getInstance();
	ArrayList<CustDto> custs = cDao.listCust();
	%>
	<h1 align="center" >회원 목록 조회 수정</h1>
	<br><br>
	<table style="margin : 0 auto;">
		<tr> <th>회원번호</th> <th>회원성명</th><th>회원전화</th> <th>주소</th> <th>가입일</th><th>고객등급</th><th>도시코드</th> </tr>
		<%if(custs.size()==0){
			out.println("<tr><td colspan='5'>등록된 회원이 없습니다.</td></tr>");
		}else{
			for(CustDto cus : custs){
				out.println("<tr><td><a href='../cus/update.jsp?custno="+cus.getCustno()+"'>" +cus.getCustno()+ "</a></td><td>"+cus.getCustname()+"</td>");
				out.println("<td>"+cus.getPhone()+"</td><td>"+cus.getAddress()+"</td>");
				out.println("<td>"+ cus.getJoindate() +"</td><td>"+cus.getGrade()+"</td><td>"+cus.getCity()+"</td> </tr>");
			} 
		}
		
		%>
	</table>
	</div>
	<br>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>