<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	String msg = "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if (id!=null && id.equals("aaa")){ 		// 유효한 id를 입력한 경우
		 
		if (pw!=null && pw.equals("111")){ 	// 유효한 pw를 입력한 경우
		    // 로그인 처리 = 세션 속성 (id, name) 추가한 후 welcome.jsp로 가기
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			response.sendRedirect("welcome.jsp");
		}else{ 								// 유효하지 않은 pw를 입력한 경우
			msg = URLEncoder.encode("pw를 체크하시오", "utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
		
	}else{ 						   			// 유효하지 않은 id를 입력한 경우
		msg = URLEncoder.encode("id를 체크하시오", "utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	}
	
%>
</body>
</html>