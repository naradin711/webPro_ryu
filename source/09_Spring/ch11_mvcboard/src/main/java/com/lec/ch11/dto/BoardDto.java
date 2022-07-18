package com.lec.ch11.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private Date date ;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	
	
	public BoardDto() {	}
	
	


	public BoardDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, Date date, String bip) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.date = date;
		this.bip = bip;
	}


	public BoardDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, int bhit,
			int bgroup, int bstep, int bindent, String bip) {
		 
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate; 
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.bip = bip;
	}
	


	public BoardDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, Date date, int bhit,
			int bgroup, int bstep, int bindent, String bip) {
		 
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.date = date;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.bip = bip;
	}
	
	
}
