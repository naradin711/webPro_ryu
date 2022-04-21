package com.lec.ex3_Update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept2 {
// �����ϰ��� �ϴ� �μ���ȣ �Է� -> �����ϴ� �μ���ȣ���� üũ -> �μ���� ��ġ�� �޾� ����
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null; // SELECT ���� 
		Scanner sc = new Scanner (System.in);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			System.out.print("������ �μ� ��ȣ�� �Է����ּ���. : ");
			int deptno = sc.nextInt();
			// �Է��� �ش� �μ���ȣ�� �ִ��� ������ üũ
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; //������ ������ �빮�ڷ�.
			//
			rs = stmt.executeQuery(selectSQL); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ� 1�� ����
			if(rs.next()) {
				System.out.println("�Է��Ͻ� ��ȣ�� �μ��� ������ �Ʒ��� �����ϴ�.");
				System.out.println("�μ���ȣ\t �μ���\t �μ���ġ\t");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");	
				System.out.println(deptno + "\t" + dname + "\t" + loc);
				System.out.print("������ �μ����� �Է����ּ���. : ");
				dname = sc.next();
				System.out.print("������ �μ� ��ġ�� �Է����ּ���. : ");
				loc = sc.next();
				String sql = 
					String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %d", dname, loc, deptno);
				int result = stmt.executeUpdate(sql);
				if(result>0) {
				System.out.println("��������");
				}
			}else {
				System.out.println(deptno + "�� �μ��� �������� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // 7. if() close();�� ��������
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
