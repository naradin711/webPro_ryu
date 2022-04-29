package com.lec.ex03_Student;

public class StudentDto {
	private int rank;
	private int sno;
	private int mno;
	private String sname;
	private String mname;
	private int score;
	private int expel;
	public StudentDto () {}
	// 입력용 sname, mname, score
	// 출력용 rank, sname, mname, score
	public StudentDto(String sname, String mname, int score ) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
		 
	}
	public StudentDto(int rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentDto(int rank, String sname, int sno, String mname, int mno , int score) {
		super();
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.mno = mno;
		this.score = score;
	}
	public StudentDto(String sname, int sno, String mname, int score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentDto(int sno) {
		super();
		this.sno = sno;
	}
	public StudentDto(int sno, String sname) {
		super();
		this.sno = sno;
		this.sname = sname;
	}
	@Override
	public String toString() {
		if (rank!=0) {
			return  rank + "등\t" + sname+"("+sno+")\t" +mname+"("+mno +")\t"+score;
		}else {
			return  sno+"\t"+sname+"\t"+mname+"\t"+score;	
		}
		
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getExpel() {
		return expel;
	}
	public void setExpel(int expel) {
		this.expel = expel;
	};
	 
}
