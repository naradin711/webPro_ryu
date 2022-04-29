package com.lec.ex02_Swing;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ex01_Thursday extends JFrame implements ActionListener{
   private JPanel panel; // 받아온 컨테이너를 저장.
   private JLabel jlbl;
   //private Container conPanel;// 받아온 컨테이너를 저장.
   private JButton jbtn;
   //private JTextField txtF = new JTextField();
	
   public Ex01_Thursday() {
	}
   public Ex01_Thursday(String title) {
	   super(title);
	   setDefaultCloseOperation(EXIT_ON_CLOSE); // x 버튼 클릭시 사용종료
	   panel = (JPanel) getContentPane();
	   panel.setLayout(new FlowLayout());
	   jlbl = new JLabel("즐거운 목요일", (int) CENTER_ALIGNMENT);
	   jbtn = new JButton("EXIT");
	   panel.add(jlbl);// null 포인터 오류 뜰때 해당 컴포넌트의 지정이 제대로 되어있는지 확인
	   jlbl.setPreferredSize(new Dimension(150,200));
	   panel.add(jbtn);
	   jbtn.setPreferredSize(new Dimension(200,200));
	   setVisible(true);
	   setSize(new Dimension(400,250));
	   setLocation(200, 200);
	   //이벤트 리스너 추가
	   jbtn.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbtn) {// exit버튼 클릭시 할 로직
	    	  setVisible(false); // 안보이게
	  		  dispose();         // 자원해제
	  		  System.exit(0);    // 강제종료
	      }
	}
	
	public static void main(String[] args) {
		new Ex01_Thursday("title");
	}

	
}



















