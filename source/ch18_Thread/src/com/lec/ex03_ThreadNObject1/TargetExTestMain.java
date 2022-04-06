package com.lec.ex03_ThreadNObject1;
public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target = new TargetEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
        System.out.println("메인 함수 끝");	
	}

}
