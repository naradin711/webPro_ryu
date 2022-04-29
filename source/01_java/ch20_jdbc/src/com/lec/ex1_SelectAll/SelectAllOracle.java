package com.lec.ex1_SelectAll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
public class SelectAllOracle {
	public static void main(String[] args) {
		// 1. ����̺� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// 2. ���� ���� ����
		Connection conn  = null; // DB ���� ��ü ����
		// 3.  Statement ����
		Statement  stmt  = null; // SQL ���� ��ü ����
		// 4. SQL�� ���� 
		ResultSet  rs    = null; // SELECT�� ��� �޴� ��ü ����
		String query = "SELECT * FROM EMP";
		
		try {
			Class.forName(driver); // 1. Driver �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB ����
			stmt = conn.createStatement(); // 3.  Statement ���� ��ü ����
			rs   = stmt.executeQuery(query); // 4. SQL�� ���� + 5. SQL�� ���� ��� �ޱ�
			// 6. ����� �޾� ���ϴ� ������ �����Ѵ�!
			System.out.println("���\t�̸�\t��å\t\t����ȣ\t�Ի���\t\t�޿�\t��\t�μ���ȣ"); // �ʵ� ����Ʈ�ϱ�
			while (rs.next()){ // �ʵ尪 �ֱ�
				//int empno = rs.getInt("empno");    // ���� ��������
				String empno  = rs.getString("empno"); // ����, ���ڿ� ��������
				String ename  = rs.getString("ename");
				String job    = rs.getString("job");
				int    mgr    = rs.getInt("mgr");
				// Date hiredate = rs.getDate("hiredate");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int    sal    = rs.getInt("sal");
				int    comm   = rs.getInt("comm");
				int    deptno = rs.getInt("deptno");
				if(job.length()<7) {
					System.out.printf("%s\t %s\t %s\t\t %d\t %TF\t %d\t %d\t %d\n",
					           empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}else {
					System.out.printf("%s\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
					           empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}
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
	}//main
}//class
