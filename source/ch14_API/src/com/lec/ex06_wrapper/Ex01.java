package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("합은 "+ sum);
		System.out.println(i==j ? "두 정수는 같다":"두 정수는 다르다.");
		Integer iObj = new Integer(10);
		Integer jObj = new Integer(10);
		sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은 "+ sum);
		System.out.println(iObj.equals(j)? "같다." : "다르다.");
		System.out.println(iObj == jObj? "주소가 같다." : "주소가 다르다.");
		
	    }

}
