package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.lec.dto.MemberDto;

public class MemberDao {
		public static final int SUCCESS = 1; // 회원가입 성공
		public static final int FAIL = 0;	// 회원가입 실패
		public static final int MEMBER_NONEXISTENT = 1; // 중복아이디 없음
		public static final int MEMBER_EXISTENT = 0;	// 중복아이디 있음
		public static final int LOGIN_SUCCESS = 1;
		public static final int LOGIN_FAIL = 0;
		private DataSource ds;
		
		private static MemberDao instance;
		public static MemberDao getInstance () {
			if (instance == null) {
				instance = new MemberDao();
			}
			return instance;
		}
		private MemberDao () {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
//      1. 로그인 SELECT * FROM mvcmember WHERE MID='aaa' AND MPW='111';
		public int loginCheck(String mid, String mpw) {
			int result = LOGIN_FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet		  rs	= null;
			String sql = "SELECT * FROM member WHERE MID= ? AND MPW= ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				pstmt.setString(2, mpw);
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

		
//		2. 회원가입 아이디 중복체크
//		SELECT * FROM mvcmember WHERE MID='aaa';
		public int confirmMid(String mid) {
			int result = MEMBER_EXISTENT;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet		  rs	= null;
 			String sql = "SELECT * FROM member WHERE MID= ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = MEMBER_EXISTENT;
				} else {
					result = MEMBER_NONEXISTENT;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + "idConfirm");
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
	// 2 - 1 . 회원가입 이메일 중복체크
//		SELECT * FROM mvcmember WHERE MEMAIL='aaa';
		public int confirmMemail(String memail) {
			int result = MEMBER_EXISTENT;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet		  rs	= null;
 			String sql = "SELECT * FROM member WHERE MEMAIL = ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memail);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = MEMBER_EXISTENT;
				} else {
					result = MEMBER_NONEXISTENT;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + "emailConfirm");
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

//		3. 회원가입
//		INSERT INTO mvcmember (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
//		       VALUES ('fff', '111', '금길동', 'hong5@hong.com', null, '1982/11/01', '서울시 은평구', SYSDATE);
		public int joinMember(MemberDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)" + 
					" VALUES (? , ? , ? , ? , ? , ? , ? , SYSDATE)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getMid());
				pstmt.setString(2, dto.getMpw());
				pstmt.setString(3, dto.getMname());
				pstmt.setString(4, dto.getMemail());
				pstmt.setString(5, dto.getMphoto());
				pstmt.setDate	(6, dto.getMbirth());
				pstmt.setString	(7, dto.getMaddress());
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "join error");
			}
			return result;
		}
		

//		4. 회원 수 세보기
//		SELECT COUNT(*) CNT FROM mvcmember;
		public int getMemberCnt() {
			int totCnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet		  rs	= null;
			String sql = "SELECT COUNT(*) CNT FROM member";
			try {
				conn = ds.getConnection();
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
		
//		5. 회원목록 전체보기 (페이징 3 블록사이즈 5)
//		SELECT * FROM 
//		        (SELECT ROWNUM RN, A.* FROM 
//		        (SELECT * FROM mvcmember ORDER BY MRDATE DESC)A )
//		         WHERE RN BETWEEN 1 AND 9;
		public ArrayList<MemberDto> listMember(int startRow, int endRow){
			ArrayList<MemberDto> members = new ArrayList<MemberDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet			rs  = null;
			String sql = "SELECT * FROM " + 
					" (SELECT ROWNUM RN, A.* FROM  " + 
					" (SELECT * FROM member ORDER BY MRDATE DESC) A ) " + 
					"  WHERE RN BETWEEN ? AND ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					 String mid 	 = rs.getString("mid");       
					 String mpw 	 = rs.getString("mpw");      
					 String mname 	 = rs.getString("mname");   
					 String memail	 = rs.getString("memail");    
					 String mphoto   = rs.getString("mphoto");
					 Date mbirth     = rs.getDate("mbirth");
					 String maddress = rs.getString("maddress");
					 members.add(new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress));
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
//
//
//		6. 회원정보 상세보기 (MID로 DTO 불러오기)
//		SELECT * FROM member WHERE MID='aaa'; 
		public MemberDto memberView(String mid){
			MemberDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet			rs  = null;
			String sql = "SELECT * FROM member WHERE MID= ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					 String mpw 	 = rs.getString("mpw");      
					 String mname 	 = rs.getString("mname");   
					 String memail	 = rs.getString("memail");    
					 String mphoto   = rs.getString("mphoto");
					 Date mbirth     = rs.getDate("mbirth");
					 String maddress = rs.getString("maddress");  
					 Date mrdate     = rs.getDate("mrdate");
					 dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
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
			
			return dto;
		}
//		7. 회원정보 수정하기
//		UPDATE mvcmember SET MNAME  = '신길동',
//		                     MPW    = '111',
//		                     MEMAIL = 'hong111@hong.com',
//		                     MPHOTO = NULL,
//		                     MBIRTH = '1990-07-08',
//		                     MADDRESS = '서울시 중랑구'
//		                     WHERE MID = 'aaa';

		public int modify (MemberDto member) {
			int result = FAIL;
			Connection 		   conn = null;
			PreparedStatement pstmt = null; 
			String sql = "UPDATE member SET MNAME    = ? , " + 
					" 		                MPW    = ? , " + 
					" 	                    MEMAIL = ? , " + 
					" 		                MPHOTO = ? , " + 
					" 		                MBIRTH = ? , " + 
					" 	                    MADDRESS = ? " + 
					" 		                WHERE MID = ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString (1, member.getMname());
				pstmt.setString (2, member.getMpw());
				pstmt.setString (3, member.getMemail());
				pstmt.setString (4, member.getMphoto());
				pstmt.setDate   (5, member.getMbirth());
				pstmt.setString (6, member.getMaddress());
				pstmt.setString (7, member.getMid());
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "회원 정보 수정 성공" : "회원 정보 수정 실패");
			
			} catch (Exception e) {
				System.out.println(e.getMessage()+"Dao Modify Error");
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
}
