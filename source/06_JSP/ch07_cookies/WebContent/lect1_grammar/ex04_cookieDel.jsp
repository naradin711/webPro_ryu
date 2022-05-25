<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키 삭제 및 로그 아웃</title>
	<link href="<%=conPath %> " rel="style" type="text/css">
	
</head>
<body>
	<h1>특정 쿠키(쿠키이름이 cookieName) 삭제</h1>
	<%
	Cookie[] cookies = request.getCookies(); // 쿠키 이름을 받는 쿠키의 행렬 쿠키즈  생성
	if (cookies!=null) {
		for (Cookie c : cookies){
			String name = c.getName();
			if (name.equals("cookieName")){
				// 쿠키 삭제 : 유효 기간이 0초 짜리 같은 이름의 쿠키를 만들어서 덮어 씌움
				Cookie cookie = new Cookie("cookieName","cookieValue");  
				cookie.setMaxAge(0); 		//0초 유효한 쿠키  
				response.addCookie(cookie); //response에 탑재 = 0초 유효하니 해당 쿠키 즉시 삭제
				out.println("<h3>쿠키 삭제 성공</h3>");
				break; // for문 중지
			}//if
		}//for
		 
	} //if
	%>
	
	
	<br>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a> <br>
	<a href="ex02_cookieList.jsp">쿠키들(쿠키이름 쿠키값) 리스트 확인</a> <br>
	<a href="ex03_ThatCookie.jsp">특정 쿠키(쿠키이름 cookieName) 찾기</a> <br>
	<a href="ex04_cookieDel.jsp">특정 쿠키 삭제</a> <!-- 로그아웃 활동 -->
</body>
</html>














































