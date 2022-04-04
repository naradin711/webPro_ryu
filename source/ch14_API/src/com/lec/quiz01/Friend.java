package com.lec.quiz01;

public class Friend {
   private String name;
   private String phone;
   private String bday;
   public Friend() {}
   public Friend (String name, String phone, String bday) {
	   this.name=name;
	   this.phone=phone;
	   this.bday=bday;
   }
   public String toString () {
	   return "이 름 : "+name+"\n전화번호 : "+phone+"\n생 일 : "+bday;
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
   public String getBday() {
	 return bday;
   }
   public void setBday(String bday) {
	  this.bday = bday;
   }
}
