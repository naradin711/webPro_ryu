package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.lec.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1; // 회원가입 성공
	public static final int FAIL = 0;	// 회원가입 실패
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_ID = 0;
	public static final int LOGIN_FAIL_PW = -1;
	
	//싱글톤
	private static MemberDao instance;
	public static MemberDao getInstance(){
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	private MemberDao() {}
	
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
	// 회원가입
	public int joinMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, BIRTH, RDATE)  " + 
					"   VALUES ( ? , ? , ? , ?, SYSDATE )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString		(1, member.getId());
			pstmt.setString		(2, member.getPw());
			pstmt.setString		(3, member.getName());
			pstmt.setTimestamp	(4, member.getBirth());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
	// 회원리스트
	public ArrayList<MemberDto> listMember() {
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet			rs  = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id 		= rs.getString("id");
				String pw 		= rs.getString("pw");
				String name 	= rs.getString("name");
				Timestamp birth = rs.getTimestamp("birth");
				Date rdate 		= rs.getDate("rdate");
				members.add(new MemberDto(id, pw, name, birth, rdate));
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
		
		return members;
	}
}
