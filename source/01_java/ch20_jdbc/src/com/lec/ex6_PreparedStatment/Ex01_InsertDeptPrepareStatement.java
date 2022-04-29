package com.lec.ex6_PreparedStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01_InsertDeptPrepareStatement {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		Connection conn  = null; // DB 연결 객체 변수
		PreparedStatement  pstmt  = null; // SQL 전송 객체 변수
		String sql = String.format("INSERT INTO DEPT VALUES (?, ?, ?)");
		//추가할 데이터 받기
		System.out.print("추가할 부서 번호는? ");
		int deptno = sc.nextInt();
		System.out.print("추가할 부서 이름은? ");
		String dname = sc.next();
		System.out.print("추가할 부서 위치는? ");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // sql 전송객체
			pstmt.setInt(1, deptno); // sql의 첫번째 물음표에 int 값으로 deptno를 세팅
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? deptno+"번 입력 성공" : "입력 실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}finally{
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
	}

 }

}