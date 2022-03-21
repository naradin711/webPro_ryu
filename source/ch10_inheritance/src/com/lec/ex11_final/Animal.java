package com.lec.ex11_final;

public class Animal {
   private int speed;
   public void running() {
	   speed +=5;
	   System.out.println("뛰고 있습니다. 현재속도 : "+ speed);
   }
   public final void stop ( ) { // stop이라는 method는 Override 금지.
	   speed = 0;
	   System.out.println("멈춤");
   }
   
   public int getSpeed() {
	  return speed;
   }
   public void setSpeed(int speed) {
	  this.speed = speed;
   }
   
}
