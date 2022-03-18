package com.lec.quiz;
// Student.java ++> ex1_student, quiz 패키지
// 다른 패키지의 동일명의 클래스를 동시에 사용해보자.
import com.lec.ex01_Student.Student;
public class Test {
   public static void main(String[] args) {
	  Student s1 = new Student("홍", 55,66,85);
	  s1.print();
	  com.lec.quiz.Student s8 = new com.lec.quiz.Student("홍8", 89,99,41);
	  s8.print();
}
}
