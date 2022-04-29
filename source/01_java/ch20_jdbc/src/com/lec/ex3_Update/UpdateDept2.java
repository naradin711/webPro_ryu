package com.lec.ex3_Update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept2 {
// 수정하고자 하는 부서번호 입력 -> 존재하는 부서번호인지 체크 -> 부서명과 위치를 받아 수정
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null; // SELECT 전송 
		Scanner sc = new Scanner (System.in);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			System.out.print("수정할 부서 번호를 입력해주세요. : ");
			int deptno = sc.nextInt();
			// 입력한 해당 부서번호가 있는지 없는지 체크
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; //쿼리는 무조건 대문자로.
			//
			rs = stmt.executeQuery(selectSQL); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기 1번 쿼리
			if(rs.next()) {
				System.out.println("입력하신 번호의 부서의 정보는 아래와 같습니다.");
				System.out.println("부서번호\t 부서명\t 부서위치\t");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");	
				System.out.println(deptno + "\t" + dname + "\t" + loc);
				System.out.print("수정할 부서명을 입력해주세요. : ");
				dname = sc.next();
				System.out.print("수정할 부서 위치를 입력해주세요. : ");
				loc = sc.next();
				String sql = 
					String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %d", dname, loc, deptno);
				int result = stmt.executeUpdate(sql);
				if(result>0) {
				System.out.println("수정성공");
				}
			}else {
				System.out.println(deptno + "번 부서는 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // 7. if() close();로 연결해제
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
