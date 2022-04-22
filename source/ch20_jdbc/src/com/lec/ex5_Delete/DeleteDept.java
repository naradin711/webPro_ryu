package com.lec.ex5_Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �����ϰ��� �ϴ� �μ���ȣ�� �Է¹޾Ƽ� �����ϱ�
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		Scanner sc = new Scanner (System.in);
		System.out.printf("�����ϰ��� �ϴ� �μ��� ��ȣ�� �Է��Ͻÿ�. :");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO = "+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); //
			int result = stmt.executeUpdate(sql); // 4. 5.
			System.out.println(result>0 ? deptno+"�� �μ� ���� ����" : deptno+"�� �μ��� �������� �ʽ��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ����" + e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println("SQL ����" + e.getMessage());
			}	
		}// try
	}//main
}//class
