<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String conPath = request.getContextPath();
String appPath = application.getContextPath(); // ch05_jsp
String abPath = application.getRealPath("."); // 현재 프로젝트의 절대 경로
%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=abPath %></h2>
	
<%
	String filePath = application.getRealPath("WEB-INF/input.txt");
	out.println(filePath + "의 내용입니다.<br><br>");
	 
	BufferedReader br = new BufferedReader(new FileReader(filePath)); // 스트링 객체 생성 & 파일을 연다.
	while(true){
		String line = br.readLine(); // 파일 읽기 (한줄 씩) 파일의 끝이면 null을 리턴
		if (line==null) break;
		out.println(line+"<br>");
	}
	// 스트링 객체 생성 (파일을 연다. 스트링 객체를 생성한다.) - 읽는다 - 스트링객체를 해제한다.
	/* BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(filePath)); // 스트링 객체 생성 & 파일을 연다.
		while(true){
			String line = br.readLine(); // 파일 읽기 (한줄 씩) 파일의 끝이면 null을 리턴
			if (line==null) break;
			out.println(line+"<br>");
		}
	}catch (Exception e){
		out.println("존재하지 않는 파일이거나 읽을 수 없는 파일입니다."); // 예외 발생
	}finally {
		 try {
			 if(br!=null) br.close();
		 }catch (Exception e) {
			 
		 }
	}
	*/
%>	
</body>
</html>