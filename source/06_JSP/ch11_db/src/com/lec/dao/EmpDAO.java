package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lec.dto.EmpDTO;

public class EmpDAO { //싱글톤  DAO
	private String driver	= "oracle.jdbc.driver.OracleDriver";
	private String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
	private static EmpDAO instance; // 자기가 자기의 클래스의 객체를 참조하는 변수 = 초기값 설정
	public static EmpDAO getInstance() {
		if(instance==null) {
			instance = new EmpDAO();
		}
		return instance; // instance가 존재할 시 계속 같은 클래스 반복
	}
	private EmpDAO () {
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// searchName을 매개변수로 받아서 EmpDTO를 return
	
	public ArrayList<EmpDTO> selectSearchName (String searchName) {
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		// 2단계~7단계
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER( ? )||'%'";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();
			while(rs.next()) { // dto에서 매개값 받기
//				EmpDTO emp = new EmpDTO();
//				emp.setEmpno	(rs.getInt("empno"));
//				emp.setEname	(rs.getString("ename"));
//				emp.setJob		(rs.getString("job"));
//				emp.setMgr		(rs.getInt("mgr"));
//				emp.setHiredate	(rs.getDate("hiredate"));
//				emp.setSal		(rs.getInt("sal"));
//				emp.setComm		(rs.getInt("comm"));
//				emp.setDeptno	(rs.getInt("deptno"));
//				dtos.add(emp);
				int empno		= rs.getInt("empno");
				String ename  	= rs.getString("ename");
				String job		= rs.getString("job");
				int mgr     	= rs.getInt("mgr");
				Date hiredate	= rs.getDate("hiredate");
				int sal 		= rs.getInt("sal");
				int comm		= rs.getInt("comm");
				int deptno		= rs.getInt("deptno"); 
				dtos.add(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
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
		
		return dtos;
	}
	
	// deptno를 매개변수로 받아서 EmpDTO를 return
	public ArrayList<EmpDTO> selectDeptno (int deptno) {
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		// 2단계~7단계
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String sql = "SELECT * FROM EMP WHERE DEPTNO = ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while(rs.next()) { // dto에서 매개값 받기
//				EmpDTO emp = new EmpDTO();
//				emp.setEmpno	(rs.getInt("empno"));
//				emp.setEname	(rs.getString("ename"));
//				emp.setJob		(rs.getString("job"));
//				emp.setMgr		(rs.getInt("mgr"));
//				emp.setHiredate	(rs.getDate("hiredate"));
//				emp.setSal		(rs.getInt("sal"));
//				emp.setComm		(rs.getInt("comm"));
//				emp.setDeptno	(rs.getInt("deptno"));
//				dtos.add(emp);
				int empno		= rs.getInt("empno");
				String ename  	= rs.getString("ename");
				String job		= rs.getString("job");
				int mgr     	= rs.getInt("mgr");
				Date hiredate	= rs.getDate("hiredate");
				int sal 		= rs.getInt("sal");
				int comm		= rs.getInt("comm");
				 
				dtos.add(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
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
		
		return dtos;
	}
	
	
	
	
}














