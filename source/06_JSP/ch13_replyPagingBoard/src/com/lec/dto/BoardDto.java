package com.lec.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class BoardDto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int readCount;
	private String pw;
	private int ref;
	private int reStep;
	private int reIndent;
	private String ip;
	private Timestamp rdate;
	
	
	
	public BoardDto() {
		super();
	}



	public BoardDto(int num, String writer, String subject, String content, String email, int readCount, String pw,
			int ref, int reStep, int reIndent, String ip, Timestamp rdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.readCount = readCount;
		this.pw = pw;
		this.ref = ref;
		this.reStep = reStep;
		this.reIndent = reIndent;
		this.ip = ip;
		this.rdate = rdate;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getReadCount() {
		return readCount;
	}



	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public int getRef() {
		return ref;
	}



	public void setRef(int ref) {
		this.ref = ref;
	}



	public int getReStep() {
		return reStep;
	}



	public void setReStep(int reStep) {
		this.reStep = reStep;
	}



	public int getReIndent() {
		return reIndent;
	}



	public void setReIndent(int reIndent) {
		this.reIndent = reIndent;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public Timestamp getRdate() {
		return rdate;
	}



	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}



	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", email=" + email + ", readCount=" + readCount + ", pw=" + pw + ", ref=" + ref + ", reStep=" + reStep
				+ ", reIndent=" + reIndent + ", ip=" + ip + ", rdate=" + rdate + "]";
	}

	

	
	

}
