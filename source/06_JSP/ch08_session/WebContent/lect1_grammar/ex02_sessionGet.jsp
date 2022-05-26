<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>세션 속성 값 가져오기</title>
	<link href="<%=conPath %> " rel="stylesheet" type="text/css">
	
</head>
<body>
	<%// 특정 세션 속성값 가져오기
		String sessionName = (String)session.getAttribute("sessionName");
							// session.setAttribute("sessionName", "sessionValue");
		Integer myNum = (Integer)session.getAttribute("myNum");					
							// session.setAttribute("myNum", 123);
		out.println("sessionName : " + sessionName + "<br>" );
		out.println("myNum : " + myNum + "<br>" );	
		out.println("id : "+ session.getAttribute("id") + "<br>"); // 전 페이지에서 받아오지 않았기에 null 출력
	
	    // 모든 세션 속성 리스트 출력
	    out.println("<h4>모든 세션 속성을 list</h4>");
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while(sAttrNames.hasMoreElements()) {
			String sname = sAttrNames.nextElement();
			String svalue = session.getAttribute(sname).toString();// 세션 (속성값)
			out.println(sname + ": (세션이름) / " + svalue +" : (세션값) <br>");
			cnt++;
		}// while
		if (cnt==0){
			out.println("추가된 속성이 없습니다.");
		} ;	
		// 특정 세션 삭제하기 (로그아웃시 사용)
		 
		session.removeAttribute("myNum"); // myNum 속성 삭제
			
		out.println("<br><h4>마이넘 세션 속성을 삭제후 </h4>");
		sAttrNames = session.getAttributeNames();
		 cnt = 0;
		while(sAttrNames.hasMoreElements()) {
			String sname = sAttrNames.nextElement();
			String svalue = session.getAttribute(sname).toString();// 세션 (속성값)
			out.println(sname + ": (세션이름) / " + svalue +" : (세션값) <br>");
			cnt++;
		}// while
		if (cnt==0){
			out.println("추가된 속성이 없습니다.");
		} ;	
		out.println("<br><h4>모든 세션 속성을 삭제후 </h4>");	
		// 모든 세션 삭제하기 (로그아웃시 사용)
		session.invalidate(); // setAttribute한 모든 세선 속성값 다 삭제
		
		if(request.isRequestedSessionIdValid()){//유효한 세션 속성이 있는지 여부
			out.println("session vaild<br>");
		} else {
			out.println("session invaild<br>");
		}
		out.println("<h3>세션ID : "+ session.getId()+"</h3>");
		out.println("<h3>세션의 유효시간 : "+ session.getMaxInactiveInterval()+"</h3>");
	%>
	
	
</body>
</html>














