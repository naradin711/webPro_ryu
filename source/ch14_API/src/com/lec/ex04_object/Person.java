package com.lec.ex04_object;
// 9512122105252
public class Person {
   private long juminNO;
   public Person(long juminNO) {
	 this.juminNO = juminNO;
   }
   @Override
   public String toString() {
	   return "Person [juminNO=" + juminNO + "]";
  }  
  public boolean equals(Object obj) {
	  if(obj !=null && obj instanceof Person) {// obj가 Person 타입의 객체
		  return juminNO == ((Person)obj).juminNO;
	  }else {
		  return false;
	  }
  }
}
