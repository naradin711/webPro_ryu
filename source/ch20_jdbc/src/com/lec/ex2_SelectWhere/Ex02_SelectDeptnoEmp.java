package com.lec.ex2_SelectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. 사용자에게 부서번호 입력받아서
//  1-1 . 해당부서번호가 존재할 경우 : 해당 부서의 정보와 사원 정보(사번, 이름, 급여, 상사명)를 출력
//  1-2 . 해당부서번호가 존재하지 않을 경우 : 없다고 출력
public class Ex02_SelectDeptnoEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null; // SELECT문 결과 받는 객체 변수
		Scanner sc = new Scanner (System.in);
		System.out.print("찾기 원하는 부서번호를 입력하세요. : ");
		int deptno = sc.nextInt();
		String sql1 = "SELECT * FROM DEPT D WHERE DEPTNO= "+deptno;
		String sql2 = "SELECT W.EMPNO empno, W.ENAME ename, W.SAL sal, M.ENAME MGRNAME" + 
				      "    FROM EMP W, EMP M" + 
				      "    WHERE W.MGR=M.EMPNO AND W.DEPTNO ="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(sql1); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기 1번 쿼리
			if(rs.next()) { // 해당부서가 있음
				System.out.println("부서번호 : " + deptno);
				System.out.println("부서이름 : "+rs.getString("dname"));
				System.out.println("부서위치 : "+rs.getString("loc"));
				rs.close(); // rs 사용하기 전에 해제
				rs   = stmt.executeQuery(sql2);
				if (rs.next()) {
					System.out.println("사번\t 이름\t 급여\t 상사명");
					do {
						int empno      = rs.getInt("empno");
						String ename   = rs.getString("ename");
						int sal        = rs.getInt("sal");
						String MGRNAME = rs.getString("MGRNAME");
						System.out.println(empno + "\t"+ ename + "\t"+ sal +"\t"+ MGRNAME);
					}while (rs.next());
				}else {
					System.out.println(deptno+"번 부서의 사원은 존재하지 않습니다.");
				}	
			}else { // 해당부서가 없음
				System.out.println(deptno+"번 부서는 존재하지 않습니다.");
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
