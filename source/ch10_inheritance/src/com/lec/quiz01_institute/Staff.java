package com.lec.quiz01_institute;
//ban / print() ������
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
		  System.out.println("(��ȣ)"+no+" (ID) "+getId()+" (�̸�) "+getName()+" (�μ�) "+department);
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
