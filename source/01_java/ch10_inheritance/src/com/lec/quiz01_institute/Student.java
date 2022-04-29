package com.lec.quiz01_institute;
//ban / print() 재정의
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
		  System.out.println("(번호)"+no+"  (ID) "+getId()+" (이름) "+getName()+" (반)   "+ban);
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
