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
import com.lec.dto.FileboardDto;

public class FileboardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0; 
	//싱글톤
	private static FileboardDao instance;
	public static FileboardDao getInstance(){
		if(instance == null) {
			instance = new FileboardDao();
		}
		return instance;
	}
	private FileboardDao() {}
	
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
	// 1. 글 목록
	public ArrayList<FileboardDto> listBoard(int startRow, int endRow){
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = " SELECT * FROM (SELECT ROWNUM RN, A.* " + 
				"               FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C  " + 
				"               WHERE F.CID = C.CID  " + 
				"               ORDER BY FREF DESC, FRESTEP) A ) " + 
				"               WHERE RN BETWEEN ? AND ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int		fnum		= rs.getInt("fnum");
				String 	cid 		= rs.getString("cid");
				String 	fsubject 	= rs.getString("fsubject");
				String 	fcontent 	= rs.getString("fcontent");
				String 	ffilename 	= rs.getString("ffilename"); 
				String 	fpw 		= rs.getString("fpw");
				int		fhit		= rs.getInt("fhit");
				int		fref		= rs.getInt("fref");
				int		frestep		= rs.getInt("frestep");
				int		frelevel	= rs.getInt("frelevel");
				String 	fip 	= rs.getString("fip");
				Date  	frdate 	= rs.getDate("frdate");
				String 	cname 	= rs.getString("cname");
				String 	cemail 	= rs.getString("cemail");			
				dtos.add(new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, frestep, frelevel, fip, frdate, cname, cemail));
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
	
	// 2. 등록된 글 수
	public int getFileBoardCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD ";
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
	// 3. 원글쓰기
	public int insertBoard(FileboardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRESTEP, FRELEVEL, FIP) " + 
				"     VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, " +
				 "            FILEBOARD_SEQ.CURRVAL, 0, 0, ?) ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString	(1, dto.getCid());
			pstmt.setString	(2, dto.getFsubject());
			pstmt.setString	(3, dto.getFcontent());
			pstmt.setString	(4, dto.getFfilename());
			pstmt.setString	(5, dto.getFpw());
			pstmt.setString	(6, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글 쓰기 성공":"글 쓰기 실패");
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
	
	// 4. 답변 글 쓰기전 STEP A
	private void preReplyStepA (int fref, int frestep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FRESTEP = FRESTEP+1 WHERE fREF = ? AND FRESTEP > ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt	(1, fref);
			pstmt.setInt	(2, frestep);
			int result = pstmt.executeUpdate();
			System.out.println(result==0? "처음 답변":result+"행 증가");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {			 
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 5. 답변 글 작성하기
	public int reply(FileboardDto dto) {
		// fref, frestep, frelevel : 원글의 정보
		// cid, fsubject, fcontent, ffilename, fpw, fip : 답변글의 정보 
		preReplyStepA(dto.getFref(), dto.getFrestep()); // 지금 있는 원 글의 답변 값을 받음 
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRESTEP, FRELEVEL, FIP) " + 
				"     VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, " +
				 "            ?, ?, ?, ?) ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString	(1, dto.getCid());
			pstmt.setString	(2, dto.getFsubject());
			pstmt.setString	(3, dto.getFcontent());
			pstmt.setString	(4, dto.getFfilename());
			pstmt.setString	(5, dto.getFpw());
			pstmt.setInt	(6, dto.getFref()); // 원글의 ref 그대로
			pstmt.setInt	(7, dto.getFrestep()+1); // 원글 보다 하나더 
			pstmt.setInt	(8, dto.getFrelevel()+1); // 원글 보다 하나더
			pstmt.setString	(9, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "글 쓰기 성공":"글 쓰기 실패");
		} catch (Exception e) {
			dto.setFrestep(dto.getFrestep()+1);
			dto.setFrelevel(dto.getFrelevel()+1);
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
	// 6. 글 상세보기 (FNUM으로 DTO가져오기)
	public FileboardDto getBoard(int fnum) {
		FileboardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		String sql = " SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C "
				    + " WHERE F.CID=C.CID AND FNUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String 	cid = rs.getString("cid");
				String 	fsubject 	= rs.getString("fsubject");
				String 	fcontent 	= rs.getString("fcontent");
				String 	ffilename 	= rs.getString("ffilename"); 
				String 	fpw 	= rs.getString("fpw");
				int		fhit	= rs.getInt("fhit");
				int		fref	= rs.getInt("fref");
				int		frestep	= rs.getInt("frestep");
				int		frelevel= rs.getInt("frelevel");
				String 	fip = rs.getString("fip");
				Date  	frdate 	= rs.getDate("frdate");
				String 	cname 	= rs.getString("cname");
				String 	cemail 	= rs.getString("cemail");			
				dto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, frestep, frelevel, fip, frdate, cname, cemail);
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
	// 7. 조회 수 올리기
	public void hitUp (int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE fileboard SET fhit = FHIT+1 WHERE FNUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt	(1, fnum);
			int result = pstmt.executeUpdate();
			System.out.println(result!=0? "조회 수 상승": "조회 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {			 
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// 8. 글 수정하기
	public int updateBoard (FileboardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE FILEBOARD SET FSUBJECT = ? , " + 
				"                         	FCONTENT =  ? , " + 
				"                         	FFILENAME =  ? , " + 
				"                         	FPW = ? , " + 
				"                         	FIP = ? " + 
				"                    		WHERE FNUM = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString	(1, dto.getFsubject());
			pstmt.setString	(2, dto.getFcontent());
			pstmt.setString	(3, dto.getFfilename());
			pstmt.setString	(4, dto.getFpw());
			pstmt.setString	(5, dto.getFip());
			pstmt.setInt	(6, dto.getFnum());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "수정 성공":"수정 실패");
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
	
	// 9. 글 삭제하기
	public int deleteBoard (int fnum, String fpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " DELETE FROM FILEBOARD WHERE FNUM = ? AND FPW = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt	(1, fnum);
			pstmt.setString	(2, fpw); 
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "삭제 성공":"삭제 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













