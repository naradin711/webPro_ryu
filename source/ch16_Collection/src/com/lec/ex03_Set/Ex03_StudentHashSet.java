package com.lec.ex03_Set;
import java.util.*;
public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet <Student> students = new HashSet <Student>();
		Student s = new Student(6, "이순신");
		students.add(s); // 주소가 같음
		students.add(s); // 주소가 같음 = 중복으로 인식
		System.out.println(students);
		students.add(new Student(3, "홍길동"));
		students.add(new Student(3, "홍길동"));//위 홍길동과 아래 홍길동이 다름
		students.add(new Student(6, "이순신"));
		System.out.println(students);
	}

}
