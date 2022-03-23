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
			System.out.println("����Ŀ ������ 1��ŭ �ø��ϴ�. ���� ���� : "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		}
	}

	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel>SPEAKER_MAX_VOLUME) {
			  volumeLevel = SPEAKER_MAX_VOLUME;
		      System.out.println("����Ŀ ������ �ִ�ġ�Դϴ�.");
		} else {
			System.out.println("����Ŀ ������"+level+"��ŭ �ø��ϴ�. ���� ���� : "+volumeLevel);
		
		}

	}

	@Override
	public void volumeDown() {
		if(volumeLevel>SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("����Ŀ ������ 1��ŭ �����ϴ�. ���� ���� : "+volumeLevel);
		}else {
			System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		}
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if(volumeLevel<SPEAKER_MIN_VOLUME) {
			  volumeLevel = SPEAKER_MIN_VOLUME;
		      System.out.println("����Ŀ ������ �ּ�ġ�Դϴ�.");
		} else {
			System.out.println("����Ŀ ������"+level+"��ŭ �����ϴ�. ���� ���� : "+volumeLevel);
		
		}
	}

}
