package com.lec.TodayQuiz;

public class Member {
   private String name;
   private String pNo;
   private String address;
   
   public Member() { }
   public Member(String name, String pNo, String address) {
	  this.name = name;
	  this.pNo = pNo;
	  this.address = address;
   }
   @Override
    public String toString() {
	  return  name + " " + pNo + " " + address ;
   }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getpNo() {
	return pNo;
}
public void setpNo(String pNo) {
	this.pNo = pNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
   
   
   
}
