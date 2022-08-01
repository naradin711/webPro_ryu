package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.CustDto;
import com.lec.dto.MoneyDto;

public class MoneyDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static MoneyDao instance;
	public static MoneyDao getInstance() {
		if(instance == null) {
			instance = new MoneyDao();
		}
		return instance;
	}
	private MoneyDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null; 
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return conn;
	}
	public ArrayList<MoneyDto> listMoney (){
		ArrayList<MoneyDto> moneys = new ArrayList<MoneyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select pcode, sum(price) sp from money group by pcode order by pcode";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {  
				String pcode	= rs.getString("pcode");      
				int sp 	= rs.getInt("sp"); 
			    moneys.add(new MoneyDto(pcode, sp));
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
		
		return moneys;
	}
}
