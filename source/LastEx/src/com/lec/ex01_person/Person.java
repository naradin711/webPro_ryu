package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection          conn  = null; // DB ���� ��ü ����
		Statement           stmt  = null; // SQL ���� ��ü ����
		PreparedStatement  pstmt  = null;
		ResultSet             rs  = null; // SELECT�� ��� �޴� ��ü ����
		String dname = null;
		int fn; // ��ɹ�ȣ (1 : �������Է� | 2: ������ ��ȸ | 3:��ü ��ȸ| 0:����)
		String sql1 = "SELECT  ROWNUM ||'��' , PNAME||'('||PNO||'��)' , JNAME, " + 
				"        KOR , ENG , MAT , KOR+ENG+MAT SUM " + 
				"    FROM  " + 
				"    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = ? " + 
				"     ORDER BY KOR+ENG+MAT DESC)";
		String sql2 = " SELECT  ROWNUM ||'��'  , PNAME||'('||PNO||'��)' , JNAME, " + 
				"        KOR , ENG  , MAT , KOR+ENG+MAT " + 
				"    FROM " + 
				"    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO " + 
				"     ORDER BY KOR+ENG+MAT DESC) " ;
		Scanner sc = new Scanner (System.in);	
		System.out.print("1 : �������Է� | 2:������ ��ȸ | 3:��ü ��ȸ | 0:����\t");
		fn = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1); // sql ���۰�ü
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
