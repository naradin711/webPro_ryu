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

import com.lec.dto.BoardDto; 

public class BoardDao {
	public static final int SUCCESS = 1; // 회원가입 성공
	public static final int FAIL = 0;	// 회원가입 실패
	private DataSource ds;
	
	//싱글톤
	private static BoardDao instance;
	public static BoardDao getInstance(){
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	private BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}
	//-- 글목록 (startRow endRow) 
	// ;
	public ArrayList<BoardDto> listBoard (int startRow, int endRow){
			ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
			Connection 		   conn = null;
			PreparedStatement pstmt = null;
			ResultSet			rs  = null;
			String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* "
					        + "    FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A ) "
					        + "    WHERE RN BETWEEN ? AND ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int 	bid 	= rs.getInt("bid");      
				    String  bname 	= rs.getString("bname"); 
				    String  btitle	= rs.getString("btitle");  
				    String  bcontent= rs.getString("bcontent"); 
				    Date    bdate 	= rs.getDate("bdate");            
				    int 	bhit 	= rs.getInt("bhit"); 
				    int 	bgroup 	= rs.getInt("bgroup");   
				    int 	bstep 	= rs.getInt("bstep"); 
				    int 	bindent = rs.getInt("bindent");  
				    String  bip		= rs.getString("bip");
				    dtos.add(new BoardDto(bid, bname, btitle, bcontent, 
				    		bdate, bhit, bgroup, bstep, bindent, bip));
					 
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + "list");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return dtos;
	}
	
	//-- 전체 글 갯수 ;
	public int getTotalCnt() {
		int totalCnt = 0;
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet			rs  = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			rs.next();  
			totalCnt = rs.getInt("CNT"); 
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
		return totalCnt;
	}
	
	//  -- 글쓰기  
	
	public int write(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection 		   conn = null;
		PreparedStatement pstmt = null; 
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP ) " + 
				" VALUES (BOARD_SEQ.NEXTVAL, ?, ? , ? , BOARD_SEQ.CURRVAL, 0, 0, ? )";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
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
	
	//	-- BID로 조회수 올리기  ;
	private void hitUp (int bid) {
		Connection 		   conn = null;
		PreparedStatement pstmt = null; 
		String sql = "UPDATE BOARD SET BHIT=BHIT+1 WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();			 
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
	}
 
	//	-- 글 상세보기 (BID로 DTO가져오기) ;
	public BoardDto contentView(int bid) {
		BoardDto dto = null; 
		hitUp(bid); //글 상세보기시 자동적으로 조회수 올라감
		Connection 		   conn = null;
		PreparedStatement pstmt = null;
		ResultSet			rs  = null;
		String sql = "SELECT * FROM BOARD WHERE BID = ? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery(); 
			if (rs.next()){     
			    String  bname 	= rs.getString("bname") ;     
			    String  btitle	= rs.getString("btitle") ;  
			    String  bcontent= rs.getString("bcontent") ;
			    Date    bdate 	= rs.getDate("bdate");            
			    int 	bhit 	= rs.getInt("bhit");      
			    int 	bgroup 	= rs.getInt("bgroup");   
			    int 	bstep 	= rs.getInt("bstep");   
			    int 	bindent = rs.getInt("bindent");  
			    String  bip		= rs.getString("bname");
			    dto = new BoardDto(bid, bname, btitle, bcontent, 
			    		bdate, bhit, bgroup, bstep, bindent, bip);
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
	// bid로 dto가져오기=수정하기 + 답변글쓰기(form, 조회수 올리기 미포함)
		public BoardDto modifyView_replyView(int bid) {
			BoardDto dto = null;
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM BOARD WHERE BID = ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					//int    bid     = rs.getInt("bid");
					String bname   = rs.getString("bname");
					String btitle  = rs.getString("btitle");
					String bcontent= rs.getString("bcontent");
					Date   bdate   = rs.getDate("bdate");
					int    bhit    = rs.getInt("bhit");
					int    bgroup  = rs.getInt("bgroup");
					int    bstep   = rs.getInt("bstep");
					int    bindent = rs.getInt("bindent");
					String bip     = rs.getString("bip");
					dto = new BoardDto(bid, bname, btitle, bcontent, 
							bdate, bhit, bgroup, bstep, bindent, bip);
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs   !=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return dto;
		}
 	//  -- 답변글 쓰기전 스텝 
	private void preReplyStep(int bgroup, int bstep) {
		Connection 		    conn  = null;
		PreparedStatement 	pstmt = null; 
		String sql = "UPDATE BOARD SET BSTEP = BSTEP+1 WHERE BGROUP = ? AND BSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();			 
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
	}
 
	//	-- 답변글 쓰기
	//  -- 답변자 : String bname, String btitle, String bcontent, String bip
	//  -- 원글    : bgroup, bstep, bindent
	//	
	public int reply (String bname, String btitle, String bcontent, String bip, 
			          int bgroup, int bstep, int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		Connection 		   conn = null;
		PreparedStatement pstmt = null; 
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP ) " + 
				"	 VALUES (BOARD_SEQ.NEXTVAL, ? , ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString (1, bname);
			pstmt.setString (2, btitle);
			pstmt.setString (3, bcontent);
			pstmt.setInt	(4, bgroup);
			pstmt.setInt	(5, bstep+1);
			pstmt.setInt	(6, bindent+1);
			pstmt.setString (7, bip);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "답변글 성공" : "답변글 실패");
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
	
	
	//	-- 글 수정
	//	;
	public int modify (String bname, String btitle, String bcontent, String bip, int bid) {
			int result = FAIL;
				 
			Connection 		   conn = null;
			PreparedStatement pstmt = null; 
			String sql = "UPDATE BOARD SET BNAME = ? , " + 
					"	 	                 BTITLE = ? , " + 
					"	 	                 BCONTENT = ? , " + 
					"	 	                 BIP =  ? " + 
					"	 	                 WHERE BID = ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString (1, bname);
				pstmt.setString (2, btitle);
				pstmt.setString (3, bcontent);
				pstmt.setString (4, bip);
				pstmt.setInt	(5, bid);
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "수정 성공" : "수정 실패");
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
	
	//	-- 글 삭제
	//	;
	public int delete (int bid) {
		int result = FAIL;
		Connection 		   conn = null;
		PreparedStatement pstmt = null; 
		String sql = "DELETE FROM BOARD WHERE BID = ? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt	(1, bid);
			
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "삭제 성공" : "삭제 실패");
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
	
}







































