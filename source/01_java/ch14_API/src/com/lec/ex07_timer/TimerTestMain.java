package com.lec.ex07_timer;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); //���α׷��� ������ ��� �����ϰ� �ִ�. �� ������ �־���� ���α׷��� �Բ� Ÿ�̸ӵ� ������.
        TimerTask t1 = new TimerTaskEx1();
        TimerTask t2 = new TimerTaskEx2();
        timer.schedule(t1, 2000);// 2�� �Ŀ� task ����
        timer.schedule(t2, 1000, 500);
        
        //3�� ���� ��� ����.
        Thread.sleep(5000);
        System.out.println("��");
	}

}
