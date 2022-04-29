package com.lec.Homework;

public class Member {
	private String name;
	private String phone;
	private String bDay;
	private String address;
	public Member() {}
	public Member(String name, String phone, String bDay, String address) {
		this.name = name;
		this.phone = phone;
		this.bDay = bDay;
		this.address = address;
		if(bDay=="04-06") {
			System.out.println(name + "님 생일축하드립니다.");
		}
	}
	@Override
	public String toString() {
		return  name +"  "+ phone +"  "+ bDay + "생  " + address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getbDay() {
		return bDay;
	}
	public void setbDay(String bDay) {
		this.bDay = bDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getBytes() {
		return null;
	}  
	
	    
     
	
	
	
	
	
	
	
	
	
	
	
	
}
