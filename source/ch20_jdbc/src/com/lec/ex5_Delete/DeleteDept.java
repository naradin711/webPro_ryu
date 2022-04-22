package com.lec.ex5_Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 삭제하고자 하는 부서번호를 입력받아서 삭제하기
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		Scanner sc = new Scanner (System.in);
		System.out.printf("삭제하고자 하는 부서의 번호를 입력하시오. :");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO = "+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); //
			int result = stmt.executeUpdate(sql); // 4. 5.
			System.out.println(result>0 ? deptno+"번 부서 삭제 성공" : deptno+"번 부서는 존재하지 않습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println("SQL 오류" + e.getMessage());
			}	
		}// try
	}//main
}//class
