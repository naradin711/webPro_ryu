package com.lec.ex02_Thread;
//Thread t1 = new ThreadEx01();
public class TargetEx01 extends Thread {
   public TargetEx01() {}
   public TargetEx01(String name) {
	  super(name);
   }
   @Override
   public void run() {
	   for (int i=0; i<10 ; i++) {
		    System.out.println(Thread.currentThread().getName());
			System.out.println("�ȳ��ϼ��� -" + i);
			try { // 0.5�� ���� ��� ���·� ����
				Thread.sleep(500);
			} catch (InterruptedException e) { } 
		}
   }
}
