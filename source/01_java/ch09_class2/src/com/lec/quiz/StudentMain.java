package com.lec.quiz;



public class StudentMain {
   public static void main(String[] args) {
	  System.out.println();
	  printLine('��');
	  System.out.println("\t\t\t�� �� ǥ");
	  printLine('-');
	  System.out.println("��ȣ\t �̸�\t ����\t ���� \t����\t ���� \t���");
	  printLine('-');
	  Student s1 = new Student ("�̼���", 99, 88, 96);
	  Student s2 = new Student ("������", 100, 55, 75);
	  Student s3 = new Student ("������", 83, 87, 36);
	  Student s4 = new Student ("�̹���", 58, 71, 22);
	  Student s5 = new Student ("������", 100, 97, 86);
	  Student [] student = {s1,s2,s3,s4,s5};
	  int [] tot = new int [5];
	  double [] avg = new double [5];
	  for(Student s : student) {
		  s.print(); // ���⼭ Student s1~s5 ���� ��� ������ ��� 
		  tot[0] += s.getKor()	; // ���⼭ ���� ������ ����
		  tot[1] += s.getEng()	; // ���⼭ ���� ������ ����
		  tot[2] += s.getMath()	; // ���⼭ ���� ������ ����
		  tot[3] += s.getTot()	; // ���⼭ �л��� �� ������ ����
		  tot[4] += s.getAvg()	; // ���⼭ ��� ������ ����
	  }
	  for(int idx=0; idx<avg.length; idx++) {
		  //avg[idx] = (double)tot[idx]/student.length; // ����
		  avg[idx] = (int)tot[idx]/(double)student.length+0.5; // �ݿø�
		  //avg[idx] = (int)Math.round((int)tot[idx]/(double)student.length); // round�� �̿��� �ݿø�
		              // ���⼭ ������ �� (double)tot[idx] �� �л� �� student.length �� ����� ����� ����
	  }
	  printLine('-');
	  System.out.print("���� \t\t");
	  for (int t : tot) {
		  //System.out.print(t+"\t");
		  System.out.printf("%5d\t",t); //���������� �鿩����
	  }
	  System.out.println();
	  System.out.print("���\t\t");
	  for (double a : avg) {
		  //System.out.print(a+"\t");
		  System.out.printf("%5.1f\t",a); //���������� �鿩����
	  }
	  System.out.println();
	  printLine('��');
	  
  }
  private static void printLine(char c) {
	  System.out.println();
	  for(int i=0 ; i<54 ; i++) {
		  System.out.print(c);
	  }
	  System.out.println();
  }
}
