package com.lec.ex03_ThreadNObject1;

public class TargetEx implements Runnable {
   private int num = 0;
	@Override
	public void run() {
       for(int i=0; i<10 ; i++) {
    	   out ();
    	   try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
      }//for
	}//run
	private synchronized void out () {
		if(Thread.currentThread().getName().equals("A")) {//A 스레드일 경우
		  System.out.println("~~~~~A 스레드 수행중~~~~~"); 
		  num++;
	    }//if절
	   System.out.println(Thread.currentThread().getName() + "의 num =" + num  );
	}
}//class
