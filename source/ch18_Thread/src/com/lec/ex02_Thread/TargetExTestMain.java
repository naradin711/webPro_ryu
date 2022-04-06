package com.lec.ex02_Thread;

public class TargetExTestMain {

	public static void main(String[] args) {
		Thread threadA = new TargetEx01("A");
		Thread threadB = new TargetEx02();
		threadB.setName("B");
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인 함수 끝");
	}
;
}
