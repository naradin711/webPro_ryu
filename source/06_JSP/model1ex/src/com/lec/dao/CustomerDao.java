package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int CUSTOMER_NONEXISITENT = 1;
	public static final int CUSTOMER_EXISITENT = 0;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL = 0;
	//싱글톤
	private static CustomerDao instance;
	public static CustomerDao getInstance(){
		if(instance == null) {
			instance = new CustomerDao();
		}
		return instance;
	}
	private CustomerDao() {}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 		
		return conn;
	}
	
	// 1.회원 가입 시 중복 체크
	public int confirmCid(String cid) {
		int result = CUSTOMER_EXISITENT;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {   // 기존 회원 존재하면
				result = CUSTOMER_EXISITENT;
			} else {		// 기존 회원 존재하지 않으면
				result = CUSTOMER_NONEXISITENT;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return result;
		
	}
	// 회원가입
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID,  CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE) " + 
				"         VALUES( ? , ? , ? , ? , ? , ?, ?, ?, SYSDATE ) ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString	(1, dto.getCid());
			pstmt.setString	(2, dto.getCpw());
			pstmt.setString	(3, dto.getCname());
			pstmt.setString	(4, dto.getCtel());
			pstmt.setString	(5, dto.getCemail());
			pstmt.setString	(6, dto.getCaddress());
			pstmt.setString	(7, dto.getCgender());
			pstmt.setDate	(8, dto.getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage()+dto);
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
	
	// 3. 로그인 (cid/cpw)
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID= ? and CPW = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {   	// 로그인 성공
				result = LOGIN_SUCCESS;
			} else {			// 로그인 실패
				result = LOGIN_FAIL;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 4. cid로 dto 가져오기
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				String 	cpw 	= rs.getString("cpw");
				String 	cname 	= rs.getString("cname"); 
				String 	ctel 	= rs.getString("ctel");
				String 	cemail 	= rs.getString("cemail");
				String 	caddress= rs.getString("caddress");
				String 	cgender = rs.getString("cgender");
				Date 	cbirth 	= rs.getDate("cbirth");
				Date  	crdate 	= rs.getDate("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	
	// 회원정보 수정
	
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE CUSTOMER SET  " + 
				"                    CPW = ? , " + 
				"                    CTEL = ? , " + 
				"                    CEMAIL = ? , " + 
				"                    CADDRESS = ? , " + 
				"                    CGENDER = ? , "  +
				"                    CBIRTH = ? " +
				"                    WHERE CID= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(1);
			pstmt.setString	(1, dto.getCpw());
			pstmt.setString	(2, dto.getCtel());
			pstmt.setString	(3, dto.getCemail());
			pstmt.setString	(4, dto.getCaddress());
			pstmt.setString	(5, dto.getCgender());
			pstmt.setDate	(6, dto.getCbirth());
			pstmt.setString	(7, dto.getCid());
			System.out.println(2);
			result = pstmt.executeUpdate();
			System.out.println(3);
			System.out.println(result==SUCCESS? "정보 수정 성공":"정보 수정 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() +"정보 수정 에러" + dto);
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
	
	// 6. 회원리스트 출력하기 (첫화면에서 쓰임) TOP-N구문으로 출력 추후 페이징
	public ArrayList<CustomerDto> listCustomer(int startRow, int endRow){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS  " + 
				"             FROM (SELECT * FROM CUSTOMER ORDER BY customer.crdate DESC) A) " + 
				"             WHERE RN BETWEEN ? AND ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String 	cid 	= rs.getString("cid");
				String 	cpw 	= rs.getString("cpw");
				String 	cname 	= rs.getString("cname");
				String 	cemail 	= rs.getString("cemail");
				String 	caddress= rs.getString("caddress");
				dtos.add(new CustomerDto(cid, cpw, cname, null, cemail, caddress, null, null, null));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
		
	}
	
	// 7. 등록된 회원수
	public int getCustomercnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT COUNT(*) CNT FROM CUSTOMER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("CNT");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
