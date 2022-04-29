package com.lec.ex2_SelectWhere;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. ����ڿ��� �μ����� �Է¹޾�
//	1-1 �μ� �����ϴ� ��� : �μ� ������ �������(���, �̸�, �޿�, �޿����)�� ���
//	1-2 �μ� �������� �ʴ� ��� : ���ٰ� ���
public class Ex03_SelectDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null; // SELECT�� ��� �޴� ��ü ����
		Scanner sc = new Scanner (System.in);
		System.out.print("ã�� ���ϴ� �μ����� �Է��ϼ���. : ");
		String dname = sc.nextLine();
		// String sql1 = "SELECT * FROM DEPT WHERE DNAME= UPPER('"+dname+"')";
		// String.format�� %s�� �̿��Ͽ� �߰��� dname�� �Է��ϱ� ���� �Ѵ�
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE " + 
				                    "    FROM EMP e, SALGRADE S, DEPT D " + 
				                    "    WHERE SAL BETWEEN LOSAL AND HISAL "+
				                    "    AND E.DEPTNO = D.DEPTNO AND DNAME=UPPER('%s')", dname );
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			rs   = stmt.executeQuery(sql1); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ� 1�� ����
			if(rs.next()) { // �ش�μ��� ����
				System.out.println("�μ���ȣ : "+ rs.getInt("DEPTNO"));
				System.out.println("�μ��̸� : "+ rs.getString("DNAME"));
				System.out.println("�μ���ġ : "+ rs.getString("LOC"));
				rs.close(); // sql1 rs ����
				rs   = stmt.executeQuery(sql2); // sql2 rs ����
				if (rs.next()) {
					System.out.println("���\t �̸�\t �޿�\t �޿����");
					do {
						int empno      = rs.getInt("empno");
						String ename   = rs.getString("ename");
						int SAL        = rs.getInt("SAL");
						int GRADE      = rs.getInt("GRADE");
						System.out.println(empno + "\t"+ ename + "\t"+ SAL +"\t"+ GRADE);
					}while (rs.next());
				}else {
					System.out.println(dname+" �μ��� ����� �������� �ʽ��ϴ�.");
				}
			 }else {// �ش�μ��� ����
				System.out.println(dname+" �μ��� �������� �ʽ��ϴ�.");
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
