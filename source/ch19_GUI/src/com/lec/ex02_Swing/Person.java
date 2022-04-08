package com.lec.ex02_Swing;

public class Person {
   private String name;
   private String tel;
   private int age;  
   public Person() {}
   public Person(String name, String tel, int age) { 
	  this.name = name;
	  this.tel = tel;
	  this.age = age;
   }
 @Override
   public String toString() {
	  return "이 름: " + name + "\t전화: " + tel + "\t나이: " + age + "\n\n";
   }
   public String getName() {
	   return name;
   }
   public void setName(String name) {
	   this.name = name;
   }
   public String getTel() {
	   return tel;
   }
   public void setTel(String tel) {
	   this.tel = tel;
   }
   public int getAge() {
	   return age;
   }
   public void setAge(int age) {
	   this.age = age;
   }
        
 
 
 
    
   
   
}
