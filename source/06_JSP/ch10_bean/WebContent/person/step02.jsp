<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style1.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<jsp:useBean class="com.lec.ex.Person" id="p" scope="page"></jsp:useBean>
	<jsp:setProperty property="name" name="p" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty property="age" name="p" value='<%=Integer.parseInt(request.getParameter("age"))  %>'/>
	<jsp:setProperty property="gender" name="p" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="p" value='<%=request.getParameter("address") %>'/>

</body>
	<h2>입력받은 정보</h2>
	<p>이름 : <%=p.getName() %></p>
	<p>나이 : <%=p.getAge() %></p>
	<p>성별 : <%=p.getGender() %></p>
	<p>주소 : <%=p.getAddress() %></p>
	
</html>
















