package com.lec.ex3_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		System.out.print("�Է��� �μ� ��ȣ��? ");
		int deptno = sc.nextInt();
		System.out.println("�Է��� �μ� �̸���? ");
		String dname = sc.next();
		System.out.println("�Է��� �μ� ��ġ��? ");
		String loc = sc.next();
		// String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+ dname +"', '"+loc+"')";
		String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			int result = stmt.executeUpdate(sql); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ� 1�� ����	
			System.out.println(result > 0 ? "�Է� ����" : "�Է� ����"); // 6. ���ϴ� ���� ����ϱ� 
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ���� : " + e.getMessage());
		} finally { // 7. if() close();�� ��������
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}//try
		
	}

}
