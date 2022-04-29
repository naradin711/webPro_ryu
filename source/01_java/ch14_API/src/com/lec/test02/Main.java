package com.lec.test02;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student ("A01", "나학생", "JAVA반");
	    Student s2 = new Student ("A02", "홍길동", "C++반");
	    Staff st1 = new Staff    ("S01", "나직원", "교무팀");
	    Staff st2 = new Staff    ("S02", "나도요", "취업지원팀");
	    Gangsa lec1 = new Gangsa ("G01", "나선생", "프로그래밍");
	    Person [] pp = {s1, s2, st1, st2, lec1};
	    for (Person p :pp) {
	    	 p.print();
	}
  }
}
