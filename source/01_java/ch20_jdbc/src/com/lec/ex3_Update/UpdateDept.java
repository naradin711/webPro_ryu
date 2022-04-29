package com.lec.ex3_Update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		Scanner sc = new Scanner (System.in);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			System.out.print("수정할 부서 번호를 입력해주세요. : ");
			int deptno = sc.nextInt();
			// 입력한 부서번호가 있는지 없는지 체크는 나중에
			System.out.print("수정할 부서명을 입력해주세요. : ");
			String dname = sc.next();
			System.out.print("수정할 부서 위치를 입력해주세요. : ");
			String loc = sc.next();
			String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %d", dname, loc, deptno);
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? "수정성공" : "해당 부서는 존재하지 않습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // 7. if() close();로 연결해제
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}//try
	}

}
