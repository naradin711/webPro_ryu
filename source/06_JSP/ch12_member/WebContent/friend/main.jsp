<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.lec.member.FriendDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.member.FriendDAOConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>친 구 찾 기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	<script>
		function search() { // function search
			var name = frm.name.value;   // var 변수 네임 폼에서 값 받기
			var phone = frm.phone.value; // var 변수 phone 폼에서 값 받기
			
			location = "main.jsp?name="+name+"&phone="+phone; // location 현재주소 ? 이름=+이름+ &번호= 번호
		}
	</script>
</head>
<body>
<%
String name = request.getParameter("name");
String phone = request.getParameter("phone");
%>
	<form action="friendPro.jsp" method="post" name="frm" id="frm">
	<b> 친구 이름 <input type="text" name="name" value="<%=name!=null? name : ""%>"> <!-- 친구 이름 입력값 null 일때 ""-->
	        전화 <input type="text" name="phone" value="<%=phone!=null? phone : ""%>"> <!-- 전화번호 입력값 null 일때 ""-->
		<input type="button" onclick="search()" value="검색"/> <!-- 검색 버튼은 온클릭에 자체 자바 스크립트 펑션으로 -->
		<input type="submit" value="추가"/> <!-- 추가 버튼은 서브밋 -->
	</b>
	<table>
	<caption>이곳에 DB에 입력된 친구들 리스트</caption>
	<tr>
		<th>순번</th><th>이름</th><th>전화</th>
	</tr>
	<%
		
	    FriendDAOConn fDao = new FriendDAOConn();
	    ArrayList<FriendDTO> dtos1 = fDao.search(name, phone);
	    ArrayList<FriendDTO> dtos2 = fDao.getList();
	    if(!dtos1.isEmpty()){
	    	for(FriendDTO dto1 : dtos1) {
	    		out.println("<tr><td>"+dto1.getNum()+"</td><td>"+dto1.getName()+"</td><td>"+dto1.getPhone()+"</td></tr>");
	    	}
	    }else {
	    	for(FriendDTO d2 : dtos2){
	    		out.println("<tr><td>"+d2.getNum()+"</td><td>"+d2.getName()+"</td><td>"+d2.getPhone()+"</td></tr>");	    		
	    	}
	    }
	    
	%>
	</table>
		
	</form>
</body>
</html>