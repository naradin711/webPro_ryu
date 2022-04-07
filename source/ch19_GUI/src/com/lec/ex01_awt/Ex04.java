package com.lec.ex01_awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex04 extends Frame implements ActionListener {
   private Panel panel;
   private TextField txtfield;
   private Button btnOk, btnExit;
   private List list;
   public Ex04() {//layout setting, creating component add, setVisible, setSize
   // setLayout(new BorderLayout()); //기본 레이아웃으로 생략가능.
      panel = new Panel(); //패널의 기본 레이아웃은 FlowLayout으로 설정
      txtfield = new TextField(20);
      btnOk = new Button (" OK ");
      btnExit = new Button("EXIT");
      list = new List();
      panel.add(new Label("write"));
      panel.add(txtfield);
      panel.add(btnOk);
      panel.add(btnExit);
      add(panel, BorderLayout.NORTH);
      add(list, BorderLayout.CENTER);
      setVisible(true);
      setSize(new Dimension(350,150));
      setLocation(150, 150);
      //x 클릭시 종료.
      addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    		setVisible(false); //안보이게
    		dispose();         // 자원해제
    		System.exit(0);    // 강제종료
    	}
	  });
      // 이벤트 추가  1. implements ActionListener -> override
      //          2. 이벤트 리스너를 추가합니다.
      btnOk.addActionListener(this); // 여기서 보이드 메소드인 액션 퍼폼드 자동 호출
      btnExit.addActionListener(this);
      //          3. 오버라이드한 action 메소드에 로직추가
   }
   public Ex04(String title) {
	 this();
	 setTitle(title);
   }
   public static void main(String[] args) {
	  new Ex04();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnOk) { // ok버튼 클릭시 할 로직 : txtfield의 텍스트를 list에 추가 
    	  list.add(txtfield.getText().trim().toUpperCase()); //양 측 여백 삭제 모든 글자 대문자
    	  txtfield.setText("");
      }else if (e.getSource()==btnExit) {// exit버튼 클릭시 할 로직
    	  setVisible(false); // 안보이게
  		  dispose();         // 자원해제
  		  System.exit(0);    // 강제종료
      }
      
	}
}












