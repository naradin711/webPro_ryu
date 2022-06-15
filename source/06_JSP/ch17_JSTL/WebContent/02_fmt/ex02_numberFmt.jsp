<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>NumberFmt</title>
	<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="num" value="1234567.8"/>
		<p>num : ${num }</p>
		<p>세자리마다 , : <fmt:formatNumber value="${num }" groupingUsed="true"/></p>
		<p>세자리마다 , : <fmt:formatNumber value="${num }" pattern="#,###.#"/></p>
		<p>
			소수점 2자리까지 표현 (소수점이 한자리 이하인 경우 0이 붙는다) : 
			<fmt:formatNumber value="${num }" pattern="#,###.00"/>
		</p>
		<p>
			소수점 2자리까지 표현 (소수점이 한자리 이하인 경우 자리수만큼 출력한다) : 
			<fmt:formatNumber value="${num }" pattern="#,###.##"/>
		</p>
		<p>
			소수점 2자리까지 표현 (소수점이 두자리 이상인 경우 반올림) : 
			<fmt:formatNumber value="${num }" pattern="#,###.##"/>
		</p>	
	
</body>
</html>

















