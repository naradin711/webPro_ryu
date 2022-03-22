package com.lec.quiz01_institute;
//subject / print() 재정의
public class Teacher extends Person {
   private String subject;
   private static int count = 0;
   public Teacher (String id, String name, String subject) {
	  super(id, name);
	  this.subject = subject;
	  no = "lec"+(++count);
   }
    @Override
	public void print() {
		  System.out.println("(번호)"+no+"   (ID) "+getId()+" (이름) "+getName()+" (과목) "+subject);
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
