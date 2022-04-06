package com.lec.ex01_awt;
import java.awt.*;
public class Ex01_MyFrame extends Frame {
   private Button btn;
   private Button btn1;
   public Ex01_MyFrame(String title){
	   super(title);
	   // 버튼 2개를 추가한 Frame 생성.
	   btn = new Button("버튼 1");
	   btn1 = new Button("버튼 2");
	   add(btn, BorderLayout.NORTH);
	   add(btn1, BorderLayout.CENTER);
	   pack(); // 최소한의 사이즈
	   setVisible(true);// 창을 보이게 한다.
	   setLocation(100, 50);
	   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
	    setVisible(false); // 화면에 안보이게
	    dispose();// 자원 해제 - 해당 프로그램을 돌리는데 할당하는 메모리 값을 삭제 
	    System.exit(0);// 강제 종료
    }
    public static void main(String[] args) {
		new Ex01_MyFrame("My first Java GUI");
	}
   
}
