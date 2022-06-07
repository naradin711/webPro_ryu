<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입정보</title>
<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
<% 		request.setCharacterEncoding("utf-8");
		String id   = request.getParameter("id");
		String name = request.getParameter("name");
		String pw   = request.getParameter("pw");
		String birthTemp = request.getParameter("birth");
		Date birth  = Date.valueOf(request.getParameter("birth"));
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("pw", pw);
		session.setAttribute("birth", birthTemp);
		session.setAttribute("birth", birth);
		Date b = null;
		 if (!birthTemp.equals("")) {
			 b = Date.valueOf(request.getParameter("birth"));
		 }
		//String birth = request.getParameter("birth");
		//Date birth2 = null; Timestamp birth3=null;
		//if (birth!="") {
		//	 birth2 = Date.valueOf(request.getParameter("birth")); // birth의 스트링값을 Date형태로 바꿈 데이터베이스 저장용	 	
		//	 birth3 = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00");
		//}
		
		String[] hobby 	= request.getParameterValues("hobby"); //배열 || null 
		session.setAttribute("hobby", hobby);
		String gender 	= request.getParameter("gender");
		session.setAttribute("gender", gender);
		String email 	= request.getParameter("email");
		session.setAttribute("email", email);
		String[] mailSend = request.getParameterValues("mailSend"); // 배열
		session.setAttribute("mailSend", mailSend);
		String ip = request.getRemoteAddr(); //요청한 클라이언트의 ip주소
		Date date = new Date(System.currentTimeMillis());
		response.setContentType("text/html ; charset=utf-8");
		%>
		<script type="text/javascript">
		alert('회원가입이 완료되었습니다. 감사합니다.')  
		</script>
		<br>
		<br>
		<br>
		<br>
	<div id='joinForm_wrap'>
	<div id='join_title'> 회원가입정보 </div>
		<h2> name : <%=name %></h2>
		<h2> id : <%=id %></h2>
		<h2> pw : <% for (int i = 0; i<pw.length() ; i++) {
						out.println('*');
				} %></h2>
		<h2> birth : <%=birth %></h2>
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
	<br>
	<jsp:include page="footer.jsp"/> 
</body>
</html>