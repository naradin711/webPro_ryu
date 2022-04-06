package com.lec.ex01_awt;
import java.awt.*;
public class Ex00 {

	public static void main(String[] args) {
		Frame frame = new Frame("자바 첫 GUI 예제");
		Button btn = new Button("버튼");
		frame.add(btn, BorderLayout.NORTH); // 버튼을 위쪽(NORTH)에다가 추가하고 싶을 때 
		Button btn1 = new Button("그냥 버튼");
		frame.add(btn1, BorderLayout.CENTER); // 그냥 버튼을 중앙 CENTER에 추가!
	    frame.setSize(new Dimension(300,200));
	    frame.setVisible(true); // 해당 창을 보일수 있게 해줌
	    frame.setLocation(100, 50);
	    // 3초 후 자동 창 닫고 실행 종료하기
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
	    frame.setVisible(false);
	    frame.dispose();// 자원 해제 - 해당 프로그램을 돌리는데 할당하는 메모리 값을 삭제 
	    System.exit(0);// 강제 종료

	}

}
