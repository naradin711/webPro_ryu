package com.lec.ex01_awt;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
public class Ex03_LogIn02 extends Frame{
   private Panel panel;
   private Label lbl1;
   private TextField txtId;
   private Label lbl2;
   private TextField txtPw;
   private Button btnLogin;
   public Ex03_LogIn02(String title) {//Frame에 컴포넌트 추가하고 화면 보이게 -> 이벤트
      super(title);
      //Frame의 레이아웃 타입 : BorderLayout 동 서 남 북 센터 말고는 배치가 안됨 
      //                   FlowLayout (왼쪽에서 오른쪽으로, 위에서 아래로 차곡차곡 컴포넌트가 add 된다.)
      //                   GridLayout (몇 행 몇 열!)
      panel = new Panel();// 아무 지시 없으면 패널의 기본 레이아웃 : FlowLayout
      //setLayout(new GridLayout(2,2));
      lbl1 = new Label("아이디   ");
      txtId = new TextField(20); //20 글자정도 프레임에 보임
      lbl2 = new Label("비밀번호");
      txtPw = new TextField(20);
      txtPw.setEchoChar('*');//비밀 번호를 입력할 때 별표로 가림
      btnLogin = new Button("LOGIN");
      panel.add(lbl1);
      panel.add(txtId);
      panel.add(lbl2);
      panel.add(txtPw);
      panel.setPreferredSize(new Dimension(280,50));
      add(panel, BorderLayout.NORTH);
      add(btnLogin, BorderLayout.SOUTH);
      setSize(new Dimension(300, 150));
      setLocation(200, 100);
      setVisible(true); //여기까지 GUI 환경구성
      //x 클릭시 종료.
      addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    		setVisible(false); //안보이게
    		dispose();         // 자원해제
    		System.exit(0);    // 강제종료
    	}
	  });
   }
   public Ex03_LogIn02() {
	this("");
   }
   public static void main(String[] args) {
	  new Ex03_LogIn02("Login");
   }
   
}
