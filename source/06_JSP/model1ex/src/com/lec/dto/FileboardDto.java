package com.lec.dto;

import java.sql.Date;

public class FileboardDto {
		private int 	fnum;      
		private String 	cid;
		private String 	fsubject;
		private String 	fcontent;
		private String 	ffilename;
		private String 	fpw;
		private int 	fhit;
		private int 	fref;
		private int 	frestep;
		private int 	frelevel;
		private String 	fip;
		private Date 	frdate;
		private String 	cname;
		private String 	cemail;
		
		public FileboardDto() { }
		
		

		public FileboardDto(int fnum, String cid, String fsubject, String fcontent, 
				String ffilename, String fpw, int fhit, int fref, int frestep, 
				int frelevel, String fip, Date frdate) {
			 
			this.fnum = fnum;
			this.cid = cid;
			this.fsubject = fsubject;
			this.fcontent = fcontent;
			this.ffilename = ffilename;
			this.fpw = fpw;
			this.fhit = fhit;
			this.fref = fref;
			this.frestep = frestep;
			this.frelevel = frelevel;
			this.fip = fip;
			this.frdate = frdate;
		}

		

		public FileboardDto(int fnum, String fsubject, String fcontent, String ffilename, String fpw, String fip) {
			super();
			this.fnum = fnum;
			this.fsubject = fsubject;
			this.fcontent = fcontent;
			this.ffilename = ffilename;
			this.fpw = fpw;
			this.fip = fip;
		}



		public FileboardDto(int fnum, String cid, String fsubject, String fcontent, 
				String ffilename, String fpw, int fhit, int fref, int frestep, 
				int frelevel, String fip, Date frdate, String cname, String cemail) {
			 
			this.fnum = fnum;
			this.cid = cid;
			this.fsubject = fsubject;
			this.fcontent = fcontent;
			this.ffilename = ffilename;
			this.fpw = fpw;
			this.fhit = fhit;
			this.fref = fref;
			this.frestep = frestep;
			this.frelevel = frelevel;
			this.fip = fip;
			this.frdate = frdate;
			this.cname = cname;
			this.cemail = cemail;
		}

		public int getFnum() {
			return fnum;
		}


		public void setFnum(int fnum) {
			this.fnum = fnum;
		}



		public String getCid() {
			return cid;
		}



		public void setCid(String cid) {
			this.cid = cid;
		}



		public String getFsubject() {
			return fsubject;
		}



		public void setFsubject(String fsubject) {
			this.fsubject = fsubject;
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



		public String getFpw() {
			return fpw;
		}



		public void setFpw(String fpw) {
			this.fpw = fpw;
		}



		public int getFhit() {
			return fhit;
		}



		public void setFhit(int fhit) {
			this.fhit = fhit;
		}



		public int getFref() {
			return fref;
		}



		public void setFref(int fref) {
			this.fref = fref;
		}



		public int getFrestep() {
			return frestep;
		}



		public void setFrestep(int frestep) {
			this.frestep = frestep;
		}



		public int getFrelevel() {
			return frelevel;
		}



		public void setFrelevel(int frelevel) {
			this.frelevel = frelevel;
		}



		public String getFip() {
			return fip;
		}



		public void setFip(String fip) {
			this.fip = fip;
		}



		public Date getFrdate() {
			return frdate;
		}



		public void setFrdate(Date frdate) {
			this.frdate = frdate;
		}
		
		


		public String getCname() {
			return cname;
		}



		public void setCname(String cname) {
			this.cname = cname;
		}



		public String getCemail() {
			return cemail;
		}



		public void setCemail(String cemail) {
			this.cemail = cemail;
		}



		@Override
		public String toString() {
			return "FileboardDto [fnum=" + fnum + ", cid=" + cid + ", fsubject=" + fsubject + ", 					fcontent=" + fcontent + ", ffilename=" + ffilename + ", fpw=" + fpw + 
					", fhit=" + fhit + ", fref=" + fref + ", frestep=" + frestep + ", frelevel=" + 					frelevel + ", fip=" + fip + ", frdate=" + frdate + ", cname=" + cname
					+ ", cemail=" + cemail + "]";
		}
		
		
		
		
	
}
























