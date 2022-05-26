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
	<%
	boolean outOk = false; // 불린 변수
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for (Cookie c : cs){
			String cname = c.getName();
			String cvalue = c.getValue();
			if (cname.equals("id")){
				out.println("<h2>"+cname+" (쿠키이름) / "+ cvalue +" (쿠키값)</h2>");
				outOk = true;
			}//if
		}//for
	}  
		
	if (!outOk){//if 
		out.println("<h3> 생성된 쿠키가 없습니다. <h3>");
	}
	%>
	<button onclick = "history.back()">뒤로 가기</button>
	<button onclick = "location.href='welcome.jsp'">welcome!</button>
</body>
</html>