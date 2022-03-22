package com.lec.quiz01_institute;
// no, id, name / print(), getter와 setter
public class Person {
   protected String no;
   private String id;
   private String name;
   private static int count = 0;
   public Person () {}
   public Person (String id, String name) {
	  this.id = id;
	  this.name = name;
	  no = " "+(++count);
   }
   public void print () {
	  System.out.println("(번호) "+no+" (ID) "+id+" (이름) "+name);
   }
   protected String getNo() {
	  return no;
   }
   public void setNo(String no) {
	  this.no = no;
   }
   public String getId() {
	return id;
   }
   public void setId(String id) {
	  this.id = id;
   }
   public String getName() {
	  return name;
   }
   public void setName(String name) {
	  this.name = name;
   }

   
}
