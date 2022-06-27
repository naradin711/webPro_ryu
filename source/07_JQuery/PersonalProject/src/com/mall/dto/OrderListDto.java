package com.mall.dto;

import java.sql.Date;

public class OrderListDto {
	private int odid;            
	private int cartid;          
	private int cid;               
	private String pname;        
	private String ptype;         
	private String pphoto;        
    private int pprice;           
    private int odcall;  
    private Date oddate;
    
    
    
	public OrderListDto() { 
	}

	

	public OrderListDto(int odid, int cartid, int cid, String pname, String ptype, String pphoto, int pprice,
			int odcall) {
		super();
		this.odid = odid;
		this.cartid = cartid;
		this.cid = cid;
		this.pname = pname;
		this.ptype = ptype;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.odcall = odcall;
	}



	public OrderListDto(int odid, int cartid, int cid, String pname, String ptype, String pphoto, int pprice,
			int odcall, Date oddate) {
		super();
		this.odid = odid;
		this.cartid = cartid;
		this.cid = cid;
		this.pname = pname;
		this.ptype = ptype;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.odcall = odcall;
		this.oddate = oddate;
	}



	public int getOdid() {
		return odid;
	}



	public void setOdid(int odid) {
		this.odid = odid;
	}



	public int getCartid() {
		return cartid;
	}



	public void setCartid(int cartid) {
		this.cartid = cartid;
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public String getPtype() {
		return ptype;
	}



	public void setPtype(String ptype) {
		this.ptype = ptype;
	}



	public String getPphoto() {
		return pphoto;
	}



	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}



	public int getPprice() {
		return pprice;
	}



	public void setPprice(int pprice) {
		this.pprice = pprice;
	}



	public int getOdcall() {
		return odcall;
	}



	public void setOdcall(int odcall) {
		this.odcall = odcall;
	}



	public Date getOddate() {
		return oddate;
	}



	public void setOddate(Date oddate) {
		this.oddate = oddate;
	}



	@Override
	public String toString() {
		return "OrderListDto [odid=" + odid + ", cartid=" + cartid + ", cid=" + cid + ", pname=" + pname + ", ptype="
				+ ptype + ", pphoto=" + pphoto + ", pprice=" + pprice + ", odcall=" + odcall + ", oddate=" + oddate
				+ "]";
	} 
	
	
    
	
    
}
