<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	<style type="text/css">
		#mainForm_wrap {
			width : 430px; margin : 0 auto; 
			text-align: center; font-size: 1.5em; font-weight: bold; 
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br><br><br>
	<div id="mainForm_wrap">
		<%
	boolean outOk = false; // 불린 변수
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for (Cookie c : cs){
			String cname = c.getName();
			String cvalue = c.getValue();
			if (cname.equals("id")){
				out.println("<h3>"+cname+" (쿠키이름) / "+ cvalue +" (쿠키값)</h3>");
				outOk = true;
			}//if
		}//for
	} 	
	if (!outOk){//if 
		out.println("<h3> 생성된 쿠키가 없습니다. <h3>");
	}
	%>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>