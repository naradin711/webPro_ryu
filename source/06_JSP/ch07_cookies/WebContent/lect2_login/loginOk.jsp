<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 정보 입력</title>
	<link href="<%=conPath %>/css/style1.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<%!String id, pw; %>
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		if (id==null || pw==null|| !pw.equals("111")||!id.equals("aaa")){
			
			%> <script>
			alert("올바른 아이디와 비밀번호를 입력하세요.");
			location.href="login.html";
			</script> <% 
			
			
		} else {
			// 로그인 처리
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(-1); // 유효시간은 로그아웃 할 때 까지.
			response.addCookie(cookie);
			Cookie cookie2 = new Cookie("name", "홍길동"); // DB에서 가져온 이름을 쿠키값으로
			cookie2.setMaxAge(-1); // 유효시간은 로그아웃 할 때 까지.
			response.addCookie(cookie2);
			response.sendRedirect("welcome.jsp");
		}
	%>
</body>
</html>

















