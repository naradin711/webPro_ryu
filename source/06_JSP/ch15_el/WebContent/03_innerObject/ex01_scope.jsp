<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Scope</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<form action="ex02_Scope.jsp">
		<p>이름  : <input type="text" name="name"></p>
		<p>ID  : <input type="text" name="id"></p>
		<p>비번  : <input type="password" name="pw"></p>
		<p><input type="submit" value="제출"></p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue");
		session.setAttribute("sessionName", "sessionValue");
		application.setAttribute("applicationName", "applicationValue");
		// java. forward할 객체(dispatcher)
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_Scope.jsp?name=hong&id=aaa&pw=111");
		dispatcher.forward(request, response); // 여기서 request변수 값을 다음 페이지로 전송
	%> 
	<h3>페이지 내  속성 변수값 : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request  속성 변수값 : <%=request.getAttribute("requestName") %></h3>
	<h3>session  속성 변수값 : <%=session.getAttribute("sessionName") %></h3>
	<h3>application  속성 변수값 : <%=application.getAttribute("applicationName") %></h3>
	<br>
	<hr>
	<br>
	<h3>페이지 내  속성 변수값 : ${pageScope.pageName }  </h3>
	<h3>request  속성 변수값 : ${requestScope.requestName }  </h3>
	<h3>session  속성 변수값 : ${sessionScope.sessionName } </h3>
	<h3>application  속성 변수값 : ${applicationScope.applicationName } </h3>
	<hr>
	<br>
	<h3>페이지 내  속성 변수값 : ${pageName }  </h3>
	<h3>request  속성 변수값 : ${requestName }  </h3>
	<h3>session  속성 변수값 : ${sessionName } </h3>
	<h3>application  속성 변수값 : ${applicationName } </h3>
</body>
</html>









