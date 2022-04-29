package com.lec.quiz;



public class StudentMain {
   public static void main(String[] args) {
	  System.out.println();
	  printLine('■');
	  System.out.println("\t\t\t성 적 표");
	  printLine('-');
	  System.out.println("번호\t 이름\t 국어\t 영어 \t수학\t 총점 \t평균");
	  printLine('-');
	  Student s1 = new Student ("이수정", 99, 88, 96);
	  Student s2 = new Student ("유지애", 100, 55, 75);
	  Student s3 = new Student ("서지수", 83, 87, 36);
	  Student s4 = new Student ("이미주", 58, 71, 22);
	  Student s5 = new Student ("김지연", 100, 97, 86);
	  Student [] student = {s1,s2,s3,s4,s5};
	  int [] tot = new int [5];
	  double [] avg = new double [5];
	  for(Student s : student) {
		  s.print(); // 여기서 Student s1~s5 값의 모든 변수를 출력 
		  tot[0] += s.getKor()	; // 여기서 국어 점수를 총합
		  tot[1] += s.getEng()	; // 여기서 영어 점수를 총합
		  tot[2] += s.getMath()	; // 여기서 수학 점수를 총합
		  tot[3] += s.getTot()	; // 여기서 학생의 총 점수를 총합
		  tot[4] += s.getAvg()	; // 여기서 평균 점수를 총합
	  }
	  for(int idx=0; idx<avg.length; idx++) {
		  //avg[idx] = (double)tot[idx]/student.length; // 버림
		  avg[idx] = (int)tot[idx]/(double)student.length+0.5; // 반올림
		  //avg[idx] = (int)Math.round((int)tot[idx]/(double)student.length); // round를 이용한 반올림
		              // 여기서 총합의 값 (double)tot[idx] 을 학생 수 student.length 로 나누어서 평균을 도출
	  }
	  printLine('-');
	  System.out.print("총점 \t\t");
	  for (int t : tot) {
		  //System.out.print(t+"\t");
		  System.out.printf("%5d\t",t); //오른쪽으로 들여쓰기
	  }
	  System.out.println();
	  System.out.print("평균\t\t");
	  for (double a : avg) {
		  //System.out.print(a+"\t");
		  System.out.printf("%5.1f\t",a); //오른쪽으로 들여쓰기
	  }
	  System.out.println();
	  printLine('■');
	  
  }
  private static void printLine(char c) {
	  System.out.println();
	  for(int i=0 ; i<54 ; i++) {
		  System.out.print(c);
	  }
	  System.out.println();
  }
}
