package com.lec.quiz01_institute;
//ban / print() ������
public class Student extends Person{
   private String ban;
   private static int count = 100;
   public Student (String id, String name, String ban) {
	  super(id, name);
	  this.ban = ban;
	  no = "st"+(++count);
   }
    @Override
	public void print() {
		  System.out.println("(��ȣ)"+no+"  (ID) "+getId()+" (�̸�) "+getName()+" (��)   "+ban);
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
