package com.lec.dto;

import java.sql.Date;

public class FileBoardDto {
	private int fid;
	private String mid;       
	private String ftitle;      
    private String fcontent;    
    private String ffilename;    
    private Date frdate;
    private int fhit;
    private int fgroup;
    private int fstep;
    private int findent;
    private String fip;
    private String mname;
    
    
    
	public FileBoardDto() { }

	

	public FileBoardDto(String mid, String ftitle, String fcontent, String ffilename, int fgroup, int fstep,
			int findent, String fip) {
		this.mid = mid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fgroup = fgroup;
		this.fstep = fstep;
		this.findent = findent;
		this.fip = fip;
	}



	public FileBoardDto(String ftitle, String fcontent, String ffilename, String fip, int fid) {
		
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fip = fip;
		this.fid = fid;
	}
public FileBoardDto(String mid, String ftitle, String fcontent, String ffilename, String fip) {
		

		this.mid = mid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fip = fip;
	}



	public FileBoardDto(int fid, String mid, String ftitle, String fcontent, String ffilename, Date frdate, int fhit,
			int fgroup, int fstep, int findent, String fip) {
		super();
		this.fid = fid;
		this.mid = mid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.frdate = frdate;
		this.fhit = fhit;
		this.fgroup = fgroup;
		this.fstep = fstep;
		this.findent = findent;
		this.fip = fip;
	}
	
	



	public FileBoardDto(int fid, String mid, String ftitle, String fcontent, String ffilename, Date frdate, int fhit,
			int fgroup, int fstep, int findent, String fip, String mname) {
		super();
		this.fid = fid;
		this.mid = mid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.frdate = frdate;
		this.fhit = fhit;
		this.fgroup = fgroup;
		this.fstep = fstep;
		this.findent = findent;
		this.fip = fip;
		this.mname = mname;
	}



	public int getFid() {
		return fid;
	}



	public void setFid(int fid) {
		this.fid = fid;
	}



	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}



	public String getFtitle() {
		return ftitle;
	}



	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}



	public String getFcontent() {
		return fcontent;
	}



	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}



	public String getFfilename() {
		return ffilename;
	}



	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}



	public Date getFrdate() {
		return frdate;
	}



	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}



	public int getFhit() {
		return fhit;
	}



	public void setFhit(int fhit) {
		this.fhit = fhit;
	}



	public int getFgroup() {
		return fgroup;
	}



	public void setFgroup(int fgroup) {
		this.fgroup = fgroup;
	}



	public int getFstep() {
		return fstep;
	}



	public void setFstep(int fstep) {
		this.fstep = fstep;
	}



	public int getFindent() {
		return findent;
	}



	public void setFindent(int findent) {
		this.findent = findent;
	}



	public String getFip() {
		return fip;
	}



	public void setFip(String fip) {
		this.fip = fip;
	}

	


	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	@Override
	public String toString() {
		return "FileBoardDto [fid=" + fid + ", mid=" + mid + ", ftitle=" + ftitle + ", fcontent=" + fcontent
				+ ", ffilename=" + ffilename + ", frdate=" + frdate + ", fhit=" + fhit + ", fgroup=" + fgroup
				+ ", fstep=" + fstep + ", findent=" + findent + ", fip=" + fip + "]";
	} 
	
	
	
	
    
}
