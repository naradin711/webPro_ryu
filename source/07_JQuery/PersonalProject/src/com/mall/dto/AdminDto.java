package com.mall.dto;

public class AdminDto {
		private String aid;       
		private String apw ;      
	    private String aname;
	    
	    
	    
		public AdminDto() {
			super();
		}



		public AdminDto(String aid, String apw, String aname) {
			
			this.aid = aid;
			this.apw = apw;
			this.aname = aname;
		}
		
		public AdminDto(String aid) {
			
			this.aid = aid;
		}




		public String getAid() {
			return aid;
		}



		public void setAid(String aid) {
			this.aid = aid;
		}



		public String getApw() {
			return apw;
		}



		public void setApw(String apw) {
			this.apw = apw;
		}



		public String getAname() {
			return aname;
		}



		public void setAname(String aname) {
			this.aname = aname;
		}

}
