package com.lec.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDao {
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 		
		return conn;
	}
	
	// 1.  전체 리스트 SELECT * FROM EMP ORDER BY EMPNO;
	ArrayList<EmpDto> listEmp(){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT * FROM EMP ORDER BY EMPNO";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno 		= rs.getInt("empno");
				String ename 	= rs.getString("ename");
				String job 		= rs.getString("job");
				int mgr 		= rs.getInt("mgr");
				Date hiredate 	= rs.getDate("hiredate");
				int sal 		= rs.getInt("sal");
				int comm 		= rs.getInt("comm");
				int deptno 		= rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return emps;
	}
	
	
	// 2.  검색한 결과
	ArrayList<EmpDto> searchEmp(String ename, String job){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER( ? )||'%' AND JOB LIKE '%'||UPPER( ? )||'%' ORDER BY EMPNO";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, job);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno 		= rs.getInt("empno");
				ename 			= rs.getString("ename");
				job 			= rs.getString("job");
				int mgr 		= rs.getInt("mgr");
				Date hiredate 	= rs.getDate("hiredate");
				int sal 		= rs.getInt("sal");
				int comm 		= rs.getInt("comm");
				int deptno 		= rs.getInt("deptno");
				emps.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return emps;
	}
	
	
}









































