package com.lec.ex04_object;
// Staff s1 = new Staff ("a01", "ȫ�浿", "COMPUTER") - ���� �Ի���
// Staff s2 = new Staff ("a02", "�ű浿", "COMPUTER", 2022,3,24) - 3�� 24�� �Ի���
public class Ex01_Staff_TestMain {
	public static void main(String[] args) {
		Staff s1 = new Staff ("a01", "ȫ�浿", Dept.COMPUTER);//���� �Ի���
		Staff s2 = new Staff ("a02", "�ű浿", Dept.HUMANRESOURCE, 2022, 3, 24); // - 3�� 24�� �Ի���
	    System.out.println(s1.toString());	
	    System.out.println(s2.toString());
	    Staff2 s3 = new Staff2 ("c01","���浿", Dept2.COMPUTER);
	    System.out.println(s3.toString());
	}
	
}
