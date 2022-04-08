package com.lec.ex02_Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container  contenPane; // 컨테이너 얻어올 변수
    private JPanel     jp1; //이름 전화 나이 받을것
    private JPanel     jp2; // 입력 출력 버튼 받을것
    private JTextField txtName, txtTel, txtAge;
    private ImageIcon  iconIn, iconOut;
    private JButton    btnIn;
    private JButton    btnOut;
    private int        cnt ;
    ArrayList<Person> pp = new ArrayList<Person>(); // 해당 리스트를 바깥으로 빼서 이하 모든 함수에 적용되도록 리셋되지 않도록 한다.
    public MyFrame (String title) {
       super(title);
       setDefaultCloseOperation(EXIT_ON_CLOSE);//x버튼 누르면 사라지게 함.
       contenPane = getContentPane(); //콘테이너 토대 세우기!
       jp1 = new JPanel(new GridLayout(3,2));
       jp2 = new JPanel(new FlowLayout());
       txtName    = new JTextField();                // 이름을 입력할 텍스트 필드 객체 생성
	   txtTel     = new JTextField();                // 전화번호를 입력할 텍스트 필드 객체 생성
	   txtAge     = new JTextField();
	   iconIn     = new ImageIcon ("src/icon/join.png"); 
	   iconOut    = new ImageIcon ("src/icon/output.png");
	   btnIn      = new JButton ("입력", iconIn);
	   btnOut     = new JButton ("출력", iconOut);
	   jp1.add(new JLabel("이  름", (int) CENTER_ALIGNMENT)); //이름 라벨 정수로 가운데 정렬
	   jp1.add(txtName);                                    // 이름을 입력할 텍스트 필드 생성
	   jp1.add(new JLabel("전  화", (int) CENTER_ALIGNMENT)); //전화 라벨 정수로 가운데 정렬
	   jp1.add(txtTel);                                     // 전화번호를 입력할 텍스트 필드 생성
	   jp1.add(new JLabel("나  이", (int) CENTER_ALIGNMENT)); //나이 라벨 정수로 가운데 정렬
	   jp1.add(txtAge);
	   jp2.add(btnIn);
	   jp2.add(btnOut);
	   contenPane.add(jp1, BorderLayout.CENTER);
	   contenPane.add(jp2, BorderLayout.SOUTH);
	   setVisible(true);
	   setBounds(250, 150, 300, 200);
	   btnIn.addActionListener(this);
	   btnOut.addActionListener(this);
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnIn) {
			do {String name = txtName.getText().trim();
			    String tel = txtTel.getText().trim();
			    if(name.equals("") || tel.equals("")) {
					System.out.println("이름과 전화번호는 필수 입력 사항입니다.");
					return;
				}
			    int age = 0;
			    try {
					age = Integer.parseInt(txtAge.getText());	//txtAge에 입력한 정수값을 문자열화 시킴
					if(age <0 || age>150) {
						System.out.println("유효하지 않은 나이를 입력하셨습니다.");
						age = 0; // 유효하지 않은 나이는 age 값을 0으로 출력.
					}
				}catch(Exception e1) {
					System.out.println("유효하지 않은 나이를 입력하셨습니다.");
				}
			    pp.add(new Person(name, tel, age));
			    break;
			}while(true); 
			txtName.setText(""); // 각 입력 텍스트필드 초기화
			txtTel.setText("");  // 각 입력 텍스트필드 초기화
			txtAge.setText("");  // 각 입력 텍스트필드 초기화
		}
		if(e.getSource()== btnOut) {
			OutputStream os = null;
			try {
				os = new FileOutputStream("src/com/lec/ex02_Swing/Person.txt",true);
			    for (Person p : pp) {
			    	System.out.println(p);
			    	os.write(p.toString().getBytes());
			    }
			    System.out.println("이하 "+pp.size()+"명의 회원이 가입하였습니다.");
				   String str1 = "\n이하 "+pp.size()+"명의 회원이 가입하였습니다.";
				   byte [] bs1 = str1.getBytes();
				   os.write(bs1);
			} catch (FileNotFoundException e1) {
				
			} catch (IOException e2) {
				  
			}finally {
				try {
					if(os!=null) os.close();
				} catch (Exception e3) {
				}
			}
		}
	}
	public static void main(String[] args) {
		new MyFrame("GUI 예제");

	}//main

}//class






