package com.lec.ex1_SelectAll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
public class SelectAllOracle {
	public static void main(String[] args) {
		// 1. 드라이브 생성
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// 2. 연결 변수 생성
		Connection conn  = null; // DB 연결 객체 변수
		// 3.  Statement 생성
		Statement  stmt  = null; // SQL 전송 객체 변수
		// 4. SQL문 전송 
		ResultSet  rs    = null; // SELECT문 결과 받는 객체 변수
		String query = "SELECT * FROM EMP";
		
		try {
			Class.forName(driver); // 1. Driver 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(query); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기
			// 6. 결과를 받아 원하는 로직을 수행한다!
			System.out.println("사번\t이름\t직책\t\t상사번호\t입사일\t\t급여\t상여\t부서번호"); // 필드 프린트하기
			while (rs.next()){ // 필드값 넣기
				//int empno = rs.getInt("empno");    // 숫자 가져오기
				String empno  = rs.getString("empno"); // 글자, 문자열 가져오기
				String ename  = rs.getString("ename");
				String job    = rs.getString("job");
				int    mgr    = rs.getInt("mgr");
				// Date hiredate = rs.getDate("hiredate");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int    sal    = rs.getInt("sal");
				int    comm   = rs.getInt("comm");
				int    deptno = rs.getInt("deptno");
				if(job.length()<7) {
					System.out.printf("%s\t %s\t %s\t\t %d\t %TF\t %d\t %d\t %d\n",
					           empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}else {
					System.out.printf("%s\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
					           empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}
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
	}//main
}//class
