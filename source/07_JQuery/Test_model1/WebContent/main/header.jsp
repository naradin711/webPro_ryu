<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
<style type="text/css">
a {text-decoration: none; font-weight: bold;}
li { list-style: none;}
.header {
 		margin: 0 auto;
		width : 90%;
		height : 150px;
		line-height : 150px;
		text-align : center;
		background-color: blue;
		color: white;
		font-size: 2.0em;
}

.nav {
  width: 90%; 
  margin: 0 auto;
  background-color: #33FFFF;
}
.nav ul{
	overflow: hidden;
	width:500px;
	margin: 0 auto;
}
.nav ul li {
	margin: 5px;
	float:left;
	padding:5px;
	line-height: 25px;
}
.nav a {
	height:1.1em;
	color: black;
	font-size:1.1em; 
}
	
</style>	
</head>
<body>
	<header> 
		<div class="header" onclick="location.href='../main/main.jsp'"> 
			애플리케이션 배포
		</div>
		<div class="nav"> 
			<!-- 로그인 전 메뉴 우측부터 고객 센터 회원가입 로그인 -->
			<ul>
				<li><a href="../cus/join.jsp">회원등록</a></li>
				<li><a href="../cus/view.jsp">회원조회/수정</a></li>
				<li><a href="../money/moneyview.jsp">매출조회(회원/제품)</a></li>
				<li><a href="../main/main.jsp">홈으로</a></li>
			</ul> 
		</div>
	</header>
</body>
</html>









