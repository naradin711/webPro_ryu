package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("���� "+ sum);
		System.out.println(i==j ? "�� ������ ����":"�� ������ �ٸ���.");
		Integer iObj = new Integer(10);
		Integer jObj = new Integer(10);
		sum = iObj.intValue() + jObj.intValue();
		System.out.println("���� "+ sum);
		System.out.println(iObj.equals(j)? "����." : "�ٸ���.");
		System.out.println(iObj == jObj? "�ּҰ� ����." : "�ּҰ� �ٸ���.");
		
	    }

}
