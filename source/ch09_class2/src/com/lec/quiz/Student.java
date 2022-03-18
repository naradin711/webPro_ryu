package com.lec.quiz;

public class Student {
	private String name ;
	private int kor ;
	private int eng ;
	private int math ;
	private int tot ;
	private double avg;
	private int stuNo; // 객체고유의 번호 101, 102, ad24353 .......
	public static int count = 0; 
	   //객체가 만들어질 때 맨 처음 클래스에 데이터가 잡힌다.
	public Student () {} // 디폴트 생성자 = 혹시 모를 충돌을 방지.
	public Student (String name, int kor, int eng, int math) {  
	    this.name = name;
	    this.kor = kor;
	    this.eng = eng;
	    this.math = math;
	    tot = kor + eng + math;
	    avg = tot/3.0;
		stuNo = ++count;  // 여기서 고유번호 serialNo가 공유변수의 영향을 받음.
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
