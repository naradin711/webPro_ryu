import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer01dao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;
    private static Customer01dao INSTANCE = new Customer01dao();
    public static Customer01dao getInstance() {
    	return INSTANCE;	
    }
	public Customer01dao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("001  "+ e.getMessage());
		}
	}
	
	// 1. 회원가입
	int joinIn (String pno, String cname) {
		int result = FAIL;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "INSERT INTO CUSTOMER01 (PNO, CNAME) VALUES ( ? , ? )";
	
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, pno);
        	pstmt.setString(2, cname);
        	result = pstmt.executeUpdate();
    	} catch (SQLException e) {
			System.out.println("002  "+ e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
	    		System.out.println("003"+ e.getMessage());
	    	} 
		}	
    	return result;
	}
	
	//2. 전화번호 끝자리 혹은 전체자리 번호 검색
	public ArrayList<Customer01dto> pnoSearch(String pno){
    	ArrayList<Customer01dto> dtos = new ArrayList<Customer01dto>();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT PNO, CNAME, CPOINT "
    			+ "FROM CUSTOMER01 WHERE PNO LIKE ('%'|| ? )";
	
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, pno);
        	rs = pstmt.executeQuery();
        	while (rs.next()) { 
        		pno = rs.getString("PNO");
        		String cname = rs.getString("CNAME");
        		int cpoint = rs.getInt("CPOINT");
        		dtos.add(new Customer01dto(pno, cname, cpoint));
        	}
    			} catch (SQLException e) {
    				System.out.println("004"+ e.getMessage());
    			} finally {
    					try {
    						if(rs!=null) rs.close();
    						if(pstmt!=null) pstmt.close();
    						if(conn!=null) conn.close();
    						} catch(SQLException e) {
    							System.out.println("005"+ e.getMessage());
    						}
    			} 
    			return dtos;
		}
	
	
	// 3. 가입된 고객 전체 출력 
	public ArrayList<Customer01dto> getCustomers(){
    	ArrayList<Customer01dto> dtos = new ArrayList<Customer01dto>();
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT * FROM CUSTOMER01 ORDER BY CPOINT DESC";
    			try { 
    	        	conn = DriverManager.getConnection(url, "scott", "tiger");
    	        	stmt = conn.createStatement();
    	        	rs = stmt.executeQuery(sql);
    	        	while(rs.next()) {		
    	        		String	pno = rs.getString("PNO");
    	        		String	cname = rs.getString("CNAME");    		
    	        		int cpoint = rs.getInt("CPOINT");
    	        		dtos.add(new Customer01dto(pno, cname, cpoint));
    	        		}       	
    	        		} catch(SQLException e) {
    	        		System.out.println("006"+ e.getMessage());
    	        		} finally {
    	        			try {
    	        				if(rs!=null) rs.close();
    	        				if(stmt!=null) stmt.close();
    	        				if(conn!=null) conn.close();
    	        			} catch(SQLException e) {
    	        				System.out.println("007"+ e.getMessage());
    	        			} 
    	        	} 	return dtos;	      
			}
    
} // class
	































