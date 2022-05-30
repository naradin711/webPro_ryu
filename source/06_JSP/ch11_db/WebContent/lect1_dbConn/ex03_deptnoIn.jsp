<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서번호 입력</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<form action="ex03_deptnoOut.jsp">
		부서번호  <select name="deptno">
				<option value="0"> </option>
				<%
					Connection conn = null;
					Statement stmt  = null;
					ResultSet rs	= null;
					String driver 	= "oracle.jdbc.driver.OracleDriver";
					String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
					String uid 		= "scott";
					String upw 		= "tiger";
					String sql 		= "SELECT * FROM DEPT";
					try {
						Class.forName(driver); // 1단계
						conn 	= DriverManager.getConnection(url, uid, upw); // 2단계
						stmt	= conn.createStatement();
						rs		= stmt.executeQuery(sql);
						while(rs.next()){
							int deptno = rs.getInt("deptno");
							String dname = rs.getString("dname");
							out.println("<option value='"+deptno+"'>"+deptno+" - "+dname+"</option>");
						}					
					}catch (Exception e) {
						out.println(e.getMessage());
					}finally {
						try {
							if(rs!=null) rs.close();
							if(stmt!=null) stmt.close();
							if(conn!=null) conn.close();
						}catch (Exception e) {
							out.println(e.getMessage());
						}
						
					}
				%> 
		</select>
		<input type="submit" value="검색" size="70">
	</form>
</body>
</html>



















