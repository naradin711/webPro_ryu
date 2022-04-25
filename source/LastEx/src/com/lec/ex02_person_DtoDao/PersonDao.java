package com.lec.ex02_person_DtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//입력, 직업별 조회, 전체조회, 직업리스트,종료
public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public static int SUCCESS = 1;
    public static int FAIL = 0;
    private static PersonDao INSTANCE;
    public static PersonDao getInstance() {
    	if(INSTANCE == null) {
    		INSTANCE =new PersonDao();
    	}
    	return INSTANCE;
    };
	private PersonDao() {	
		try {
			Class.forName(driver); //1단계는 생성자에서 한번
		} catch (ClassNotFoundException e) {
			System.out.println("A  "+e.getMessage());
		}
	}
	// 1번 기능 입력 (매개변수 dto, return SUCCESS or FAIL)
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// dto안의 값을 DB에 insert!(2~7단계를 모두 넣는다)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES " + 
				"   (PERSON_SEQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME  = ?) , ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {			
			try {				 
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}	
		return result;
	}
	// 2번 기능 직업별 조회(매개변수 jname, return PersonDto arrayList)
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  ROWNUM, A.* " + 
		 		"    FROM (SELECT PNAME , JNAME, KOR , ENG , MAT , (KOR+ENG+MAT)SUM FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = ?" + 
		 		"     ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("ROWNUM");
				String pname = rs.getString("PNAME");
				int kor= rs.getInt("KOR");
				int eng= rs.getInt("ENG");
				int mat= rs.getInt("MAT");
				int sum= rs.getInt("SUM");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
		
	}
	// 3번 기능 전체 조회 (return ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectAll(){
		// 전체조회 결과를 dtos에 add (2~7단계)
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement           stmt  = null; // SQL 전송 객체 변수 3번
		ResultSet             rs  = null;
		String sql = "SELECT  ROWNUM, A.* " + 
		 		"    FROM (SELECT PNAME , JNAME, KOR , ENG , MAT , (KOR+ENG+MAT)SUM FROM PERSON P, JOB J WHERE P.JNO = J.JNO " + 
		 		"     ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRank(rs.getInt("ROWNUM"));
				dto.setPname(rs.getString("PNAME")); 
				dto.setJname(rs.getString("JNAME")); 
				dto.setKor(rs.getInt("KOR")); 
				dto.setEng(rs.getInt("ENG")); 
				dto.setMat(rs.getInt("MAT")); 
				dto.setSum(rs.getInt("SUM")); 		
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}			
		}
		return dtos;
		
	}
	// 4번 기능 직업 리스트 조회 ()
	public Vector<String> jnamelist(){
		Vector<String> jnames = new Vector<String>();
		Connection conn = null;
		Statement  stmt  = null; // SQL 전송 객체 변수 3번
		ResultSet  rs  = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement(); // 3.  Statement 전송 객체 생성
			rs   = stmt.executeQuery(sql);
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {			
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}	
		}		
		return jnames;		
	}
}
