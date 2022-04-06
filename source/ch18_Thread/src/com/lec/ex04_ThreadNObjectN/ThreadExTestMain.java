package com.lec.ex04_ThreadNObjectN;

public class ThreadExTestMain {
	public static void main(String[] args) {
	   ThreadEx threadA = new ThreadEx("A");
	   ThreadEx threadB = new ThreadEx("B");
	   threadA.start();
	   threadB.start();
	   try {
		Thread.sleep(800);
	   } catch (InterruptedException e) {}
	   System.out.println("A의 num: "+threadA.getNum());
	   System.out.println("B의 num: "+threadB.getNum());
	   System.out.println("Main 함수 끝!");
	}

}
