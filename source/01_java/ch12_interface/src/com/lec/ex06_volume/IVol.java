package com.lec.ex06_volume;

public interface IVol {
   public void volumeUp();
   public void volumeUp(int level);
   public void volumeDown();
   public void volumeDown(int level);
   public default void setMute(boolean mute) {
	   if(mute) {
		   System.out.println("무음 처리합니다.");
	   }else {
		   System.out.println("무음 해제합니다.");
	   }
   }
}
