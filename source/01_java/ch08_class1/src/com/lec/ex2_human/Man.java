package com.lec.ex2_human;
// Man kim = new Man(22, 160, 50.5, "010-999-9999");
//Man kim = new Man(22, 160, 50.5);
//Man kim = new Man(22);
public class Man {
	private int age;   
	private int height;
	private double weight;
	private String phoneNum;
	public Man() {} // ����Ʈ ������ �Լ�
	public Man(int age) {
		this.age = age;
	}
//	public Man(int height) {
//		this.height = height;
//	}
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("�Ķ���Ͱ� 3��¥�� ������ �Լ� ȣ��");
	}
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��");
	}
	//�޼ҵ�
	public double calculateBMI() { //���۷��� ����.
	   double result = weight / ((height/100.0)*(height/100.0));
	   return result;
	}
	//setter & getter (age, height, weight, phoneNum) m.getAge
	public void setAge(int age) {
	   this.age = age;
	}
	public void setHeight(int height) {
	   this.height = height;
	}
	public void setWeight(double weight) {
	   this.weight = weight;
	}
	public void setPhonenum(String phoneNum) {
	   this.phoneNum = phoneNum;
	}
	public int getAge( ) {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight( ) {
		return weight;
	}
	public String phoneNum( ) {
		return phoneNum;
	}
}
