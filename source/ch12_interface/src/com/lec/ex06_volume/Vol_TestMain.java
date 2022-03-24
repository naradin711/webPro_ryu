package com.lec.ex06_volume;
public class Vol_TestMain {
	public static void main(String[] args) {
		IVol [] volumes = { new TV (3),
				            new TV (15),
				            new TV (20),
				            new Speaker (20)};
		for(IVol temp : volumes) {
			temp.volumeDown();
			temp.volumeDown(14);
			temp.volumeUp(10);
			temp.volumeUp(45);
			temp.setMute(true); //default method
			System.out.println("~~~~~~~~~~~~~~~~~~~~");
		}
		}
	}

