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
    private synchronized void out() { //�� �Լ� �����Ҷ��� �ƹ��� ���������!
    	
     	   if(Thread.currentThread().getName().equals("A")) {//A �������� ���
     		  System.out.println("~~~~~A ������ ������~~~~~"); 
     		  num++;
     	   }
     	   System.out.println(Thread.currentThread().getName() + "�� num =" + num );
    	
    }
    public int getNum() {
	   return num;
    }
    public void setNum(int num) {
	   this.num = num;
    } 
}




















