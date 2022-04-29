package com.lec.quiz01_institute;
//ban / print() 재정의
public class Staff extends Person{
   private String department;
   private static int count = 0;
   public Staff (String id, String name, String department) {
	  super(id, name);
	  this.department = department;
	  no = "staff"+(++count);
   }
    @Override
	public void print() {
		  System.out.println("(번호)"+no+" (ID) "+getId()+" (이름) "+getName()+" (부서) "+department);
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
