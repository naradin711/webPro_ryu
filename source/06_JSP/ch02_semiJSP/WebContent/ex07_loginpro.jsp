<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결과 출력</title>
	
</head>
<body>
	<%! String name1, id1, pw1 ; %>
	<%
	//post방식으로 들어와서 파라미터 전송시 깨질 수 있기에 해당 문자열을 UTF-8로 인코딩해준다.
	request.setCharacterEncoding("utf-8"); 
	name1 = request.getParameter("name");
	 id1 = request.getParameter("id");
	 pw1 = request.getParameter("pw");
	%>
	
	<p>
	아이디는 <%=id1 %> 이고 <br>
	패스워드는 <%=pw1 %> 입니다. <br>
	<%=name1 %>님 반갑습니다.
	</p>
</body>
</html>