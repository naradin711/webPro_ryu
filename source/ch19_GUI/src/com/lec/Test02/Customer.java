package com.lec.Test02;
// �̸�, ��ȭ��ȣ, �ּ�
public class Customer {
   private String name;
   private String phone;
   private String address;
   
   public Customer() {}
   public Customer(String name, String phone, String address) {
	  this.name = name;
	  this.phone = phone;
	  this.address = address;
   }
  @Override
    public String toString() {
	   return name + "  " + phone + "  " + address +"\n";
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

   
   
}
