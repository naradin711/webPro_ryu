package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

public class CustomerDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0; 
	public static final int CUSTOMER_NONEXISTENT = 1; 
	public static final int CUSTOMER_EXISTENT = 0;  
	public static final int LOGIN_SUCCESS = 1; 
	public static final int LOGIN_FAIL_ID = -1; 
	public static final int LOGIN_FAIL_PW = 0; 
	
	private static CustomerDao instance;
	public static CustomerDao getInstance () {
		if (instance == null) {
			instance = new CustomerDao();
		}
		return instance;
	}
	private CustomerDao () {}
	
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	//-- 1. 회원가입 id 중복체크 : 
	public int confirmId(String cid) {
		int result = CUSTOMER_EXISTENT; 
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;	
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = CUSTOMER_EXISTENT; 
			} else {
				result = CUSTOMER_NONEXISTENT; 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	//-- 2. 회원가입 : 
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER "
				+ "( CID,  CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) " + 
				" VALUES( ? , ? , ? , ? , ? , ? , ? , ? , SYSDATE )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setDate (8, dto.getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공" : "회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	
	//-- 3. 로그인 (ID/PW) : 
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL_ID;
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		String sql = "SELECT cid, cpw FROM CUSTOMER WHERE CID = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pwDB = rs.getString("cpw");
				if (pwDB.equals(cpw)) {
					result = LOGIN_SUCCESS;
				} else {
					result = LOGIN_FAIL_PW;
				}
			}else {
				result = LOGIN_FAIL_ID;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"33");
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()+"11");
			}
		}
		return result;
	}
	
	// 4. cid로 dto가져오기 : 
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;	
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String cpw		 =rs.getString("cpw");
				String cname	 =rs.getString("cname");
				String ctel		 =rs.getString("ctel");
				String cemail	 =rs.getString("cemail");
				String caddress	 =rs.getString("caddress");
				String cgender	 =rs.getString("cgender");
				Date cbirth 	 =rs.getDate("cbirth");
				Date crdate		 =rs.getDate("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	//5. 회원정보 수정 : 
	
	public int modifyC(CustomerDto dto) {
		int result = FAIL;
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPW     	= ? " + 
				"	                    CNAME   	= ? " + 
				"	                    CTEL    	= ? " + 
				"	                    CEMAIL  	= ? " + 
				"	                    CADDRESS 	= ? " + 
				"	                    CGENDER 	= ? " + 
				"	                    CBIRTH  	= ? " + 
				"	                    where cid 	= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString	(1, dto.getCpw());
			pstmt.setString	(2, dto.getCname());
			pstmt.setString	(3, dto.getCtel());
			pstmt.setString	(4, dto.getCemail());
			pstmt.setString	(5, dto.getCaddress());
			pstmt.setString	(6, dto.getCgender());
			pstmt.setDate 	(7, dto.getCbirth());
			pstmt.setString	(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공" : "회원가입실패");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return result;
	}

	 
	
	
	
}




















