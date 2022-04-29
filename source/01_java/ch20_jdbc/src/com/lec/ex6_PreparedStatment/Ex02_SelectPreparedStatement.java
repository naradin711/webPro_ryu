package com.lec.ex6_PreparedStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex02_SelectPreparedStatement {
// 부서명을 입력받아 해당 부서의 사원의 사번, 이름, 직책, 급여를 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		Connection conn  = null; // DB 연결 객체 변수
		PreparedStatement  pstmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null; // SELECT문 결과 받는 객체 변수
		System.out.printf("검색하고자 하는 부서명을 입력하시오. : ");
		String dname = sc.next();
		String sql = " SELECT EMPNO, ENAME, JOB, SAL " + 
    		"    FROM EMP E, DEPT D " + 
    		"    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // sql 전송객체
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("사번, 이름, 직책, 급여");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					if(job.length()<7) {
						System.out.printf("%d\t %s\t %s\t\t %d\n", empno, ename, job, sal);
					}else {
						System.out.printf("%d\t %s\t %s\t %d\n", empno, ename, job, sal);
					}
				}while (rs.next());
			}else {
				System.out.println("유효한 부서명이 아닙니다.");
			}			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} 
		}
	}
}
