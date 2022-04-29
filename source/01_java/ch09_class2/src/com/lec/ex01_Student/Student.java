package com.lec.ex01_Student;

public class Student {
   private String name;
   private int kor;
   private int eng;
   private int math;
   private int sum;
   private double avg;
   public Student() {}
public Student(String name, int kor, int eng, int math) {
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
	sum = kor + eng + math;
	avg = sum/3.0;
//	System.out.printf("%s  %d  %d  %d  %d  %.1f\n\n", name, kor, eng, math, sum, avg);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}
public double getAvg() {
	return avg;
}
public void setAvg(double avg) {
	this.avg = avg;
}
public void print() {
	System.out.printf("%s %d %d %d %d %.1f\n\n", name, kor, eng, math, sum, avg);
	
}

}
