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
			System.out.println("TV ������ 1��ŭ �ø��ϴ�. ���� ���� : "+volumeLevel);
		}else {
			System.out.println("TV ������ �ִ�ġ�Դϴ�.");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel<=TV_MAX_VOLUME) {
			  volumeLevel += level;
			  System.out.println("TV ������ "+level+"��ŭ �ø��ϴ�. ���� ���� : "+volumeLevel);     
		} else {
			int templevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ " +level+"��ŭ �� �ø���"+templevel+"��ŭ �ø��ϴ�. TV ������ �ִ�ġ" +TV_MAX_VOLUME+"�Դϴ�." );
		}
//		volumeLevel += level;
//		if(volumeLevel>TV_MAX_VOLUME) {
//			  volumeLevel = TV_MAX_VOLUME;
//		      System.out.println("TV ������ �ִ�ġ�Դϴ�.");
//		} else {
//			System.out.println("TV ������"+level+"��ŭ �ø��ϴ�. ���� ���� : "+volumeLevel);
//		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel>TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV ������ 1��ŭ �����ϴ�. ���� ���� : "+volumeLevel);
		}else {
			System.out.println("TV ������ �ּ�ġ�Դϴ�.");
		}
	}
	@Override
	public void volumeDown(int level) {
		
		if(volumeLevel<TV_MIN_VOLUME) {
			  volumeLevel -= level;
			  System.out.println("TV ������ "+level+"��ŭ �����ϴ�. ���� ���� : "+volumeLevel);     
		} else {
			int templevel = TV_MIN_VOLUME - volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������ " +level+"��ŭ �� ������ "+templevel+" ��ŭ �����ϴ�. TV ������ �ּ�ġ" +TV_MIN_VOLUME+"�Դϴ�." );
		}
//		if(volumeLevel<TV_MIN_VOLUME) {
//			  volumeLevel = TV_MIN_VOLUME;
//		      System.out.println("TV ������ �ּ�ġ�Դϴ�.");
//		} else {
//			System.out.println("TV ������"+level+"��ŭ �����ϴ�. ���� ���� : "+volumeLevel);	
//		}
	}

}
