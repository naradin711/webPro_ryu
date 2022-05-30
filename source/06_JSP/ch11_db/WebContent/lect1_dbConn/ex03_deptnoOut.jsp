<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<style>p{text-align: center;}</style>
</head>
<body>
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid    = "scott";
	String upw    = "tiger";
	Connection        conn  = null;
	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
	String sql = "SELECT * FROM EMP WHERE DEPTNO=?";
	String deptnoStr = request.getParameter("deptno");
	if(deptnoStr==null)
		deptnoStr = "0";
	int deptno = Integer.parseInt(deptnoStr);
	
	try{
		Class.forName(driver); // 1단계
		conn = DriverManager.getConnection(url, uid, upw); // 2단계
		pstmt = conn.prepareStatement(sql); // 3단계
		pstmt.setInt(1, deptno);
		rs = pstmt.executeQuery(); // 4단계 + 5단계
		out.println("<table>");
		if(rs.next()){
			out.println("<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th></tr>");
			do{
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date   hiredate = rs.getDate("hiredate");
				out.println("<tr><td>"+empno + "</td><td>" + ename + "</td><td>" + 
																hiredate  + "</td><td>" + deptno +"</td></tr>");
			}while(rs.next());
		}else{
			out.println("<tr><td>사원이 없습니다</td></tr>");
		}
		out.println("</table>");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>
	<p><button onclick="location.href='ex3_deptnoIn.html'">다시 검색</button></p>
</body>
</html>
















