package com.lec.ex3_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		System.out.print("입력할 부서 번호는? ");
		int deptno = sc.nextInt();
		System.out.println("입력할 부서 이름은? ");
		String dname = sc.next();
		System.out.println("입력할 부서 위치는? ");
		String loc = sc.next();
		// String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+ dname +"', '"+loc+"')";
		String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			int result = stmt.executeUpdate(sql); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기 1번 쿼리	
			System.out.println(result > 0 ? "입력 성공" : "입력 실패"); // 6. 원하는 로직 출력하기 
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally { // 7. if() close();로 연결해제
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}//try
		
	}

}
