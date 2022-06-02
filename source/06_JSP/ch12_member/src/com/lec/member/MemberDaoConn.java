package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.omg.CORBA.INITIALIZE;

public class MemberDaoConn {
	public static final int SUCCESS = 1; //회원가입, 정보수정 시 성공
	public static final int FAIL 	= 0; //회원가입, 정보수정 시 실패
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 아이디일 때
	public static final int MEMBER_EXISTENT    = 0; // 중복된 아이디일 때
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시 리턴값
	public static final int LOGIN_FAIL_ID = -1; // // 로그인시 ID오류일때 리턴값
	public static final int LOGIN_FAIL_PW = 0; // // 로그인시 PW오류일때 리턴값
	
	// conn객체 관리하는 함수
	private Connection getConnection() throws SQLException  {
		// 커넥션풀의 Datasource안의 conn 객체 이용
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("커넥션풀 이름 오류 : "+ e.getMessage());
		}
		
		return conn;
	}
	
	private String driver	= "oracle.jdbc.driver.OracleDriver";
	private String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
	
//-- 1. 회원가입시 ID 중복 체크를 위한 SQL : public int confirm id(String id)
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT; //결과값 초기화
		// 중복인지 사용 가능인지 sql로 조회=SELECT * FROM MEMBER WHERE ID = 'aaa';
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		ResultSet			rs	  = null;
		String sql ="SELECT * FROM MEMBER WHERE ID = ? ";
		try {
			conn = getConnection(); // 2
			pstmt = conn.prepareStatement(sql); // 3
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // 4 5
			if (rs.next()) {
				result = MEMBER_EXISTENT; //있는 아이디 / 회원 가입시 중복된 아이디
			} else {
				result = MEMBER_NONEXISTENT; //없는 아이디 / 회원 가입시 사용 가능한 아이디
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
		return result;
	}
	
//-- 2. 회원가입 : public int joinMember(MemberDto dto)
 	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		String sql ="INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)" + 
				"     VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , SYSDATE, ?)";
		
		try {
			
			conn = getConnection(); // 2. 드라이버 설정
			pstmt = conn.prepareStatement(sql); // 3. 객체값 확인
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setTimestamp(9, dto.getBirth());
			pstmt.setString	  (10, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 : " + dto.toString());// toString으로 회원가입 실패요소 확인
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
	
	
	
//-- 3. 로그인 (id/pw) : public int loginCheck(String id, String pw)
//SELECT ID, PW FROM MEMBER WHERE ID='aaa';
 	
 	public int loginCheck(String id, String pw) {
 		int result = LOGIN_FAIL_ID; // 아이디 오류
 		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		ResultSet			rs	  = null;
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID = ? ";
		try {
			conn = getConnection(); // 2
			pstmt = conn.prepareStatement(sql); // 3
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // 4 5
			if (rs.next()) { // 유효한 아이디 
				String pwDB = rs.getString("pw");
				if (pwDB.equals(pw)) {
					result = LOGIN_SUCCESS;
				} else {
					result = LOGIN_FAIL_PW;
				}
				
			} else { // 유효하지 않은 아이디
				result = LOGIN_FAIL_ID;
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
		return result;
 	}
 	
 	
//-- 4. ID로 dto 가져오기 : public MemberDto getMember(String id)
//SELECT * FROM MEMBER WHERE ID='aaa';
 	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		ResultSet			rs	  = null;
		String sql ="SELECT * FROM MEMBER WHERE ID = ? ";
		try {
			conn = getConnection(); // 2
			pstmt = conn.prepareStatement(sql); // 3
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // 4 5
			if (rs.next()) {
				String pw	  = rs.getString("pw")	;
				String name   = rs.getString("name")	;
				String phone1 = rs.getString("phone1")	;
				String phone2 = rs.getString("phone2")	;
				String phone3 = rs.getString("phone3")	;
				String gender = rs.getString("gender")	;
				String email  = rs.getString("email")	;
				Timestamp birth = rs.getTimestamp("birth")	;
				Date	  rdate = rs.getDate("rdate")	;
				String    address = rs.getString("address")	;
				dto = new MemberDto(id, pw, name, phone1, phone2, 
								phone3, gender, email, birth, rdate, address);			
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

 	//-- 5. 회원정보 수정	
    public int modifyMember (MemberDto dto) {
    	int result = FAIL;
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		String sql ="UPDATE MEMBER SET PW=  ? , " + 
				"                  NAME =   ? , " + 
				"                  phone1 = ? ," + 
				"                  phone2 = ? ," + 
				"                  phone3 = ? ," + 
				"                  GENDER = ? ," + 
				"                  EMAIL  = ? ," + 
				"                  BIRTH  = ? ," + 
				"                  address = ?  " + 
				"                  WHERE ID = ? ";
		
		try {
			
			conn = getConnection(); // 2. 드라이버 설정
			pstmt = conn.prepareStatement(sql); // 3. 객체값 확인
			
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setTimestamp(8, dto.getBirth());
			pstmt.setString	  (9, dto.getAddress());
			pstmt.setString	  (10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원정보 수정 성공":"회원정보 수정 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정 실패 : " + dto.toString());// toString으로 회원가입 실패요소 확인
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



























































































