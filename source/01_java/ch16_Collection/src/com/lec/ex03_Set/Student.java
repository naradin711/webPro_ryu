package com.lec.ex03_Set;

public class Student {
   private int grade;
   private String name;
   public Student(int grade, String name) {
	  this.grade = grade;
	  this.name = name;
   }
   @Override
   public String toString() {
	  return grade + "학년\t" + name ;
   }//toString
   @Override
	public boolean equals(Object obj) {
	    if (obj!=null && obj instanceof Student) {
//	    	boolean gradeCk = grade == ((Student)obj).grade;
//	    	boolean nameCk = name.equals(((Student)obj).name);
//	    	return gradeCk && nameCk;
	    	return toString().equals(obj.toString());
	    }
		return false;
	}
   //equals 와 hashcode Override
   @Override
	public int hashCode() {
		return toString().hashCode();  // toString값이 같으면 해쉬코드 값을 같게 함!
	}

}


























