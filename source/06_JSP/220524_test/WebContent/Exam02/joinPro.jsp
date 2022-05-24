<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입정보</title>
<link href="../css/join.css" rel="stylesheet">
</head>
<body>

<% 		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		Date birth2 = null; Timestamp birth3=null;
		if (birth!="") {
			 birth2 = Date.valueOf(request.getParameter("birth")); // birth의 스트링값을 Date형태로 바꿈 데이터베이스 저장용	 	
			 birth3 = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00");
		}
		
		String[] hobby = request.getParameterValues("hobby"); //배열 || null 
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend"); // 배열
		String ip = request.getRemoteAddr(); //요청한 클라이언트의 ip주소
		Date date = new Date(System.currentTimeMillis());
		response.setContentType("text/html ; charset=utf-8");
		%>
<div id='joinForm_wrap'>
<div id='join_title'> 회원가입정보 </div>
<h2> name : <%=name %></h2>
<h2> id : <%=id %></h2>
<h2> pw : <% for (int i = 0; i<pw.length() ; i++) {
						out.println('*');
				} %></h2>
<h2> birth : <%=birth %></h2>
<h2> birth2 : <%=birth3 %></h2>
<h2> gender : <%=gender %></h2>	
<h2> hobby : <%if (hobby!=null) {
					for (int i = 0; i<hobby.length ; i++) {
							if(i == hobby.length-1) {
								out.println(hobby[i] );
							}else {
								out.println(hobby[i]+',');
							}//if	
						}//for
				} %></h2>
<h2> email : <%=email %></h2>	
<h2> mailSend :<%= Arrays.toString(mailSend) %></h2>	
<h2> 가입일 : <%=date %></h2>	
<h2> 가입 IP : <%=ip %></h2>				
</div>		
<%@ include file="footer.jsp" %>
</body>
</html>