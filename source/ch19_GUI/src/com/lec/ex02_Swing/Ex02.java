package com.lec.ex02_Swing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
public class Ex02 extends JFrame implements ActionListener {
    // 필요한 컴포넌트 변수 추가.
	private JPanel            jpanel; // 컨테이너 얻어올 변수
	private Container     contenPane; // 컨테이너 얻어 올 변수
	private ImageIcon           icon; // 버튼에 들어갈 아이콘
	
	private JButton             jBtn; // 버튼 삽입.
	private JTextField    jtxtField ; 
	private Vector<String>     items; // 컴보박스에 들어갈 item 리스트
	private String []          item = {"A", "B", "C", "D"};
    private JComboBox<String> jCombo;
    private JCheckBox         jCheck;
    private JLabel           jlBlank;
    private JButton         jbtnExit; // java 라벨을 종료시킬 버튼 
	// 생성자 : 컨테이너 얻어와서 레이아웃 세팅 - 컴포넌트 생성후 add -> setVisible, set Size (화면구현) ->이벤트 추가 -> 메인 함수에서 출력
    public Ex02() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE); //x 클릭 시 종료!
    	contenPane = getContentPane(); // 스윙은 컨테이너를 얻어온 후 작업.
    	contenPane.setLayout(new FlowLayout()); // 레이아웃 지정
    	icon      = new ImageIcon("src/icon/write.gif"); // 아이콘 그림 경로 지정!
    	jBtn      = new JButton("Button", icon); // 이미지 대체!
    	jtxtField = new JTextField(20);
      //jCombo    = new JComboBox<String>(item); // 콤보박스 item 리스트 추가 방법 1. string 배열 (고정)
    	items     = new Vector<String>();
    	items.add("A"); items.add("B"); items.add("C"); items.add("D");
    	jCombo    = new JComboBox<String>(items); //아이템즈로 콤보박스 완성 2. Vector 이용 (가변적)
    	jCheck    = new JCheckBox("Check");
    	jlBlank   = new JLabel("");
    	jbtnExit  = new JButton("EXIT");
      //컴포넌트 add하기 - 컴포넌트의 사이즈 조정(pdf참조)
    	contenPane.add(new JLabel("Label"));
    	contenPane.add(jBtn);
    	contenPane.add(jtxtField);
    	contenPane.add(jCombo);
    	contenPane.add(jCheck);
    	contenPane.add(jlBlank); // 중복해서 생성해도 쌓이지 않고 바로 덮어쓰기행
    	contenPane.add(jbtnExit);
    	// 컨테이너 얻어와서 컴포넌트 생성하고 사이즈!
    	jBtn.setPreferredSize     (new Dimension(200,50));
    	jtxtField.setPreferredSize(new Dimension(300,50));
        jCombo.setPreferredSize   (new Dimension(100,50));
        jCheck.setPreferredSize   (new Dimension(100,50));
        jlBlank.setPreferredSize  (new Dimension(200,50));
        jbtnExit.setPreferredSize (new Dimension(100,50));
        jBtn.    addActionListener(this);
        jCombo.  addActionListener(this);
        jCheck.  addActionListener(this);
        jbtnExit.addActionListener(this);
        setVisible(true); // 해당 패널을 가시화한다
        pack(); // 컴포넌트들을 포함하는 최소한의 사이즈!
        setLocation(100, 50);
    	
    } 
    
    @Override
	public void actionPerformed(ActionEvent e) { //이벤트 로직
    	 if      (e.getSource()==jBtn)     {
    		String temp = jtxtField.getText().trim().toUpperCase();
    		if (temp.equals("")) {
    			System.out.println("때찌!"); // jtxtField에 빈 스트링이거나 스페이스만 입력할 경우
    			return;
    		}
    		jCombo.addItem(temp); // 텍스트필드에 있던 문자열을 대문자로 바꿔서 콤보박스에 추가시킴
    		jlBlank.setText(jtxtField.getText().trim()); //블랭크에는 텍스트파일 입력내용 그대로
    		jtxtField.setText("");
    	}else if (e.getSource()==jCombo)   {
    		String temp = jCombo.getSelectedItem().toString(); // 콤보박스 선택된 항목
    		int    no   = jCombo.getSelectedIndex();
    		jlBlank.setText(no+"번째  "+temp+"선택");
    		jCombo.setSelectedItem("A"); // A가 선택되도록 jCombo.setSelectedIndex(0)
    	}else if (e.getSource()==jCheck)   {
    		if(jCheck.isSelected()) { // 체크박스가 체크 된 상태
    		    jlBlank.setText(jCheck.getText());
    		}else {                   // 체크박스 언체크함.
    			jlBlank.setText("");
    		}
    		
    	}else if (e.getSource()==jbtnExit) { // exit버튼 클릭시 할 로직
	    	  setVisible(false); // 안보이게
	  		  dispose();         // 자원해제
	  		  System.exit(0);    // 강제종료
	    }
	}
    public static void main(String[] args) {
		new Ex02(); //실행
	}   

}




















