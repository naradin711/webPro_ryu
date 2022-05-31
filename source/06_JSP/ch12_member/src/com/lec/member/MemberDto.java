package com.lec.member;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String phone1;
	private String phone2;
	private String phone3;
	private String gender;
	private String email;
	private Timestamp birth;
	private Date	  rdate;
	private String    address;
	
	
	public MemberDto() { }


	public MemberDto(String id, String pw, String name, String phone1, String phone2, String phone3, String gender,
			String email, Timestamp birth, Date rdate, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.gender = gender;
		this.email = email;
		this.birth = birth;
		this.rdate = rdate;
		this.address = address;
		
	}

	
	

	@Override
	public String toString() {
		return "아이디" + id + ", 비밀번호 =" + pw + ", 이름 =" + name + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", phone3=" + phone3 + ", 성별 =" + gender + ", email =" + email + ", 생년월일 =" + birth + ", 가입일 ="
				+ rdate + ", 주소 =" + address + "]";
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getPhone3() {
		return phone3;
	}


	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Timestamp getBirth() {
		return birth;
	}


	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}


	public Date getRdate() {
		return rdate;
	}


	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
