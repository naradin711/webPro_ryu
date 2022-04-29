package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection          conn  = null; // DB 연결 객체 변수
		Statement           stmt  = null; // SQL 전송 객체 변수
		PreparedStatement  pstmt  = null;
		ResultSet             rs  = null; // SELECT문 결과 받는 객체 변수
		String dname = null;
		int fn; // 기능번호 (1 : 데이터입력 | 2: 직업별 조회 | 3:전체 조회| 0:종료)
		String sql1 = "SELECT  ROWNUM ||'등' , PNAME||'('||PNO||'번)' , JNAME, " + 
				"        KOR , ENG , MAT , KOR+ENG+MAT SUM " + 
				"    FROM  " + 
				"    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = ? " + 
				"     ORDER BY KOR+ENG+MAT DESC)";
		String sql2 = " SELECT  ROWNUM ||'등'  , PNAME||'('||PNO||'번)' , JNAME, " + 
				"        KOR , ENG  , MAT , KOR+ENG+MAT " + 
				"    FROM " + 
				"    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO " + 
				"     ORDER BY KOR+ENG+MAT DESC) " ;
		Scanner sc = new Scanner (System.in);	
		System.out.print("1 : 데이터입력 | 2:직업별 조회 | 3:전체 조회 | 0:종료\t");
		fn = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1); // sql 전송객체
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
