package com.lec.ex02_Swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//3행 2열짜리 그리드 레이아웃
public class Ex03_GUI extends JFrame implements ActionListener {
    // 컴포넌트 객체 변수 선언. ArrayList 변수, file io위한 stream, db 접속관련 객체 변수
	private Container  contenPane; // 컨테이너 얻어올 변수
    private JPanel     jp;         // 이름, 전화, 나이 받을 6개 컴포넌트를 gridLayout으로 add
    private JTextField txtName, txtTel, txtAge;
    private ImageIcon  icon;
    private JButton    btnOut;
    private JTextArea  jTa;
    private JScrollPane scrollbar;
    private int        cnt; // 몇명 입력했는지 저장
    
    public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x 키 눌러서 자바 출력창 끄기
		contenPane = getContentPane();
		jp         = new JPanel(new GridLayout(3,2)); // 3행 2열 //jp.setLayout(new GridLayout(3,2)); // 3행 2열
		txtName    = new JTextField();                // 이름을 입력할 텍스트 필드 객체 생성
		txtTel     = new JTextField();                // 전화번호를 입력할 텍스트 필드 객체 생성
		txtAge     = new JTextField();                // 나이를 입력할 텍스트 필드 객체 생성
		icon       = new ImageIcon ("src/icon/output.png"); // 아이콘 폴더에서 이미지 가져오기
		btnOut     = new JButton ("출력", icon);             // 아이콘 변수를 넣어서 버튼 정의하기
		jTa        = new JTextArea (5,30);                  // text를 출력해 줄 필드 생성 5 , 30 
		scrollbar  = new JScrollPane(jTa);                  // JScrollPane을 사용하여 남쪽 텍스트 필드에 스크롤바 입력
		jp.add(new JLabel("이  름", (int) CENTER_ALIGNMENT)); //이름 라벨 정수로 가운데 정렬
		jp.add(txtName);                                    // 이름을 입력할 텍스트 필드 생성
		jp.add(new JLabel("전  화", (int) CENTER_ALIGNMENT)); //전화 라벨 정수로 가운데 정렬
		jp.add(txtTel);                                     // 전화번호를 입력할 텍스트 필드 생성
		jp.add(new JLabel("나  이", (int) CENTER_ALIGNMENT)); //나이 라벨 정수로 가운데 정렬
		jp.add(txtAge);                                     // 나이를 입력할 텍스트 필드 생성
		contenPane.add(jp, BorderLayout.NORTH);        // grid한 jp 패널을 북쪽에 위치
		contenPane.add(btnOut, BorderLayout.CENTER);   // 출력버튼을 센터에 위치
		contenPane.add(scrollbar, BorderLayout.SOUTH); // 스크롤바를 남쪽에 위치
		setVisible(true);                              // 자바창을 가시화 시키기
//		setSize(new Dimension(400,300));
//		setLocation(200, 100);
		setBounds(200, 100, 400, 300); // 자바 창을 호출 할 시(위치, 위치, 세로, 가로) 픽셀 단위
		btnOut.addActionListener(this); // 버튼 영역에 액션리스너 설치. 밑에서 액션이벤트의 트리거가 됨.
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // override된 액션퍼폼드 함수.
		if(e.getSource()== btnOut) {
			// txtName, txtTel, txtAge에 입력한 값을 jTa에 출력
			String name = txtName.getText().trim();  // txtName에서 name 문자열 얻어옴. 양쪽 공백 제거
			String tel = txtTel.getText().trim();    // txtTel에서 tel 문자열 얻어옴. 양쪽 공백 제거
			if(name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항입니다.");
				return;
			}
			if(tel.indexOf("-")==tel.lastIndexOf("-") ||  // 111-1111-2222, 000-00000
					tel.indexOf("-")<2 ||                 // 앞자리 가 012 보다 앞에 오면 01- 0- 식이 옴.
					tel.lastIndexOf("-")>10) {            // 마지막 - 가 10보다 크면 ex)000-0000000-0000 
				System.out.println("전화번호 형식을 다시 한번 확인해 주세요.");
				return;
			}
			// 나이체크
			int age = 0; // 나이 정수 초기화
			try {
				age = Integer.parseInt(txtAge.getText());	//txtAge에 입력한 정수값을 문자열화 시킴
				if(age <0 || age>150) {
					System.out.println("유효하지 않은 나이를 입력하셨습니다.");
					age = 0; // 유효하지 않은 나이는 age 값을 0으로 출력.
				}
			}catch(Exception e1) {
				System.out.println("유효하지 않은 나이를 입력하셨습니다.");
			}
			System.out.println(++cnt +"명 입력됨.");
			if(cnt==1) {
				jTa.setText("이름\t전화\t\t나이\n");
			}
			jTa.append(name+"\t"+tel+"\t\t"+age+"\n");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}

	}

	public static void main(String[] args) {
		new Ex03_GUI("GUI 마지막 예제");

	}

	
}





















