package com.lec.ex6_PreparedStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex02_SelectPreparedStatement {
// �μ����� �Է¹޾� �ش� �μ��� ����� ���, �̸�, ��å, �޿��� ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		Connection conn  = null; // DB ���� ��ü ����
		PreparedStatement  pstmt  = null; // SQL ���� ��ü ����
		ResultSet  rs    = null; // SELECT�� ��� �޴� ��ü ����
		System.out.printf("�˻��ϰ��� �ϴ� �μ����� �Է��Ͻÿ�. : ");
		String dname = sc.next();
		String sql = " SELECT EMPNO, ENAME, JOB, SAL " + 
    		"    FROM EMP E, DEPT D " + 
    		"    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // sql ���۰�ü
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("���, �̸�, ��å, �޿�");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					if(job.length()<7) {
						System.out.printf("%d\t %s\t %s\t\t %d\n", empno, ename, job, sal);
					}else {
						System.out.printf("%d\t %s\t %s\t %d\n", empno, ename, job, sal);
					}
				}while (rs.next());
			}else {
				System.out.println("��ȿ�� �μ����� �ƴմϴ�.");
			}			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} 
		}
	}
}
