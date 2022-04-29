package com.lec.ex06_volume;

public class Speaker implements IVol {
   private final int SPEAKER_MAX_VOLUME=100;
   private final int SPEAKER_MIN_VOLUME=0;
   private int volumeLevel;
   public Speaker (int volumeLevel) {
	   this.volumeLevel = volumeLevel;
   }
	@Override
	public void volumeUp() {
		if(volumeLevel<SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("스피커 볼륨을 1만큼 올립니다. 현재 음량 : "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치입니다.");
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel>SPEAKER_MAX_VOLUME) {
			  volumeLevel = SPEAKER_MAX_VOLUME;
		      System.out.println("스피커 볼륨이 최대치입니다.");
		} else {
			System.out.println("스피커 볼륨을"+level+"만큼 올립니다. 현재 음량 : "+volumeLevel);
		
		}

	}

	@Override
	public void volumeDown() {
		if(volumeLevel>SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("스피커 볼륨을 1만큼 내립니다. 현재 음량 : "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최소치입니다.");
		}
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if(volumeLevel<SPEAKER_MIN_VOLUME) {
			  volumeLevel = SPEAKER_MIN_VOLUME;
		      System.out.println("스피커 볼륨이 최소치입니다.");
		} else {
			System.out.println("스피커 볼륨을"+level+"만큼 내립니다. 현재 음량 : "+volumeLevel);
		
		}
	}

}
