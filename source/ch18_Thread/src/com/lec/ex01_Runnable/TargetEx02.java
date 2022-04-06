package com.lec.ex01_Runnable;
// 안녕하세요. 반갑습니다. 동시에 처리.
// "안녕하세요 10번" 하는 target.
public class TargetEx02 implements Runnable {

	@Override
	public void run() {
		for (int i=0; i<10 ; i++) {
			System.out.println( i + "번째 반갑습니다.");
			try { // 0.5초 동안 대기 상태로 빼냄
				Thread.sleep(500);
			} catch (InterruptedException e) { } 
		}
	}

}
