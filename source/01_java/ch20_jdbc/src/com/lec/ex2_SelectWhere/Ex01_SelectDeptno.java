package com.lec.ex2_SelectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ� ���� ����ϱ�.
public class Ex01_SelectDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null; // SELECT�� ��� �޴� ��ü ����
		Scanner sc = new Scanner (System.in);
		System.out.print("ã�� ���ϴ� �μ���ȣ�� �Է��ϼ���. : ");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO= "+deptno;
		try {
			Class.forName(driver); // 1. driver ����
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			rs   = stmt.executeQuery(sql); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ�
		if(rs.next()) { // �ش�μ��� ����
			System.out.println(deptno+"�� �μ� ������ ������ �����ϴ�."); 
			System.out.println("�μ��̸� : "+rs.getString("dname"));
			System.out.println("�μ���ġ : "+rs.getString("loc")); //6. �ش� ���� ���� �� ����� ���
		}else { // �ش�μ��� ����
			System.out.println("DEPTNO DATA IS MISSING");
		}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. if() close();�� ��������
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
