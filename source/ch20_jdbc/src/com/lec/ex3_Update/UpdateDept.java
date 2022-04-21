package com.lec.ex3_Update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		Scanner sc = new Scanner (System.in);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			System.out.print("������ �μ� ��ȣ�� �Է����ּ���. : ");
			int deptno = sc.nextInt();
			// �Է��� �μ���ȣ�� �ִ��� ������ üũ�� ���߿�
			System.out.print("������ �μ����� �Է����ּ���. : ");
			String dname = sc.next();
			System.out.print("������ �μ� ��ġ�� �Է����ּ���. : ");
			String loc = sc.next();
			String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %d", dname, loc, deptno);
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? "��������" : "�ش� �μ��� �������� �ʽ��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // 7. if() close();�� ��������
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}//try
	}

}
