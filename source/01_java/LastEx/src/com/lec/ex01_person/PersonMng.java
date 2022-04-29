package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1. �Է� 2. ��������ȸ 3. ��ü���  �׿�.����
public class PersonMng {
   public static void main(String[] args) {
	 String driver = "oracle.jdbc.driver.OracleDriver";
	 String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	 Connection          conn  = null; // DB ���� ��ü ����
	 Statement           stmt  = null; // SQL ���� ��ü ���� 3��
	 PreparedStatement  pstmt  = null; // 1���̶� 2��
	 ResultSet             rs  = null; // SELECT�� ��� �޴� ��ü ���� 2�� 3�� ����� ���� �ʿ�
	 Scanner sc = new Scanner (System.in);
	 String fn, sql;
	 try {
		Class.forName(driver); // 1. ����̹� �ε�.
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}// (1) ����̹� �ε�
	 do {
		 System.out.print("1. �Է� 2. || ��������ȸ || 3. ��ü��� || �׿� : ����  ");
		 fn = sc.next();
		 switch(fn) {
		 case "1" : // �̸�, ������, ��, ��, �� ���� �Է� �޾�
			 //2�ܰ�~7�ܰ�
			 sql = "INSERT INTO PERSON VALUES " + 
			 		"   (PERSON_SEQ.NEXTVAL, ? , (SELECT JNO  FROM JOB WHERE JNAME = ?) , ?, ?, ?)";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql); // sql ���۰�ü
				System.out.print("�Է��� �̸���? ");
				pstmt.setString(1, sc.next()); 
				System.out.print("�Է��� ��������? ");
				pstmt.setString(2, sc.next());
				System.out.print("���� ������? ");
				pstmt.setInt(3, sc.nextInt());
				System.out.print("���� ������? ");
				pstmt.setInt(4, sc.nextInt());
				System.out.print("���� ������? ");
				pstmt.setInt(5, sc.nextInt());
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
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
				pstmt = conn.prepareStatement(sql); // sql ���۰�ü
				System.out.print("ã�����ϴ� ��������? ");
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
						System.out.println(rank+ "�� \t" + pname + "\t" + jname + "\t"+ kor + "\t"+ eng + "\t"+ mat + "\t"+ sum);
					}while(rs.next());
					
				}else {
					System.out.println("�ش� �������� ����� �������� �ʽ��ϴ�.");
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
					stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
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
							System.out.println(rank+ "�� \t" + pname + "\t" + jname + "\t"+ kor + "\t"+ eng + "\t"+ mat + "\t"+ sum);
						}while(rs.next());
						
					}else {
						System.out.println("��ȿ�� ����� �ƴմϴ�.");
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
