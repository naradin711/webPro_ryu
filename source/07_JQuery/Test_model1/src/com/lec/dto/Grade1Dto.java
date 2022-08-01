package com.lec.dto;

public class Grade1Dto {
	private String grade;  
	private String gname;
	
	
	
	public Grade1Dto() { }



	public Grade1Dto(String grade, String gname) { 
		this.grade = grade;
		this.gname = gname;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getGname() {
		return gname;
	}



	public void setGname(String gname) {
		this.gname = gname;
	}



	@Override
	public String toString() {
		return "Grade1Dto [grade=" + grade + ", gname=" + gname + "]";
	}
	
	
	
	
}
