package com.lec.test01;

public class Person {
	private String name;
	private String phoneNo;
	public Person (String name, String phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}
	public String toString () {
		return "�̸�  "+name+", ��ȭ��ȣ "+phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
