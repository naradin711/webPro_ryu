package com.lec.ex04_object;

public class Ex04_RectangleTestMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle();
		r1.setHeight(10); r1.setWidth(5);
		Rectangle r2 = (Rectangle) r1.clone();
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r1.equals(r2)? "���� �簢��":"�ٸ� �簢��");
		System.out.println(r1==r2? "���� �ּҸ� ����Ŵ" : "�ٸ� �ּҸ� ����Ŵ");
		if(r1!=r2 && r1.equals(r2)) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
		}
	}

}
