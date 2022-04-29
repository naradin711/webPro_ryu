package com.lec.ex5_PersonInfo;
//데이터 name, age, gender 메소드 print()
public class PersonInfo {
   private String name;
   private int age ;
   private String gender;
   public PersonInfo() {}
public PersonInfo(String name, int age, String gender) {
	this.name = name;
	this.age = age;
	this.gender = gender;
    }
public void print() {
	System.out.printf("귀하의 이름은 %s이며 \n나이는 %d세이고 \n성별은 %s입니다 \n", name, age, gender);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}   

}
