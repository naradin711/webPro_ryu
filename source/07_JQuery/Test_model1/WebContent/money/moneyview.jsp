<%@page import="com.lec.dto.MoneyDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.MoneyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매 출 조 회</title> 
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<br>
	<br>
	<div class="section" style="margin : 0 auto;">
		<div>
			<h2 align="center" style="margin : 0 auto;">회원매출조회</h2>
			<br><br>
			<table>
			</table>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div>
		<%
			MoneyDao mDao = MoneyDao.getInstance();
			ArrayList<MoneyDto> moneys = mDao.listMoney();
		%>
			<h2 align="center" style="margin : 0 auto;">제품 매출 조회</h2>
			<br><br>
			<table align="center" >
			<tr> <th>제품코드</th> <th>매출</th></tr>
		<%if(moneys.size()==0){
			out.println("<tr><td colspan='2'>등록된 회원이 없습니다.</td></tr>");
		}else{
			for(MoneyDto money : moneys){
				out.println("<tr><td>"+ money.getPcode() +"</td><td>"+money.getSp()+"</td></tr>");
			} 
		}
		
		%>
			</table>
		</div>
	</div>
	<br>
	<br>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>