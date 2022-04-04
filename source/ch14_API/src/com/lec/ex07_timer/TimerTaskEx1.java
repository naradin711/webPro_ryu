package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {
	public TimerTaskEx1() {
	}
	@Override
	public void run() {
		System.out.println("작업1 : 2초 후에 한번 수행될 예정인 TimerTask");

	}

}
