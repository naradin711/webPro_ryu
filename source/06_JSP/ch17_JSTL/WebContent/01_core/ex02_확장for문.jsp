<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>확장for문</title>
	
</head>
<body>
  <% 
	String[] names={"홍길동", "고길동", "신길동", "구길동", "동길동"}; 
%>
	<!--for (String name : names){
		out.println("<p>"+name+"</p>");
	}
	for (int i=0; i<names.length ; i++){
		out.println("<p>"+i+"번째 이름: "+names[i]+"</p>");
	} -->
	<c:set var="names" value="<%=names %>"/> <!-- 변수 선언-->
	<c:forEach var="name" items="${names }">
		<h3>${name }</h3>
	</c:forEach>
	<c:set var="idx" value="0"/>
	<c:forEach var="name" items="${names }">
		<h3>${idx }번째 이름은 ${name }</h3>
		<c:set var="idx" value="${idx+1 }"></c:set>
	</c:forEach>
 	<h3>최종 idx값은 ${idx }</h3>
</body>
</html>

















