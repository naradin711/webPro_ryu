package com.lec.quiz;

public class Student {
	private String name ;
	private int kor ;
	private int eng ;
	private int math ;
	private int tot ;
	private double avg;
	private int stuNo; // ��ü������ ��ȣ 101, 102, ad24353 .......
	public static int count = 0; 
	   //��ü�� ������� �� �� ó�� Ŭ������ �����Ͱ� ������.
	public Student () {} // ����Ʈ ������ = Ȥ�� �� �浹�� ����.
	public Student (String name, int kor, int eng, int math) {  
	    this.name = name;
	    this.kor = kor;
	    this.eng = eng;
	    this.math = math;
	    tot = kor + eng + math;
	    avg = tot/3.0;
		stuNo = ++count;  // ���⼭ ������ȣ serialNo�� ���������� ������ ����.
	}
	public void print() {
		System.out.printf("%d\t%s\t %d\t %d\t %d\t %d\t %.1f\t\n", stuNo, name, kor, eng, math, tot, avg);
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
