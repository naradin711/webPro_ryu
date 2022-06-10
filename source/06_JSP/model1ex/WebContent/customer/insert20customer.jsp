<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%  
	CustomerDao cDao = CustomerDao.getInstance();
	CustomerDto newCustomer = new CustomerDto();
	
	for (int i=0; i<30 ; i++) {
		newCustomer.setCid("aa"+i);
		newCustomer.setCpw("111");
		if(i%2==0){
			newCustomer.setCname("홍길동");
			newCustomer.setCgender("m");
		} else {
			newCustomer.setCname("홍길순");
			newCustomer.setCgender("f");
		}
		if(i<10){
			newCustomer.setCtel("010-1234-123"+i);	
		} else {
			newCustomer.setCtel("010-1234-12"+i);
		}
		newCustomer.setCemail("hong"+i+"@hong.com");
		newCustomer.setCbirth(Date.valueOf("1995-12-12"));
		
		int result = cDao.insertCustomer(newCustomer);
		out.println(result==CustomerDao.SUCCESS? i+"번째 성공" : "실패");
		out.println("<br>");
		
		
	}
	
%>
</body>
</html>