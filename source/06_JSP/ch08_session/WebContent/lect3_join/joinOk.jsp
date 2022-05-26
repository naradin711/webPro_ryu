<%@page import="java.io.PrintWriter"%>
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
	String agree = request.getParameter("agree"); // y or n
	if(agree.equals("y")){ 	// 약관 동의한 경우 (세션 속성값 받아서 파일에 저장, 일부 세션 날림)
		String id = (String)session.getAttribute("id");	
		String pw = (String)session.getAttribute("pw");	
		String name = (String)session.getAttribute("name");	
		// 파일 저장 경로 (WebContent/WEB-INF/id.txt)
		String filePath = "D:\\webPro_ryu\\source\\06_JSP\\ch08_session\\WebContent\\WEB-INF\\"+id+".txt";
		PrintWriter writer = new PrintWriter(filePath);
		writer.println("오늘은 DB에 insert 대신 파일 출력");
		writer.println("아이디 : " + id);
		writer.println("비밀번호 : " + pw);
		writer.println("이름 : " + name);
		writer.close();
		session.removeAttribute("pw"); 		// pw값 날림
		session.removeAttribute("name");	// name 값 날림
		response.sendRedirect("result.jsp?msg=success");
	}else { 				// 약관에 동의하지 않는 경우 (모든 세션 날림 --> 다음페이지로)
		session.invalidate(); 				// 모든 세션 속성 삭제
		response.sendRedirect("result.jsp?msg=fail");
	}
%>	

</body>
</html>












