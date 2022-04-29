package com.lec.ex04_ThreadNObjectN;
//ThreadEx threadA = new ThreadEx("A");
//threadA.setName("A")
public class ThreadEx extends Thread {
   private int num = 0;
   public ThreadEx(String name) {
	   super(name);
   }
   @Override
   public void run() {
	   for(int i=0; i<10 ; i++) {
		   out();
	   }
    	   try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
	}//run
    private synchronized void out() { //이 함수 시행할때는 아무도 끼어들지마!
    	
     	   if(Thread.currentThread().getName().equals("A")) {//A 스레드일 경우
     		  System.out.println("~~~~~A 스레드 수행중~~~~~"); 
     		  num++;
     	   }
     	   System.out.println(Thread.currentThread().getName() + "의 num =" + num );
    	
    }
    public int getNum() {
	   return num;
    }
    public void setNum(int num) {
	   this.num = num;
    } 
}




















