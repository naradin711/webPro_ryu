package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {
    
	public TimerTaskEx2() {
	}

	@Override
	public void run() {
		System.out.println("작업2 : 1초 후에 0.5초마다 계속 수행될 예정인 TimerTask");

	}

}
