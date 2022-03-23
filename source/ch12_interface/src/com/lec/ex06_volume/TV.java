package com.lec.ex06_volume;

public class TV implements IVol {
   private final int TV_MAX_VOLUME=50;
   private final int TV_MIN_VOLUME=0;
   private int volumeLevel;
   public TV (int volumeLevel) {
	   this.volumeLevel = volumeLevel;
   }
	@Override
	public void volumeUp() {
		if(volumeLevel<TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올립니다. 현재 음량 : "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치입니다.");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel<=TV_MAX_VOLUME) {
			  volumeLevel += level;
			  System.out.println("TV 볼륨을 "+level+"만큼 올립니다. 현재 음량 : "+volumeLevel);     
		} else {
			int templevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 " +level+"만큼 못 올리고"+templevel+"만큼 올립니다. TV 볼륨이 최대치" +TV_MAX_VOLUME+"입니다." );
		}
//		volumeLevel += level;
//		if(volumeLevel>TV_MAX_VOLUME) {
//			  volumeLevel = TV_MAX_VOLUME;
//		      System.out.println("TV 볼륨이 최대치입니다.");
//		} else {
//			System.out.println("TV 볼륨을"+level+"만큼 올립니다. 현재 음량 : "+volumeLevel);
//		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel>TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV 볼륨을 1만큼 내립니다. 현재 음량 : "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최소치입니다.");
		}
	}
	@Override
	public void volumeDown(int level) {
		
		if(volumeLevel<TV_MIN_VOLUME) {
			  volumeLevel -= level;
			  System.out.println("TV 볼륨을 "+level+"만큼 내립니다. 현재 음량 : "+volumeLevel);     
		} else {
			int templevel = TV_MIN_VOLUME - volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 " +level+"만큼 못 내리고 "+templevel+" 만큼 내립니다. TV 볼륨이 최소치" +TV_MIN_VOLUME+"입니다." );
		}
//		if(volumeLevel<TV_MIN_VOLUME) {
//			  volumeLevel = TV_MIN_VOLUME;
//		      System.out.println("TV 볼륨이 최소치입니다.");
//		} else {
//			System.out.println("TV 볼륨을"+level+"만큼 내립니다. 현재 음량 : "+volumeLevel);	
//		}
	}

}
