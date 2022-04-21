package com.lec.ex2_SelectWhere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. 사용자에게 부서명을 입력받아
//	1-1 부서 존재하는 경우 : 부서 정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력
//	1-2 부서 존재하지 않는 경우 : 없다고 출력
public class Ex03_SelectDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB 연결 객체 변수
		Statement  stmt  = null; // SQL 전송 객체 변수
		ResultSet  rs    = null; // SELECT문 결과 받는 객체 변수
		Scanner sc = new Scanner (System.in);
		System.out.print("찾기 원하는 부서명을 입력하세요. : ");
		String dname = sc.nextLine();
		// String sql1 = "SELECT * FROM DEPT WHERE DNAME= UPPER('"+dname+"')";
		// String.format과 %s를 이용하여 중간의 dname을 입력하기 쉽게 한다
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE " + 
				                    "    FROM EMP e, SALGRADE S, DEPT D " + 
				                    "    WHERE SAL BETWEEN LOSAL AND HISAL "+
				                    "    AND E.DEPTNO = D.DEPTNO AND DNAME=UPPER('%s')", dname );
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB 연결
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(sql1); // 4. SQL문 전송 + 5. SQL문 전송 결과 받기 1번 쿼리
			if(rs.next()) { // 해당부서가 있음
				System.out.println("부서번호 : "+ rs.getInt("DEPTNO"));
				System.out.println("부서이름 : "+ rs.getString("DNAME"));
				System.out.println("부서위치 : "+ rs.getString("LOC"));
				rs.close(); // sql1 rs 닫음
				rs   = stmt.executeQuery(sql2); // sql2 rs 시작
				if (rs.next()) {
					System.out.println("사번\t 이름\t 급여\t 급여등급");
					do {
						int empno      = rs.getInt("empno");
						String ename   = rs.getString("ename");
						int SAL        = rs.getInt("SAL");
						int GRADE      = rs.getInt("GRADE");
						System.out.println(empno + "\t"+ ename + "\t"+ SAL +"\t"+ GRADE);
					}while (rs.next());
				}else {
					System.out.println(dname+" 부서의 사원은 존재하지 않습니다.");
				}
			 }else {// 해당부서가 없음
				System.out.println(dname+" 부서는 존재하지 않습니다.");
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
