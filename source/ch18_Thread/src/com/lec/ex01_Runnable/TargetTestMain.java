package com.lec.ex01_Runnable;
// 안녕하세요 반갑습니다 10번 동시에 슉
public class TargetTestMain {
	public static void main(String[] args) {
		Runnable t1 = new TargetEx01();
		Runnable t2 = new TargetEx02(); // 두 객체 다 러너블 타입
		// "A"라는 이름의 쓰레드 생성.
		Thread threadA = new Thread (t1, "A");
		// "B"라는 이름의 쓰레드 생성.
		Thread threadB = new Thread (t2, "B");
		threadA.start();
		threadB.start();
		for(int i = 0; i <10 ; i ++) {
			System.out.println("나는 " + Thread.currentThread().getName()+i);
		}// Thread.currentThread().getName() 현재의 쓰레드 이름.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		//실행할 때 마다 매번 달라짐.
	}

}
