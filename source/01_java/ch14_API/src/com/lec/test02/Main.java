package com.lec.test02;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student ("A01", "���л�", "JAVA��");
	    Student s2 = new Student ("A02", "ȫ�浿", "C++��");
	    Staff st1 = new Staff    ("S01", "������", "������");
	    Staff st2 = new Staff    ("S02", "������", "���������");
	    Gangsa lec1 = new Gangsa ("G01", "������", "���α׷���");
	    Person [] pp = {s1, s2, st1, st2, lec1};
	    for (Person p :pp) {
	    	 p.print();
	}
  }
}
