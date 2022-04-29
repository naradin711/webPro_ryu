package com.lec.ex1_SelectAll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		String sql = "SELECT * FROM PERSONAL"; // kimdb에서 personal 테이블 가져오기!
        Connection conn = null;  // DB 연결 객체 변수
        Statement  stmt  = null; // SQL 전송 객체 변수
        ResultSet  rs    = null; // SELECT문 결과 받는 객체 변수
        try {
			Class.forName(driver); // step 1
			conn = DriverManager.getConnection(url, "root", "mysql"); // step 2
			stmt = conn.createStatement(); // step 3
			rs   = stmt.executeQuery(sql); // step 4 + 5
			if(rs.next()) { // SELECT문 결과가 있는 경우
			    System.out.println("사번\t이름\t직책\t\t상사번호\t입사일\t\t급여\t상여\t부서번호");	 // 필드 프린트하기
			    do {
			    	int pno        = rs.getInt("pno");
			    	String pname   = rs.getString("pname");
			    	String job     = rs.getString("job");
			    	int manager    = rs.getInt("manager");
			    	Date startdate = rs.getDate("startdate");
			    	int pay        = rs.getInt("pay");
			    	int bonus      = rs.getInt("bonus");
			    	int dno        = rs.getInt("dno");
			    	if(job.length()<8) {
			    		System.out.println(pno+"\t"+pname+"\t"+job+"\t\t"+manager+"\t"
		    	                   + startdate + "\t" + pay + "\t" + bonus + "\t" + dno + "\t");
					}else {
						System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"
		    	                   + startdate + "\t" + pay + "\t" + bonus + "\t" + dno + "\t");
					}
			    }while (rs.next());
			}else { // SELECT문 결과가 없는 경우
				System.out.println("PERSONAL Data is NULL");
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
		}
       
	}
}
