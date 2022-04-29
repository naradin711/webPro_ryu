package com.lec.ex3_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// �μ���ȣ�� �Է¹޾� �ߺ�üũ�� Ȯ�� �� �Է������ϱ�
public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null;
		System.out.print("�Է��� �μ� ��ȣ��? ");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;	
		// String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+ dname +"', '"+loc+"')";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			while(true) {
			System.out.print("�Է��� �μ� ��ȣ��? ");
			deptno = sc.nextInt();
			rs   = stmt.executeQuery(selectSQL); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ� 1�� ����
			rs.next();
			int cnt = rs.getInt("CNT");
			if(cnt!=0) {
				System.out.println("�Է��Ͻ� �μ� ��ȣ�� ��ȿ���� �ʽ��ϴ�.");	
				
			}		
				System.out.println("�Է��� �μ� �̸���? ");
				String dname = sc.next();
				System.out.println("�Է��� �μ� ��ġ��? ");
				String loc = sc.next();
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);	
				int result = stmt.executeUpdate(sql);
				System.out.println(result > 0 ? "�Է� ����" : "�Է� ����"); // 6. ���ϴ� ���� ����ϱ�
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
