package com.lec.ex2_SelectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 입력받아 부서 정보 출력하기.
public class Ex01_SelectDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null; // SELECT문 결과 받는 객체 변수
		Scanner sc = new Scanner (System.in);
		System.out.print("찾기 원하는 부서번호를 입력하세요. : ");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO= "+deptno;
		try {
			Class.forName(driver); // 1. driver 설정
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(sql); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기
		if(rs.next()) { // 해당부서가 있음
			System.out.println(deptno+"번 부서 정보는 다음과 같습니다."); 
			System.out.println("부서이름 : "+rs.getString("dname"));
			System.out.println("부서위치 : "+rs.getString("loc")); //6. 해당 로직 실행 및 결과값 출력
		}else { // 해당부서가 없음
			System.out.println("DEPTNO DATA IS MISSING");
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
