<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>선언부_표현식</title>
</head>
<body>
<%
	int j =0;// 초기화
	i++; j++;
	strBuf.append("<span>☆</span>");
	out.println("strBuf = " + strBuf +"<br>");
	out.println("sum(5,2) = "+ sum(5,2)+"<br>");

%>

전역변수 i = <%=i %><br> 
지역변수 j = <%=j %><br>
strBuf = <%=strBuf %>


<%! // 선언문은 위치가 어디있던지 제일 먼저 실행됨
	int i; //초기화 0을 넣지 않아도 자동적으로 초기화 됨. 전역변수는 계속 누적됨
	StringBuffer strBuf = new StringBuffer("Good ");
	public int sum (int a, int b) {
		return a + b;
	}
%>
</body>
</html>