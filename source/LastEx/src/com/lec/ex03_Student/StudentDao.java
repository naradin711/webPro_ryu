package com.lec.ex03_Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.ex02_person_DtoDao.PersonDto;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public static int SUCCESS = 1;
    public static int FAIL = 0;
    private static StudentDao INSTANCE;
    public static StudentDao getInstance() {
    	if(INSTANCE == null) {
    		INSTANCE =new StudentDao();
    	}
    	return INSTANCE;
    };
    private StudentDao() {
    	try {
			Class.forName(driver);//1단계는 생성자에서 한번
		} catch (ClassNotFoundException e) {
			System.out.println("A  "+e.getMessage());
		} 
    }
    // 1. 학번검색
    public StudentDto snogetStudent(int sno){
    	StudentDto dtos = null;
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE "
				+ " FROM STUDENT S, MAJOR M "
				+ " WHERE S.MNO = M.MNO AND SNO = ? ";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sname = rs.getString("SNAME");
				String mname = rs.getString("MNAME");
				int score = rs.getInt("SCORE");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return dtos;
    } 
    // 2. 이름검색
    public ArrayList<StudentDto> snamegetStudent(String sname){
    	ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();;
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT SNO, SNAME, MNAME, SCORE  " + 
				"  FROM STUDENT S, MAJOR M  " + 
				"  WHERE S.MNO = M.MNO AND SNAME = ? ";
		
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int sno= rs.getInt("SNO");
				String mname = rs.getString("MNAME");
				int score= rs.getInt("SCORE");	
				dtos.add(new StudentDto(sname, sno,  mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}				
    	return dtos;
    }
    // 3. 전공검색 
    public ArrayList<StudentDto> selectMname(String mname){
    	ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
    	Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM , A.* " + 
				"FROM (SELECT SNAME, SNO, MNAME, S.MNO, SCORE " + 
				"FROM MAJOR M, STUDENT S WHERE M.MNO = S.MNO AND MNAME = ? AND S.EXPEL = 0 " + 
				"ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("ROWNUM");
				String sname = rs.getString("SNAME");
				int sno= rs.getInt("SNO");
				int mno= rs.getInt("S.MNO");
				int score= rs.getInt("SCORE");	
				dtos.add(new StudentDto(rank, sname, sno, mname, mno, score));
			}
		} catch (SQLException e) {
			System.out.println("B1  "+ e.getMessage());
		}finally {
			
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println("C1  "+e.getMessage());
			}
		}
		return dtos;
    }
    // 4. 학생입력
    public int insertStudent(StudentDto dto) {
    	int result = FAIL;
    	Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES " + 
				"    (TO_NUMBER(EXTRACT (YEAR FROM SYSDATE), '9999')||TRIM('00'||STU_SEQ.nextval), ?, ?, ?, ?)";	
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getExpel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("B  "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println("C  "+e.getMessage());
			} 
		 }
		return result; 
    }
    //5. 학생 수정
    public int updateStudent(StudentDto dto) {
    	int result = FAIL;
    	Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET  SNAME = ?, (SELECT MNO FROM MAJOR MNAME = ?), SCORE = ?" +
                     " WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("B  "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println("C  "+e.getMessage());
			} 
		 }
		return result; 
    } 
    //6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) 
    public ArrayList<StudentDto> getStudents(){
    	ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT ROWNUM , A.* " + 
				" FROM (SELECT SNAME, SNO, MNAME, S.MNO, SCORE " + 
				" FROM MAJOR M, STUDENT S WHERE M.MNO = S.MNO AND S.EXPEL = 0 " + 
				" ORDER BY SCORE DESC) A ";
    	return null;    	
    }
    
    
}
