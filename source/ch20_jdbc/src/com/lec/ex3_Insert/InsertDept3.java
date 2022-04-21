package com.lec.ex3_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 부서번호를 입력받아 중복체크를 확인 후 입력진행하기
public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null;
		System.out.print("입력할 부서 번호는? ");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;	
		// String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+ dname +"', '"+loc+"')";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			while(true) {
			System.out.print("입력할 부서 번호는? ");
			deptno = sc.nextInt();
			rs   = stmt.executeQuery(selectSQL); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기 1번 쿼리
			rs.next();
			int cnt = rs.getInt("CNT");
			if(cnt!=0) {
				System.out.println("입력하신 부서 번호는 유효하지 않습니다.");	
				
			}		
				System.out.println("입력할 부서 이름은? ");
				String dname = sc.next();
				System.out.println("입력할 부서 위치는? ");
				String loc = sc.next();
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);	
				int result = stmt.executeUpdate(sql);
				System.out.println(result > 0 ? "입력 성공" : "입력 실패"); // 6. 원하는 로직 출력하기
			}			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. if() close();로 연결해제
			try {
				if(rs!=null)   rs  .close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		 
		}//try		
	}

}
