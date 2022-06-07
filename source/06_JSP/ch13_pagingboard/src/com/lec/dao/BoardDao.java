package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤
	private static BoardDao instance = new BoardDao();// 내 자신을 참조하는 함수
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	private BoardDao() {}
	// Connection 객체를 받아오는 getConnection()
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		//
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return conn;
	}
	
	// 1. 글 갯수 		: public int getBoardTotalCnt()
	
	// 2. 글 목록 		: public ArrayList<BoardDto> listBoard()
	
	// 3. 원 글쓰기 	: public int insertBoard(BoardDto dto) 
	
	// 4. 글 번호로 한줄 가져오기 	: public BoardDto getBoardOneLine(int num)
	
	// 4. 글 번호로 한줄 가져오기 	: public BoardDto getBoardOneLine(String num)
	
	// 5. 조회수 올리기 			: public void readcountUp(int num)
	
	// 5. 조회수 올리기 			: public void readcountUp(String num)
	
	// 6. 글 수정하기			: public int updateBoard(Board dto)
	
	// 7. 글 삭제하기			: public int deleteBoard(int num, string pw)
	
	
	// 1. 글 갯수 		:
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*)\"COUNT\" FROM BOARD";
		try {
			conn 	= getConnection();
			pstmt 	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1);
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
		return totalCnt;
	}
	
	// 2. 글 목록 	(페이징으로 수정 페이지 수 10 블록수 10)	: 
	public ArrayList<BoardDto> listBoard() {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD ORDER BY REF DESC";
		try {
			conn 	= getConnection();
			pstmt 	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer 	= rs.getString("writer");
				String subject 	= rs.getString("subject");
				String content 	= rs.getString("content");
				String email 	= rs.getString("email");
				int readCount 	= rs.getInt("readCount");
				String pw		= rs.getString("pw");
				int ref 		= rs.getInt("ref");
				int reStep 		= rs.getInt("re_Step");
				int reIndent 	= rs.getInt("re_Indent");
				System.out.println(1);
				String ip 			= rs.getString("ip");
				System.out.println(2);
				Timestamp rdate = rs.getTimestamp("rdate");
				System.out.println(3);
				dtos.add(new BoardDto(num, writer, subject, content, email, readCount, pw, ref, reStep, reIndent, ip, rdate));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+ "11");
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()+ "22");
			}
			
		}
		return dtos;
	}
		
	// 3. 원 글쓰기 	: 
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		//
		Connection conn = null;
		PreparedStatement pstmt	= null;
		String sql = "INSERT INTO BOARD  (NUM, WRITER, SUBJECT, CONTENT,  EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) "  
				+ " VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, ?, "
				+ " ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD)),0 ,0 ,? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			result = pstmt.executeUpdate();
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
		
	// 4. 글 번호로 한줄 가져오기 	: 
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		try {
			conn 	= getConnection();
			pstmt 	= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs		= pstmt.executeQuery();
			if (rs.next()) {
				String writer 	= rs.getString("writer");
				String subject 	= rs.getString("subject");
				String content 	= rs.getString("content");
				String email 	= rs.getString("email");
				int readCount 	= rs.getInt("readCount");
				String pw		= rs.getString("pw");
				int ref 		= rs.getInt("ref");
				int reStep 		= rs.getInt("re_Step");
				int reIndent 	= rs.getInt("re_Indent");
				String ip 		= rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new BoardDto(num, writer, subject, content, email, readCount, pw, ref, reStep, reIndent, ip, rdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+ "11");
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()+ "22");
			}
			
		}
		return dto;
	}
		
	// 4. 글 번호로 한줄 가져오기 	: public BoardDto getBoardOneLine(String num)
	public BoardDto getBoardOneLine(String num) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		try {
			conn 	= getConnection();
			pstmt 	= conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs		= pstmt.executeQuery();
			if (rs.next()) {
				String writer 	= rs.getString("writer");
				String subject 	= rs.getString("subject");
				String content 	= rs.getString("content");
				String email 	= rs.getString("email");
				int readCount 	= rs.getInt("readCount");
				String pw		= rs.getString("pw");
				int ref 		= rs.getInt("ref");
				int reStep 		= rs.getInt("re_Step");
				int reIndent 	= rs.getInt("re_Indent");
				String ip 		= rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new BoardDto(Integer.parseInt(num), writer, subject, content, email, readCount, pw, ref, reStep, reIndent, ip, rdate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+ "11");
		} finally {
			try {
				if(rs!=null) 	rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) 	conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()+ "22");
			}
			
		}
		return dto;
	}	
	// 5. 조회수 올리기 			: 
	public void readcountUp(int num) {
		Connection conn = null;
		PreparedStatement pstmt	= null;
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
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
	}
		
	// 5. 조회수 올리기 			: 
	public void readcountUp(String num) {
		Connection conn = null;
		PreparedStatement pstmt	= null;
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
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
	}
		
	// 6. 글 수정하기			: 
	public int updateBoard(BoardDto dto) {
		int result =FAIL;
		Connection conn = null;
		PreparedStatement pstmt	= null;
		String sql =  "UPDATE BOARD SET SUBJECT = ?,  " + 
				"                CONTENT = ?, " + 
				"                EMAIL = ?, " + 
				"                PW = ?, " + 
				"                IP = ? " + 
				"             WHERE NUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent()); 
			pstmt.setString(3, dto.getEmail()); 
			pstmt.setString(4, dto.getPw()); 
			pstmt.setString(5, dto.getIp()); 
			pstmt.setInt(6, dto.getNum()); 
			result = pstmt.executeUpdate();
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
		
	// 7. 글 삭제하기			: 
	public int deleteBoard(int num, String pw) {
		int result =FAIL;
		Connection conn = null;
		PreparedStatement pstmt	= null;
		String sql =  "DELETE FROM BOARD WHERE NUM = ? AND PW = ? " ; 
				 
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate();
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


// 9. 글목록 페이징

public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
	ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
	Connection 		  conn = null;
	PreparedStatement pstmt	= null;
	ResultSet 		  rs = null;
	String sql = "SELECT * FROM(SELECT ROWNUM RN, A.* " + 
			"        FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A) " + 
			"          WHERE RN BETWEEN ? AND ?";
	try {
		conn 	= getConnection();
		pstmt 	= conn.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs		= pstmt.executeQuery();
		while (rs.next()) {
			int num = rs.getInt("num");
			String writer 	= rs.getString("writer");
			String subject 	= rs.getString("subject");
			String content 	= rs.getString("content");
			String email 	= rs.getString("email");
			int readCount 	= rs.getInt("readCount");
			String pw		= rs.getString("pw");
			int ref 		= rs.getInt("ref");
			int reStep 		= rs.getInt("re_Step");
			int reIndent 	= rs.getInt("re_Indent");
			System.out.println(1);
			String ip 			= rs.getString("ip");
			System.out.println(2);
			Timestamp rdate = rs.getTimestamp("rdate");
			System.out.println(3);
			dtos.add(new BoardDto(num, writer, subject, content, email, readCount, pw, ref, reStep, reIndent, ip, rdate));
		}
	} catch (Exception e) {
		System.out.println(e.getMessage()+ "11");
	} finally {
		try {
			if(rs!=null) 	rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) 	conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage()+ "22");
		}
		
	}
	return dtos;
 }

}
































