package com.lec.ex01_Student;

public class Student_TestMain2 {
   public static void main(String[] args) {
	  printLine('■', 30);
	  System.out.println("                     성적표");
	  System.out.print("이름\t국어\t영어\t수학\t총점\t평균\n\n");
	  printLine(30);
	  Student s1 = new Student("정예인", 34, 55, 99);
	  Student s2 = new Student("이수정", 77, 88, 79);
	  Student s3 = new Student("서지수", 32, 14, 56);
	  Student s4 = new Student("박명은", 99, 84, 68);
	  Student s5 = new Student("이미주", 10, 23, 33);
	  Student [] student = {s1,s2,s3,s4,s5};
	  int [] sum = new int [5]; // tot[0] 국어누적 tot[1] 영어누적.... tot[4] 평균 누적
	  double [] avg = new double [5]; // 평균 내기 avg[0] 국어 전체 평균 .... avg[4] 평균 평균
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
	  System.out.print("총점\t");
	  for (int s : sum) {
		  System.out.print(s + "\t");
	  }
	  System.out.println();
	  System.out.print("평균\t");
	  for (double a : avg) {
		  System.out.print(a + "\t");
	  }
	  System.out.println();
	  printLine('■', 30);	
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
