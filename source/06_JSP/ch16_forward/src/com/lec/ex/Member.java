package com.lec.ex;

import java.sql.Date;

public class Member {
	private String id;
	private String pw;
	private Date   rdate;
	
	public Member(String id, String pw) { 
		this.id = id;
		this.pw = pw;
		rdate = new Date(System.currentTimeMillis()); ;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", rdate=" + rdate + "]";
	}
	
	
}
