package com.lec.ex3_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// �μ���ȣ�� �Է¹޾� �ߺ�üũ�� Ȯ�� �� �Է������ϱ�
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in); // ��ĳ��
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null; // select ���� ��ü ����
		System.out.print("�Է��� �μ� ��ȣ��? "); // �Է��� �μ���ȣ
		int deptno = sc.nextInt();
		String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; // �Է��� ���ڹ�ȣ�� ��� �ʵ尪�� ������	
		// String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+ dname +"', '"+loc+"')";

		try {
			Class.forName(driver); //1.driver ����
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			rs   = stmt.executeQuery(selectSQL); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ� 1�� ����
			if(!rs.next()) { // �Է��� rs�� �������� ������ �ߺ��� ��ȣ�� �ƴϹǷ� if !�� ����Ͽ� �ߺ��� �ƴ��� �����϶�
				System.out.println("�Է��Ͻ� �μ� ��ȣ�� ����Ͻ� �� �ֽ��ϴ�."); // �Է°����ϴٰ� ����
				System.out.println("�Է��� �μ� �̸���? ");                // �μ��̸�
				String dname = sc.next();
				sc.nextLine();                                        // �ߺ����� �ؽ�Ʈ����
				System.out.println("�Է��� �μ� ��ġ��? ");                // �μ� ��ġ
				String loc = sc.next();
				//string format�� �̿��Ͽ� ���ϰ��� �ϴ� ���� ���
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc); 
				int result = stmt.executeUpdate(sql); // ������� ������Ʈ��Ʈ���� ������
				System.out.println(result > 0 ? "�Է� ����" : "�Է� ����"); // 6. ���ϴ� ���� ����ϱ�
			}else {
				System.out.println("�Է��Ͻ� �μ� ��ȣ�� ��ȿ���� �ʽ��ϴ�.");	
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
