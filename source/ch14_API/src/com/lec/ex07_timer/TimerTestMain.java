package com.lec.ex07_timer;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); //프로그램이 끝나고 계속 상주하고 있다. 이 변수를 넣어야지 프로그램과 함께 타이머도 끝난다.
        TimerTask t1 = new TimerTaskEx1();
        TimerTask t2 = new TimerTaskEx2();
        timer.schedule(t1, 2000);// 2초 후에 task 수행
        timer.schedule(t2, 1000, 500);
        
        //3초 동안 잠깐 멈춤.
        Thread.sleep(5000);
        System.out.println("끝");
	}

}
