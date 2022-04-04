package com.lec.ex04_object;
// Staff s1 = new Staff ("a01", "홍길동", "COMPUTER") - 오늘 입사일
// Staff s2 = new Staff ("a02", "신길동", "COMPUTER", 2022,3,24) - 3월 24일 입사일
public class Ex01_Staff_TestMain {
	public static void main(String[] args) {
		Staff s1 = new Staff ("a01", "홍길동", Dept.COMPUTER);//오늘 입사일
		Staff s2 = new Staff ("a02", "신길동", Dept.HUMANRESOURCE, 2022, 3, 24); // - 3월 24일 입사일
	    System.out.println(s1.toString());	
	    System.out.println(s2.toString());
	    Staff2 s3 = new Staff2 ("c01","마길동", Dept2.COMPUTER);
	    System.out.println(s3.toString());
	}
	
}
