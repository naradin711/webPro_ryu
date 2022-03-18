package com.lec.ex01_Student;

public class Student_TestMain2 {
   public static void main(String[] args) {
	  printLine('��', 30);
	  System.out.println("                     ����ǥ");
	  System.out.print("�̸�\t����\t����\t����\t����\t���\n\n");
	  printLine(30);
	  Student s1 = new Student("������", 34, 55, 99);
	  Student s2 = new Student("�̼���", 77, 88, 79);
	  Student s3 = new Student("������", 32, 14, 56);
	  Student s4 = new Student("�ڸ���", 99, 84, 68);
	  Student s5 = new Student("�̹���", 10, 23, 33);
	  Student [] student = {s1,s2,s3,s4,s5};
	  int [] sum = new int [5]; // tot[0] ����� tot[1] �����.... tot[4] ��� ����
	  double [] avg = new double [5]; // ��� ���� avg[0] ���� ��ü ��� .... avg[4] ��� ���
	  printLine(30);
	  for(Student s : student) {
		  s.print();
		  sum[0] += s.getKor();
		  sum[1] += s.getEng();
		  sum[2] += s.getMath();
		  sum[3] += s.getSum();
		  sum[4] += s.getAvg();
 	  }
	  for(int idx=0; idx<avg.length ;idx++) {
		  avg[idx] = (double)sum[idx]/student.length;
	  }
	  printLine(30);
	  System.out.print("����\t");
	  for (int s : sum) {
		  System.out.print(s + "\t");
	  }
	  System.out.println();
	  System.out.print("���\t");
	  for (double a : avg) {
		  System.out.print(a + "\t");
	  }
	  System.out.println();
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
