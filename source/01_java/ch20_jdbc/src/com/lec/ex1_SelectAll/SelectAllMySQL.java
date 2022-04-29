package com.lec.ex1_SelectAll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		String sql = "SELECT * FROM PERSONAL"; // kimdb���� personal ���̺� ��������!
        Connection conn = null;  // DB ���� ��ü ����
        Statement  stmt  = null; // SQL ���� ��ü ����
        ResultSet  rs    = null; // SELECT�� ��� �޴� ��ü ����
        try {
			Class.forName(driver); // step 1
			conn = DriverManager.getConnection(url, "root", "mysql"); // step 2
			stmt = conn.createStatement(); // step 3
			rs   = stmt.executeQuery(sql); // step 4 + 5
			if(rs.next()) { // SELECT�� ����� �ִ� ���
			    System.out.println("���\t�̸�\t��å\t\t����ȣ\t�Ի���\t\t�޿�\t��\t�μ���ȣ");	 // �ʵ� ����Ʈ�ϱ�
			    do {
			    	int pno        = rs.getInt("pno");
			    	String pname   = rs.getString("pname");
			    	String job     = rs.getString("job");
			    	int manager    = rs.getInt("manager");
			    	Date startdate = rs.getDate("startdate");
			    	int pay        = rs.getInt("pay");
			    	int bonus      = rs.getInt("bonus");
			    	int dno        = rs.getInt("dno");
			    	if(job.length()<8) {
			    		System.out.println(pno+"\t"+pname+"\t"+job+"\t\t"+manager+"\t"
		    	                   + startdate + "\t" + pay + "\t" + bonus + "\t" + dno + "\t");
					}else {
						System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"
		    	                   + startdate + "\t" + pay + "\t" + bonus + "\t" + dno + "\t");
					}
			    }while (rs.next());
			}else { // SELECT�� ����� ���� ���
				System.out.println("PERSONAL Data is NULL");
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
		}
       
	}
}
