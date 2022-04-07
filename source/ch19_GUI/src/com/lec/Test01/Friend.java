package com.lec.Test01;
//name, phone, address, birthday
public class Friend {
	private String name;
	private String phone;
	private String address;
	private String birthday;
	public Friend() {}
	public Friend(String name, String address, String phone,  String birthday) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "이 름 : " + name +  "\n주소 :" + address + "\n핸드폰 : " + phone +  "\n생일 : " + birthday;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	

}
