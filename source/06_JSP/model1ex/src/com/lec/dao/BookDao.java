package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.BookDto;

public class BookDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	//싱글톤
	private static BookDao instance;
	public static BookDao getInstance(){
		if(instance == null) {
			instance = new BookDao();
		}
		return instance;
	}
	private BookDao() {}
	
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
	
	// 책등록
	public int insertBook(BookDto book) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) " + 
				 	 " VALUES (BOOK_SEQ.nextval, ? , ? , ? , ? , ? , ? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBtitle());
			pstmt.setInt(2, book.getBprice());
			pstmt.setString(3, book.getBimage1());
			pstmt.setString(4, book.getBimage2());
			pstmt.setString(5, book.getBcontent());
			pstmt.setInt(6, book.getBdiscount());
			result = pstmt.executeUpdate();
			//System.out.println(result==SUCCESS ? "책등록 성공": "책등록 실패");
			System.out.println("책등록 성공");
			
		} catch (Exception e) {
			System.out.println(e.getMessage()+"11");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage()+"22");
			}
		}
		return result;
	}
	
	// 책목록
	public ArrayList<BookDto> listBook (){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM BOOK ORDER BY BRDATE DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid			= rs.getInt("bid");      
				String btitle 	= rs.getString("btitle");
				int bprice		= rs.getInt("bprice");   
				String bimage1 	= rs.getString("bimage1");
				String bimage2 	= rs.getString("bimage2");     
				String bcontent = rs.getString("bcontent"); 
			    int bdiscount	= rs.getInt("bdiscount"); 
			    Date brdate		= rs.getDate("brdate"); 
			    books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
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
		
		return books;
	}
	
	
	// 책목록 탑엔구문
	public ArrayList<BookDto> listBook (int startRow, int endRow){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A) " + 
				"    WHERE RN BETWEEN ? AND ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid			= rs.getInt("bid");      
				String btitle 	= rs.getString("btitle");
				int bprice		= rs.getInt("bprice");   
				String bimage1 	= rs.getString("bimage1");
				String bimage2 	= rs.getString("bimage2");     
				String bcontent = rs.getString("bcontent"); 
			    int bdiscount	= rs.getInt("bdiscount"); 
			    Date brdate		= rs.getDate("brdate"); 
			    books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
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
		
		return books;
	}
	// 등록된 책 갯수
	public int getBookTotCnt() { //SELECT COUNT(*) CNT FROM BOOK;
		int TotCnt = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT COUNT(*) CNT FROM BOOK";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			TotCnt = rs.getInt("cnt"); // 지금 적은 cnt sql문의 주석임
			 
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
		return TotCnt;
	}
	
	// 책 상태보기 (bid로 dto가져오기)
	public BookDto getBook(int bid) {
		BookDto book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM BOOK WHERE BID= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()){   
				String btitle 	= rs.getString("btitle");
				int bprice		= rs.getInt("bprice");   
				String bimage1 	= rs.getString("bimage1");
				String bimage2 	= rs.getString("bimage2");     
				String bcontent = rs.getString("bcontent"); 
			    int bdiscount	= rs.getInt("bdiscount"); 
			    Date brdate		= rs.getDate("brdate"); 
			    book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
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
		return book;
	}

}

















