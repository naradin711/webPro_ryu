package com.lec.ex04_object;

public class Ex05_Point3D_TestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		p1.setX(10); p1.setY(9); p1.setZ(7.2);
		Point3D p2 = (Point3D) p1.clone();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.equals(p2)? "���� ��ǥ" : "�ٸ� ��ǥ");
        System.out.println(p1==p2 ? "���� �ؽ��ּ�" : "�ٸ� �ؽ��ּ�");
        if(p1!=p2 && p1.equals(p2)) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
		}
	}

}
