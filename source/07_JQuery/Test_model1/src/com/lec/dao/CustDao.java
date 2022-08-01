package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource; 
import com.lec.dto.CustDto; 

public class CustDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static CustDao instance;
	public static CustDao getInstance() {
		if(instance == null) {
			instance = new CustDao();
		}
		return instance;
	}
	private CustDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null; 
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return conn;
	}
	
	public int insertCust(CustDto cust) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city) " + 
				"	   values ( (100000+MT_SEQ.nextval), ? , ? , ? , ? , ? , ? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cust.getCustname());
			pstmt.setString(2, cust.getPhone());
			pstmt.setString(3, cust.getAddress());
			pstmt.setDate(4, cust.getJoindate());
			pstmt.setString(5, cust.getGrade());
			pstmt.setString(6, cust.getCity()); 
			result = pstmt.executeUpdate();
		    System.out.println(result==SUCCESS ? "회원 가입 성공": "회원 가입 실패");
			 
			
		} catch (Exception e) {
			System.out.println(e.getMessage()+"CustDao insertCust11");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()+"22");
			}
		}
		return result;
		
	}
	public ArrayList<CustDto> listCust (){
		ArrayList<CustDto> custs = new ArrayList<CustDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM MEMBER_TEST ORDER BY CUSTNO";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {  
				int custno			= rs.getInt("custno");      
				String custname 	= rs.getString("custname");
				String phone 	= rs.getString("phone");
				String address 	= rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade 	= rs.getString("grade");
				String city 	= rs.getString("city");
				  
			    custs.add(new CustDto(custno, custname, phone, address, joindate, grade, city));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return custs;
	}
	public int modifyCustomer(CustDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " update MEMBER_TEST set custname = ? , " + 
				"					   phone = ? , " + 
				"					   address = ? , " + 
				"					   joindate = ? , " + 
				"					   grade = ? , " + 
				"					   city = ? " + 
				"					   where custno = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(1);
			pstmt.setString	(1, dto.getCustname());
			pstmt.setString	(2, dto.getPhone());
			pstmt.setString	(3, dto.getAddress());
			pstmt.setDate	(4, dto.getJoindate());
			pstmt.setString	(5, dto.getGrade());
			pstmt.setString	(6, dto.getCity());
			pstmt.setInt	(7, dto.getCustno());
			System.out.println(2);
			result = pstmt.executeUpdate();
			System.out.println(3);
			System.out.println(result==SUCCESS? "정보 수정 성공":"정보 수정 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() +"CustDao modifyCust 정보 수정 에러" + dto);
		} finally {
			try {			 
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public CustDto getCus(int custno) {
		CustDto cust = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from MEMBER_TEST where custno = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()){         
				String custname 	= rs.getString("custname");
				String phone 	= rs.getString("phone");
				String address 	= rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade 	= rs.getString("grade");
				String city 	= rs.getString("city");
			    cust = new CustDto(custno, custname, phone, address, joindate, grade, city);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return cust;
	}
	
}

















