package com.lec.ex02_Thread;
//Thread t2 = new ThreadEx02();
public class TargetEx02 extends Thread {
   public TargetEx02() {}
   public TargetEx02(String name) {
	  super(name);
   }
   @Override
   public void run() {
	   for (int i=0; i<10 ; i++) {
		    System.out.println(Thread.currentThread().getName());
			System.out.println(i+"��°, �ݰ����ϴ�!");
			try { // 0.5�� ���� ��� ���·� ����
				Thread.sleep(500);
			} catch (InterruptedException e) { } 
		}
   }
}
