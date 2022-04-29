package com.lec.ex2_SelectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. ����ڿ��� �μ���ȣ �Է¹޾Ƽ�
//  1-1 . �ش�μ���ȣ�� ������ ��� : �ش� �μ��� ������ ��� ����(���, �̸�, �޿�, ����)�� ���
//  1-2 . �ش�μ���ȣ�� �������� ���� ��� : ���ٰ� ���
public class Ex02_SelectDeptnoEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn  = null; // DB ���� ��ü ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null; // SELECT�� ��� �޴� ��ü ����
		Scanner sc = new Scanner (System.in);
		System.out.print("ã�� ���ϴ� �μ���ȣ�� �Է��ϼ���. : ");
		int deptno = sc.nextInt();
		String sql1 = "SELECT * FROM DEPT D WHERE DEPTNO= "+deptno;
		String sql2 = "SELECT W.EMPNO empno, W.ENAME ename, W.SAL sal, M.ENAME MGRNAME" + 
				      "    FROM EMP W, EMP M" + 
				      "    WHERE W.MGR=M.EMPNO AND W.DEPTNO ="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			rs   = stmt.executeQuery(sql1); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ� 1�� ����
			if(rs.next()) { // �ش�μ��� ����
				System.out.println("�μ���ȣ : " + deptno);
				System.out.println("�μ��̸� : "+rs.getString("dname"));
				System.out.println("�μ���ġ : "+rs.getString("loc"));
				rs.close(); // rs ����ϱ� ���� ����
				rs   = stmt.executeQuery(sql2);
				if (rs.next()) {
					System.out.println("���\t �̸�\t �޿�\t ����");
					do {
						int empno      = rs.getInt("empno");
						String ename   = rs.getString("ename");
						int sal        = rs.getInt("sal");
						String MGRNAME = rs.getString("MGRNAME");
						System.out.println(empno + "\t"+ ename + "\t"+ sal +"\t"+ MGRNAME);
					}while (rs.next());
				}else {
					System.out.println(deptno+"�� �μ��� ����� �������� �ʽ��ϴ�.");
				}	
			}else { // �ش�μ��� ����
				System.out.println(deptno+"�� �μ��� �������� �ʽ��ϴ�.");
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
