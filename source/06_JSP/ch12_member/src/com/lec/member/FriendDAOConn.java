package com.lec.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FriendDAOConn {
	public static final int SUCCESS = 1; //회원가입, 정보수정 시 성공
	public static final int FAIL 	= 0; //회원가입, 정보수정 시 실패
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 아이디일 때
	public static final int MEMBER_EXISTENT    = 0; // 중복된 아이디일 때
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시 리턴값
	public static final int LOGIN_FAIL_ID = -1; // // 로그인시 ID오류일때 리턴값
	public static final int LOGIN_FAIL_PW = 0;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("커넥션풀 이름 오류 : "+ e.getMessage());
			
		}
		return conn;
		
	}
	private String driver	= "oracle.jdbc.driver.OracleDriver";
	private String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
	// -- 1. 친구 추가 할 쿼리
	public int joinFriend(FriendDTO dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO FRIEND (NUM, NAME, PHONE) " + 
				"    VALUES (FRIEND_SEQ.nextval, ? , ? )";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "친구추가성공":"친구추가실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("친구추가 실패 : " + dto.toString());// toString으로 회원가입 실패요소 확인
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
	}
	//-- 2. 친구 리스트 뽑기.
	public ArrayList<FriendDTO> getList() {
		ArrayList<FriendDTO> dtos = new ArrayList<FriendDTO>();
		FriendDTO dto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				dtos.add(new FriendDTO(num, name, phone));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(stmt!=null) 	stmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
		
	}
	//-- 2-1. 이름으로 친구 리스트 뽑기.
	public ArrayList<FriendDTO> search(String name, String phone) {
		ArrayList<FriendDTO> dtos = new ArrayList<FriendDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%' || ? || '%' AND PHONE LIKE '%'|| ? || '%' ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				name = rs.getString("name");
				phone = rs.getString("phone");
				dtos.add(new FriendDTO(num, name, phone));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("검색실패22" + dtos.toString());
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("검색실패11");
			}
		}
		return dtos;	
	}
}








