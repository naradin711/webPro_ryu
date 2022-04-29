package com.lec.ex5_PersonInfo;
//데이터 name, age, gender 메소드 print()
public class PersonInfo_array {
	public static void main(String[] args) {
	   int[] arr = new int [2];
	   PersonInfo[] person = new PersonInfo[2];
	   person[0] = new PersonInfo("홍길동", 20, "남성");
	   person[1] = new PersonInfo("홍순", 22, "여성");
	   for(int idx=0 ; idx<person.length; idx++) {
		   person[idx].print();
	   }
	   for(PersonInfo p : person) {
		   p.print();
	   }
	}
}