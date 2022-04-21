package com.lec.ex3_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 부서번호를 입력받아 중복체크를 확인 후 입력진행하기
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in); // 스캐너
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null; // select 전송 객체 변수
		System.out.print("입력할 부서 번호는? "); // 입력할 부서번호
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; // 입력한 숫자번호의 모든 필드값을 가져옴	
		// String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+ dname +"', '"+loc+"')";

		try {
			Class.forName(driver); //1.driver 설정
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(selectSQL); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기 1번 쿼리
			if(!rs.next()) { // 입력한 rs가 존재하지 않으면 중복된 번호가 아니므로 if !를 사용하여 중복이 아님을 설명하라
				System.out.println("입력하신 부서 번호를 사용하실 수 있습니다."); // 입력가능하다고 설명
				System.out.println("입력할 부서 이름은? ");                // 부서이름
				String dname = sc.next();
				sc.nextLine();                                        // 중복방지 넥스트라인
				System.out.println("입력할 부서 위치는? ");                // 부서 위치
				String loc = sc.next();
				//string format을 이용하여 원하고자 하는 값을 출력
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc); 
				int result = stmt.executeUpdate(sql); // 결과값을 스테이트먼트에서 가져옴
				System.out.println(result > 0 ? "입력 성공" : "입력 실패"); // 6. 원하는 로직 출력하기
			}else {
				System.out.println("입력하신 부서 번호는 유효하지 않습니다.");	
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
