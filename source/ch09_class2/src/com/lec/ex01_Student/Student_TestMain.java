package com.lec.ex01_Student;

public class Student_TestMain {
   public static void main(String[] args) {
	  printLine('��', 30);
	  System.out.println("                     ����ǥ");
	  printLine(30);
	  System.out.println("�̸�    ����  ����  ����    ����   ���");
	  Student s1 = new Student("������", 34, 55, 99);
	  Student s2 = new Student("�̼���", 77, 88, 79);
	  Student s3 = new Student("������", 32, 14, 56);
	  Student s4 = new Student("�ڸ���", 99, 84, 68);
	  Student s5 = new Student("�̹���", 10, 23, 33);
	  printLine(30);
	  printLine('��', 30);	
}
private static void printLine(char c, int cnt) {
	  for(int i=0 ; i<cnt ; i++) {
		  System.out.print(c);
	  }
	  System.out.println();
   }
   private static void printLine(int cnt) {
		  for(int i=0 ; i<cnt ; i++) {
			  System.out.print('-');
		  }
		  System.out.println();
	   }
   private static void printLine(char c) {
		  for(int i=0 ; i<50 ; i++) {
			  System.out.print(c);
		  }
		  System.out.println();
	   }
   private static void printLine() {
		  for(int i=0 ; i<30 ; i++) {
			  System.out.print('-');
		  }
		  System.out.println();
	   }
}
