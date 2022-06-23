package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
		public static final int SUCCESS = 1; //  성공
		public static final int FAIL = 0;	//  실패
		private DataSource ds;
		
		private static FileBoardDao instance;
		public static FileBoardDao getInstance () {
			if (instance == null) {
				instance = new FileBoardDao();
			}
			return instance;
		}
		private FileBoardDao () {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		// 1. 글 출력 (int startRow, int endRow)
		/*
		 * SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT F.*, MNAME FROM fileboard
		 * F, MEMBER M WHERE F.MID = M.MID ORDER BY FGROUP DESC, FSTEP)A ) WHERE RN
		 * BETWEEN 1 AND 11;
		 */
		public ArrayList<FileBoardDto> listFileBoard(int startRow, int endRow){
			ArrayList<FileBoardDto> fileboards = new ArrayList<FileBoardDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet			rs  = null;
			String sql = "SELECT * FROM " + 
					" (SELECT ROWNUM RN, A.* FROM  " + 
					" (SELECT F.*, MNAME FROM fileboard F, MEMBER M " + 
					"		 WHERE F.MID = M.MID ORDER BY FGROUP DESC, FSTEP) A ) " + 
					"  WHERE RN BETWEEN ? AND ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int fid 		= rs.getInt("fid");
					String mid 		= rs.getString("mid");      
					String ftitle 	= rs.getString("ftitle");      
				    String fcontent = rs.getString("fcontent");    
				    String ffilename = rs.getString("ffilename");   
				    Date frdate 	= rs.getDate("frdate");
				    int fhit 		= rs.getInt("fhit");
				    int fgroup 		= rs.getInt("fgroup");
				    int fstep 		= rs.getInt("fstep");
				    int findent 	= rs.getInt("findent");
				    String fip 		= rs.getString("fip");
				    String mname	= rs.getString("mname");
					fileboards.add(new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mname)); 
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
			
			return fileboards;
		}
		
		// 2. 글 갯수 세기 - SELECT COUNT(*)CNT FROM FILEBOARD;
		public int getFileBoardCnt() {
			int totCnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet		  rs	= null;
			String sql = "SELECT COUNT(*) CNT FROM FILEBOARD ";
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
		// 3. 글 작성하기. (원글)
		/*
		 * INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME, FGROUP, FSTEP,
		 * FINDENT, FIP) VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','title','content',null,
		 * FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.10.151')
		 */
		public int insertFileBoard(FileBoardDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, " +
							" FFILENAME, FGROUP, FSTEP, FINDENT, FIP)" + 
							" VALUES (FILEBOARD_SEQ.NEXTVAL, ? ,? , ? , ? , " + 
					"		FILEBOARD_SEQ.CURRVAL, 0, 0, ? ) ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getMid());
				pstmt.setString(2, dto.getFtitle());
				pstmt.setString(3, dto.getFcontent());
				pstmt.setString(4, dto.getFfilename());
				pstmt.setString(5, dto.getFip());
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "글 작성 성공":"글 작성 실패");
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "insert board error");
			}
			return result;
		}
		// 3 - 1 강제 집어넣기
		public int writeFileBoard(String mid, String ftitle, String fcontent, String ffilename, String fip) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, " +
							" FFILENAME, FGROUP, FSTEP, FINDENT, FIP)" + 
							" VALUES (FILEBOARD_SEQ.NEXTVAL, ? ,? , ? , ? , " + 
					"		FILEBOARD_SEQ.CURRVAL, 0, 0, ? ) ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				pstmt.setString(2, ftitle);
				pstmt.setString(3, fcontent);
				pstmt.setString(4, ffilename);
				pstmt.setString(5, fip);
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "글 작성 성공":"글 작성 실패");
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "write error");
			}
			return result;
		}
		
		// 4. 조회수 올리기  UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=1
		public int insertFfit(int fid) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID= ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt (1, fid);
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "조회수 올리기 성공":"조회수 올리기  실패");
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "hitup error");
			}
			return result;
		}
		
		// 5. 글 상세보기  fId로 글 dto보기 (글쓴이 이름 추가)
		// SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE M.MID=F.MID AND FID= ? 
		public FileBoardDto FileBoardView(int fid){
			FileBoardDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet			rs  = null;
			String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE M.MID=F.MID AND FID= ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt (1, fid);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String mid 		= rs.getString("mid");      
					String ftitle 	= rs.getString("ftitle");      
				    String fcontent = rs.getString("fcontent");    
				    String ffilename = rs.getString("ffilename");   
				    Date frdate 	= rs.getDate("frdate");
				    int fhit 		= rs.getInt("fhit");
				    int fgroup 		= rs.getInt("fgroup");
				    int fstep 		= rs.getInt("fstep");
				    int findent 	= rs.getInt("findent");
				    String fip 		= rs.getString("fip");
				    String mname	= rs.getString("mname");
					dto = new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mname) ;
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
		
		// 6. 글 수정 (fid, ftitle, FContent, FILENAME,  FIp, FDATE)
		

		public int modifyFileBoard (FileBoardDto fileboard) {
			int result = FAIL;
			Connection 		   conn = null;
			PreparedStatement pstmt = null; 
			String sql = "UPDATE FILEBOARD SET FTITLE = ? , "
											+ "FCONTENT = ? , "
											+ "fFILENAME = ? , "
											+ "FIP = ? , "
											+ " FRDATE = SYSDATE "
											+ " WHERE FID = ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString (1, fileboard.getFtitle());
				pstmt.setString (2, fileboard.getFcontent());
				pstmt.setString (3, fileboard.getFfilename());
				pstmt.setString (4, fileboard.getFip());
				pstmt.setInt 	(5, fileboard.getFid());
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "글 수정 성공" : "글 수정 실패");
			
			} catch (Exception e) {
				System.out.println(e.getMessage()+"FileBoard Modify Error");
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
		// 7. 글 삭제하기 (String FID)
		// DELETE FROM FILEBOARD WHERE FID= ? ;
		public int deleteFileBoard (int fid) {
			int result = FAIL;
			Connection 		   conn = null;
			PreparedStatement pstmt = null; 
			String sql = " DELETE FROM FILEBOARD WHERE FID= ? ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt (1, fid);
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "글 삭제 성공" : "글 삭제 실패");
			
			} catch (Exception e) {
				System.out.println(e.getMessage()+"FileBoard Delete Error");
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
		// 8. 답변글 추가전 STEP a 수행 
		//UPDATE FILEBOARD SET FSTEP = FSTEP+1 
		//	    WHERE FGROUP = ? AND FSTEP>0
		
		public void preReplyStep(int fgroup, int fstep) {
			Connection 		    conn  = null;
			PreparedStatement 	pstmt = null; 
			String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+1  " + 
					"				    WHERE FGROUP = ? AND FSTEP > ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fgroup);
				pstmt.setInt(2, fstep);
				pstmt.executeUpdate();			 
			} catch (Exception e) {
				System.out.println(e.getMessage() + "step error");
			} finally {
				try { 
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage() + "step error");
				}
			}
		}
		
		// 9. 답변글 쓰기
//		INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,
//		        FGROUP, FSTEP, FINDENT, FIP)
//		    VALUES (FILEBOARD_SEQ.NEXTVAL, ? , ? , ? ,  ? ,
//		        ? , ? , ? , ? )
		public int replyFileBoard (FileBoardDto fileboard) {
			// fref, frestep, frelevel : 원글의 정보
			// cid, fsubject, fcontent, ffilename, fpw, fip : 답변글의 정보 
			preReplyStep(fileboard.getFgroup(), fileboard.getFstep() ); // 지금 있는 원 글의 답변 값을 받음 
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, " + 
					"	                         FGROUP, FSTEP, FINDENT, FIP) " + 
					"    		VALUES (FILEBOARD_SEQ.NEXTVAL, ? , ? , ? , ? , " + 
					"	        							   ? , ? , ? , ? ) ";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString	(1, fileboard.getMid());
				pstmt.setString	(2, fileboard.getFtitle());
				pstmt.setString	(3, fileboard.getFcontent());
				pstmt.setString	(4, fileboard.getFfilename());
				pstmt.setInt	(5, fileboard.getFgroup()); // 원글의 group은 그대로
				pstmt.setInt	(6, fileboard.getFstep()+1); // 원글 보다 하나더 답글하기
				pstmt.setInt	(7, fileboard.getFindent()+1); // 원글 보다 하나더 들여쓰기
				pstmt.setString	(8, fileboard.getFip());
				result = pstmt.executeUpdate();
				System.out.println(result==SUCCESS? "답글 쓰기 성공":"답글 쓰기 실패");
			} catch (Exception e) {
				fileboard.setFstep(fileboard.getFstep()+1);
				fileboard.setFindent(fileboard.getFindent()+1);
				System.out.println(e.getMessage()+fileboard);
				
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














