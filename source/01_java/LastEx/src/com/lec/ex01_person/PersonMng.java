package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1. 입력 2. 직업별조회 3. 전체출력  그외.종료
public class PersonMng {
   public static void main(String[] args) {
	 String driver = "oracle.jdbc.driver.OracleDriver";
	 String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	 Connection          conn  = null; // DB 연결 객체 변수
	 Statement           stmt  = null; // SQL 전송 객체 변수 3번
	 PreparedStatement  pstmt  = null; // 1번이랑 2번
	 ResultSet             rs  = null; // SELECT문 결과 받는 객체 변수 2번 3번 출력을 위해 필요
	 Scanner sc = new Scanner (System.in);
	 String fn, sql;
	 try {
		Class.forName(driver); // 1. 드라이버 로드.
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}// (1) 드라이버 로드
	 do {
		 System.out.print("1. 입력 2. || 직업별조회 || 3. 전체출력 || 그외 : 종료  ");
		 fn = sc.next();
		 switch(fn) {
		 case "1" : // 이름, 직업명, 국, 영, 수 점수 입력 받아
			 //2단계~7단계
			 sql = "INSERT INTO PERSON VALUES " + 
			 		"   (PERSON_SEQ.NEXTVAL, ? , (SELECT JNO  FROM JOB WHERE JNAME = ?) , ?, ?, ?)";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // sql 전송객체
				System.out.print("입력할 이름은? ");
				pstmt.setString(1, sc.next()); 
				System.out.print("입력할 직업명은? ");
				pstmt.setString(2, sc.next());
				System.out.print("국어 점수는? ");
				pstmt.setInt(3, sc.nextInt());
				System.out.print("영어 점수는? ");
				pstmt.setInt(4, sc.nextInt());
				System.out.print("수학 점수는? ");
				pstmt.setInt(5, sc.nextInt());
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "입력성공" : "입력실패");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(pstmt!=null) pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} 
			}			
			 break;
		 case "2" :
			 sql = "SELECT  ROWNUM, PNAME , JNAME , " + 
			 		"        KOR , ENG , MAT , KOR+ENG+MAT " + 
			 		"    FROM (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = ?" + 
			 		"     ORDER BY KOR+ENG+MAT DESC)";
			 
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // sql 전송객체
				System.out.print("찾고자하는 직업명은? ");
				pstmt.setString(1, sc.next());
				rs = pstmt.executeQuery(); // 4. + 5.
				if (rs.next()) {
					do {
						int rank = rs.getInt("ROWNUM");
						String pname = rs.getString("PNAME");
						String jname = rs.getString("JNAME");
						int kor= rs.getInt("KOR");
						int eng= rs.getInt("ENG");
						int mat= rs.getInt("MAT");
						int sum= rs.getInt("KOR+ENG+MAT");
						System.out.println(rank+ "등 \t" + pname + "\t" + jname + "\t"+ kor + "\t"+ eng + "\t"+ mat + "\t"+ sum);
					}while(rs.next());
					
				}else {
					System.out.println("해당 직업군에 사람이 존재하지 않습니다.");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			 break;
		 case "3" :
			 sql = "SELECT  ROWNUM, PNAME , JNAME , " + 
				 		"        KOR , ENG , MAT , KOR+ENG+MAT " + 
				 		"    FROM (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO " + 
				 		"     ORDER BY KOR+ENG+MAT DESC)";
			 try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
					rs   = stmt.executeQuery(sql);
					if (rs.next()) {
						do {
							int rank = rs.getInt("ROWNUM");
							String pname = rs.getString("PNAME");
							String jname = rs.getString("JNAME");
							int kor= rs.getInt("KOR");
							int eng= rs.getInt("ENG");
							int mat= rs.getInt("MAT");
							int sum= rs.getInt("KOR+ENG+MAT");
							System.out.println(rank+ "등 \t" + pname + "\t" + jname + "\t"+ kor + "\t"+ eng + "\t"+ mat + "\t"+ sum);
						}while(rs.next());
						
					}else {
						System.out.println("유효한 명령이 아닙니다.");
					}
				} catch (SQLException e) {
					System.out.println("a"+e.getMessage());
				} finally {
					try {
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println("b"+e.getMessage());
					}
				}
			    break;
		 }
	 }while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
	 sc.close();
	 System.out.println("BYE");
	 
	 
 }
}
