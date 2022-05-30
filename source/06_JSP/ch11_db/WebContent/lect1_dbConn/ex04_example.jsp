<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사원 이름 검색하기</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	String n1 = request.getParameter("search");
	String driver	= "oracle.jdbc.driver.OracleDriver";
	String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs	= null;
	String sql		= "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER( ? )||'%'";
%>
	<form action="">
		이 름
		<input type="text" name="search" size = "100">
		<input type="submit" value="이름 검색" size= "100">
<%if (n1!=null) {%>		
		<table>
			<%
		try {
			Class.forName(driver);
			conn  = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n1);
			rs	  = pstmt.executeQuery();
			
			out.println("<tr> <th>사번</th> <th>이름</th> <th>직책</th> <th>상사사번</th> <th>입사일</th> <th>급여</th> <th>상여</th> <th>부서번호</th> </tr>");
			if (rs.next()) {
				do{
					int empno			= rs.getInt("empno");
					String ename		= rs.getString("ename");
					String job			= rs.getString("job");
					int mgr				= rs.getInt("mgr");
					Timestamp hiredate 	= rs.getTimestamp("hiredate");
					int sal				= rs.getInt("sal");
					int comm			= rs.getInt("comm");
					int deptno			= rs.getInt("deptno");
					out.println("<tr> <td>"+empno+"</td> <td>"+ename+"</td> <td>"+job+"</td> <td>"+mgr+"</td> <td>"+hiredate+"</td> <td>"+sal+"</td> <td>"+comm+"</td> <td>"+deptno+"</td></tr>");
				}while (rs.next());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());	
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e){
				System.out.println(e.getMessage());	
			}	
		}
		%>
		</table>
<%} %>		
	</form>
</body>
</html>