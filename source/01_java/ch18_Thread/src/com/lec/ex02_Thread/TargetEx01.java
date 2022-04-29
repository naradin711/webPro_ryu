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
			System.out.println("¾È³çÇÏ¼¼¿ä -" + i);
			try { // 0.5ÃÊ µ¿¾È ´ë±â »óÅÂ·Î »©³¿
				Thread.sleep(500);
			} catch (InterruptedException e) { } 
		}
   }
}
