package com.lec.ex5_PersonInfo;
//������ name, age, gender �޼ҵ� print()
public class PersonInfo_array {
	public static void main(String[] args) {
	   int[] arr = new int [2];
	   PersonInfo[] person = new PersonInfo[2];
	   person[0] = new PersonInfo("ȫ�浿", 20, "����");
	   person[1] = new PersonInfo("ȫ��", 22, "����");
	   for(int idx=0 ; idx<person.length; idx++) {
		   person[idx].print();
	   }
	   for(PersonInfo p : person) {
		   p.print();
	   }
	}
}