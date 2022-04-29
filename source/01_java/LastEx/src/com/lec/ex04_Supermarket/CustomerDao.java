package com.lec.ex04_Supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url	  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;
    private static CustomerDao INSTANCE = new CustomerDao();
    public static CustomerDao getInstance() {
    	return INSTANCE;
    }
    private CustomerDao() {
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("001 "+e.getMessage());
		}   	
    }
    //0. �����̸��� �˻� : Vector<String> getLevelNames();
    public Vector<String> getLevelNames(){
    	Vector <String> levelNames = new Vector <String>();
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
    	try { 
    	conn = DriverManager.getConnection(url, "scott", "tiger");
    	stmt = conn.createStatement();
    	rs = stmt.executeQuery(sql);
    	while(rs.next()) {
    		levelNames.add(rs.getString("LEVELNAME"));
		}
    	} catch(SQLException e) {
    		System.out.println("002"+ e.getMessage());
    	} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
	    		System.out.println("003"+ e.getMessage());
	    	} 
		}   
    	return levelNames;
    }

    //1. ���̵� �˻� (������ level�� ���׷��̵�Ǳ� ���� �� ����)
    //Public CustomerDto cidGetCustomer(int CID);
    public CustomerDto cidGetCustomer(int cid) {
    	CustomerDto dto = null ;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
    			"        (SELECT HIGH-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP " + 
    			"        FROM CUSTOMER C, CUS_LEVEL L " + 
    			"        WHERE C.LEVELNO = L.LEVELNO AND CID = ? ";
    	try { 
        	conn = DriverManager.getConnection(url, "scott", "tiger");
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, cid);
        	rs = pstmt.executeQuery();
        		if(rs.next()) {
        			String ctel = rs.getString("CTEL");
        			String cname = rs.getString("CNAME");
        			String levelName = rs.getString("LEVELNAME");
        			int cpoint = rs.getInt("CPOINT");
        			int camount= rs.getInt("CAMOUNT");
        			int forlevelup = rs.getInt("FORLEVELUP");
        			dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup);
        		}
        	
        	} catch(SQLException e) {
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
    			return dto;
         } 
     
   

    //2. ��4�ڸ�(FULL)�˻� ArrayList<CustomerDao> getCtelSearch
    	 
		public ArrayList<CustomerDto> getCtelSearch(String ctel){
    		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rs = null;
    		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
    			"        (SELECT HIGH-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP " + 
    			"        FROM CUSTOMER C, CUS_LEVEL L " + 
    			"        WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE ('%'|| ? ) " + 
    			"        ORDER BY CAMOUNT DESC";
    			try { 
    	        	conn = DriverManager.getConnection(url, "scott", "tiger");
    	        	pstmt = conn.prepareStatement(sql);
    	        	pstmt.setString(1, ctel);
    	        	rs = pstmt.executeQuery();
    	        	while(rs.next()) {
    	        		int cid = rs.getInt("CID");
    	        			ctel = rs.getString("CTEL");
    	        		String cname = rs.getString("CNAME");
    	        		String levelName = rs.getString("LEVELNAME");
    	        		int cpoint = rs.getInt("CPOINT");
    	        		int camount= rs.getInt("CAMOUNT");
    	        		int forlevelup = rs.getInt("FORLEVELUP");
    	        		dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup));	        
    	        		}
    	        	} catch(SQLException e) {
    	        		System.out.println("006"+ e.getMessage());
    	        	} finally {
    	    			try {
    	    				if(rs!=null) rs.close();
    	    				if(pstmt!=null) pstmt.close();
    	    				if(conn!=null) conn.close();
    	    			} catch(SQLException e) {
    	    	    		System.out.println("007"+ e.getMessage());
    	    			}
    	    		} 
    	    			return dtos;	
    	    		}
    			
          
     

        
    // 3. ���̸� �˻�
    public ArrayList<CustomerDto> getCnameSearch(String cname){
    	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
    			"        (SELECT HIGH-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP " + 
    			"        FROM CUSTOMER C, CUS_LEVEL L " + 
    			"        WHERE C.LEVELNO = L.LEVELNO AND CNAME = ? " + 
    			"        ORDER BY CAMOUNT DESC";
    			try { 
    	        	conn = DriverManager.getConnection(url, "scott", "tiger");
    	        	pstmt = conn.prepareStatement(sql);
    	        	pstmt.setString(1, cname);
    	        	rs = pstmt.executeQuery();
    	        	while(rs.next()) {
    	        		int cid = rs.getInt("CID");
    	        		String	ctel = rs.getString("CTEL");
    	        		String levelName = rs.getString("LEVELNAME");
    	        		int cpoint = rs.getInt("CPOINT");
    	        		int camount= rs.getInt("CAMOUNT");
    	        		int forlevelup = rs.getInt("FORLEVELUP");
    	        		dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup));
    	        		}       	
    	        		} catch(SQLException e) {
    	        		System.out.println("006"+ e.getMessage());
    	        		} finally {
    	        			try {
    	        				if(rs!=null) rs.close();
    	        				if(pstmt!=null) pstmt.close();
    	        				if(conn!=null) conn.close();
    	        			} catch(SQLException e) {
    	        				System.out.println("007"+ e.getMessage());
    	        			}    	    			
    	        		}
    					return dtos;
    				}
    
    // 4. ����Ʈ�θ� ���� int buyWithPoint(int CID, int cpoint)
    public int buyWithPoint(int cid, int camount) { // ���밪�� ����ϴ� ����ǥ�� �������� �ؾ��ϳ�?
    	int result = FAIL;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT- ?  WHERE CID = ?";
    	try { 
        	conn = DriverManager.getConnection(url, "scott", "tiger");
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, camount);
        	pstmt.setInt(2, cid);
        	result = pstmt.executeUpdate();
    		}catch(SQLException e) {
        		System.out.println("008"+ e.getMessage());
        	} finally {
    			try {
    				if(pstmt!=null) pstmt.close();
    				if(conn!=null) conn.close();
    			} catch(SQLException e) {
    	    		System.out.println("009"+ e.getMessage());
    	    	} 
    		} 	
    	   return result;
    	} 
    
    

   //5. ��ǰ���� int buy(int CID, int CAMOUNT)
    //��ǰ���� ������Ʈ���� CPOINT, CAMOUNT, LEVELNO
    //5-4. 5-1�� 5-3�� ���ļ� �ϼ���Ű�� 
    public int buy(int cid, int camount) {
    	int result = FAIL;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT + ( ? *0.05), " + 
    			"                        CAMOUNT = CAMOUNT + ?, " + 
    			"                        LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L " + 
    			"                                WHERE (CAMOUNT+ ?) BETWEEN LOW AND HIGH AND CID=?) " +     			                               
    			"                        WHERE CID = ? ";
    			//CAMOUNT�� ���氪�� �־� ������ â��!
    			try { 
    	        	conn = DriverManager.getConnection(url, "scott", "tiger");
    	        	pstmt = conn.prepareStatement(sql);
    	        	pstmt.setInt(1, camount);
    	        	pstmt.setInt(2, camount);
    	        	pstmt.setInt(3, camount);
    	        	pstmt.setInt(4, cid);
    	        	pstmt.setInt(5, cid);
    	        	result = pstmt.executeUpdate();
    				}catch(SQLException e) {
    	        		System.out.println("008"+ e.getMessage());
    	        	} finally {
    	    			try {
    	    				if(pstmt!=null) pstmt.close();
    	    				if(conn!=null) conn.close();
    	    			} catch(SQLException e) {
    	    	    		System.out.println("009"+ e.getMessage());
    	    	    	} 
    	    		} 	
    			return result;
    }
    	 
        
    //6. ��޺� ��� ArrayList<CustomerDto> levelNameGetCustomer(String levelName);
    public ArrayList<CustomerDto> levelNameGetCustomer(String levelName){
    	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
    			"    (SELECT HIGH-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP " + 
    			"    FROM CUSTOMER C, CUS_LEVEL L " + 
    			"    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME = ? ";
    			try { 
    	        	conn = DriverManager.getConnection(url, "scott", "tiger");
    	        	pstmt = conn.prepareStatement(sql);
    	        	pstmt.setString(1, levelName);
    	        	rs = pstmt.executeQuery();
    	        	while(rs.next()) {
    	        		int cid = rs.getInt("CID");
    	        		String	ctel = rs.getString("CTEL");
    	        		String	cname = rs.getString("CNAME");
    	        		int cpoint = rs.getInt("CPOINT");
    	        		int camount= rs.getInt("CAMOUNT");
    	        		int forlevelup = rs.getInt("FORLEVELUP");
    	        		dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup));
    	        		}       	
    	        		} catch(SQLException e) {
    	        		System.out.println("006"+ e.getMessage());
    	        		} finally {
    	        			try {
    	        				if(rs!=null) rs.close();
    	        				if(pstmt!=null) pstmt.close();
    	        				if(conn!=null) conn.close();
    	        			} catch(SQLException e) {
    	        				System.out.println("007"+ e.getMessage());
    	        			} 
    	    			
    	        } return dtos;		
    }
        
    //7. ��ü ��� Arraylist<CustomerDto> getCustomers();
    public ArrayList<CustomerDto> getCustomers(){
    	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
    			"        (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP " + 
    			"        FROM CUSTOMER C, CUS_LEVEL L " + 
    			"        WHERE C.LEVELNO = L.LEVELNO " + 
    			"        ORDER BY CAMOUNT DESC ";
    			try { 
    	        	conn = DriverManager.getConnection(url, "scott", "tiger");
    	        	stmt = conn.createStatement();
    	        	rs = stmt.executeQuery(sql);
    	        	while(rs.next()) {
    	        		int cid = rs.getInt("CID");
    	        		String	ctel = rs.getString("CTEL");
    	        		String	cname = rs.getString("CNAME");    		
    	        		int cpoint = rs.getInt("CPOINT");
    	        		int camount= rs.getInt("CAMOUNT");
    	        		String	levelName = rs.getString("LEVELNAME");
    	        		int forlevelup = rs.getInt("FORLEVELUP");
    	        		dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup));
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
    


    //8. ȸ������ int insertCustomer (Customer dto) int insertCustomer (String cTel, String cName)
    int insertCustomer (String ctel, String cname) {
    	int result = FAIL;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES " + 
			"                (CUSTOMER_SEQ.NEXTVAL, ? , ? )";
			//CAMOUNT�� ���氪�� �־� ������ â��!
			try { 
	        	conn = DriverManager.getConnection(url, "scott", "tiger");
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, ctel);
	        	pstmt.setString(2, cname);
	        	result = pstmt.executeUpdate();
				}catch(SQLException e) {
	        		System.out.println("008"+ e.getMessage());
	        	} finally {
	    			try {
	    				if(pstmt!=null) pstmt.close();
	    				if(conn!=null) conn.close();
	    			} catch(SQLException e) {
	    	    		System.out.println("009"+ e.getMessage());
	    	    	} 
	    		} 	return result;
    }
    
    


    //9. ��ȣ���� int updateCustomer (int CID, String cName)
    int updateCustomerCtel (int cid, String ctel) {
    	int result = FAIL;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = " UPDATE CUSTOMER SET CTEL = ? WHERE CID= ?";
			
			try { 
	        	conn = DriverManager.getConnection(url, "scott", "tiger");
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, ctel);
	        	pstmt.setInt(2, cid);
	        	result = pstmt.executeUpdate();
				}catch(SQLException e) {
	        		System.out.println("008"+ e.getMessage());
	        	} finally {
	    			try {
	    				if(pstmt!=null) pstmt.close();
	    				if(conn!=null) conn.close();
	    			} catch(SQLException e) {
	    	    		System.out.println("009"+ e.getMessage());
	    	    	} 
	    		} 	return result;
    }
   


    //10. ȸ��Ż�� int deleteCustomer (String cTel)
    public int deleteCustomer (String ctel) {
    	int result = FAIL;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "DELETE CUSTOMER WHERE CTEL = ? ";			
			try { 
	        	conn = DriverManager.getConnection(url, "scott", "tiger");
	        	pstmt = conn.prepareStatement(sql);
	        	pstmt.setString(1, ctel);	
	        	result = pstmt.executeUpdate();
				}catch(SQLException e) {
	        		System.out.println("008"+ e.getMessage());
	        	} finally {
	    			try {
	    				if(pstmt!=null) pstmt.close();
	    				if(conn!=null) conn.close();
	    			} catch(SQLException e) {
	    	    		System.out.println("009"+ e.getMessage());
	    	    	} 
	    		} 	return result;
    }
    

 
    
}//class