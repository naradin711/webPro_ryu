package com.lec.ex6_PreparedStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01_InsertDeptPrepareStatement {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner (System.in);
		Connection conn  = null; // DB ���� ��ü ����
		PreparedStatement  pstmt  = null; // SQL ���� ��ü ����
		String sql = String.format("INSERT INTO DEPT VALUES (?, ?, ?)");
		//�߰��� ������ �ޱ�
		System.out.print("�߰��� �μ� ��ȣ��? ");
		int deptno = sc.nextInt();
		System.out.print("�߰��� �μ� �̸���? ");
		String dname = sc.next();
		System.out.print("�߰��� �μ� ��ġ��? ");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // sql ���۰�ü
			pstmt.setInt(1, deptno); // sql�� ù��° ����ǥ�� int ������ deptno�� ����
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? deptno+"�� �Է� ����" : "�Է� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	}finally{
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
	}

 }

}