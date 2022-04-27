package com.lec.ex04_Supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lec.ex03_Student.StudentDto;

public class SupermarketGUI extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel  jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount ;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton  btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint, btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private CustomerDao dao= CustomerDao.getInstance();
	private ArrayList <CustomerDto> customers;
	
	 
	public SupermarketGUI(String title)   {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); 
	 	contenPane.setLayout(new FlowLayout()); 
	 	jpup = new JPanel(new GridLayout(6,3));
	 	jpbtn = new JPanel(new FlowLayout());
	 	txtCid 		= new JTextField(15);
	 	txtCtel		= new JTextField(15);
	 	txtCname	= new JTextField(15);
	 	txtCpoint	= new JTextField(15);
	 	txtCamount	= new JTextField(15);
	 	levelNames = dao.getLevelNames();
	 	comLevelName =new JComboBox<String>(levelNames);
	 	btnCidSearch 		= new JButton("아이디 검색"); 
	 	btnCtelSearch		= new JButton("폰4자리(FULL)검색");
	 	btnCnameSearch 		= new JButton("고객 이름 검색"); 
	 	btnBuyWithPoint		= new JButton("포인트로만 구매");
	 	btnBuy				= new JButton("물품 구매"); 
	 	btnLevelNameOutput	= new JButton("등급별출력"); 
	 	btnAllOutput		= new JButton("전체 출력"); 	
	 	btnInsert			= new JButton("회원가입");
	 	btnCtelUpdate 		= new JButton("번호수정"); 
	 	btnDelete 			= new JButton("회원탈퇴"); 
	 	btnExit				= new JButton("나가기");
	 	txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("아이디",(int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("고객전화",(int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("고객이름",(int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("포인트",(int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구매금액",(int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel("  ",(int) CENTER_ALIGNMENT));
		jpup.add(new JLabel("고객등급",(int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(800, 400));
		setLocation(200, 150);
		setVisible(true);	
		
		txtPool.setText("\t\t★★★★★★ 고객 검색 후 구매하세요 ★★★★★★");
		
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this); 
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this); 
		btnInsert.addActionListener(this); 
		btnCtelUpdate.addActionListener(this); 
		btnDelete.addActionListener(this); 
		btnExit.addActionListener(this);				
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCidSearch) { // 아이디 검색
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText("");  
				comLevelName.setSelectedItem(""); 
			String cidStr = txtCid.getText().trim(); // 아이디 입력창의 값을 좌우여백없이 받음
			int cid = Integer.parseInt(cidStr);	 // 아이디 입력창의 값을 정수값으로 치환함.
			CustomerDto customer = dao.cidGetCustomer(cid); //dto 해당하는  customer 변수 생성 dao에서 아이디 검색 세션에 해당 정수를 넣고 적용
			if(customer!=null) { // 해당 dto가 null이 아니면!
				txtCtel.setText(customer.getCtel()); // 전화번호입력창에 번호 출력
				txtCname.setText(customer.getCname()); // 이름입력창에 이름 출력
				txtCpoint.setText(String.valueOf(customer.getCpoint())); // 포인트 입력창에 포인트 출력 이때 포인트는 텍스트를 정수값으로 변환!
				comLevelName.setSelectedItem(customer.getLevelName()); // 콤보박스에 해당 등급 이름 추가
				txtPool.setText("ID\t전화\t이름\t포인트\t 구매누적액\t고객레벨\t레벨업을위한추가구매액 \n"); // 스트링 입력으로 범주 목록 생성
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append로 줄치기
				txtPool.append(customer.toString()); //append로 해당 dto의 toString() 받아서 출력
			}else {
 				txtCid.setText(""); 
 				txtCtel.setText("");  
 				txtCname.setText(""); 
 				txtCpoint.setText("");  
 				txtCamount.setText("");  
 				comLevelName.setSelectedItem(""); //창 초기화
				txtPool.setText("존재하지 않는 ID입니다.");// 에러메시지 넣음
			}
		}else if(e.getSource() == btnCtelSearch) { // 폰4자리 검색
				txtCid.setText(""); 
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");  
				comLevelName.setSelectedItem(""); //창 초기화		
				String ctel = txtCtel.getText().trim();
				if(ctel.length()>4) {
					txtPool.setText("4자리의 연속된 번호나 010-0000-0000 같은 형식으로 전화번호를 입력하십시오. ");
					return;
				}//if
				ArrayList<CustomerDto> customers = dao.getCtelSearch(ctel);
				if(customers.size()!=0) { // 출력
					txtPool.setText("ID\t전화\t이름\t포인트\t 구매누적액\t고객레벨\t레벨업을위한추가구매액 \n"); // 스트링 입력으로 범주 목록 생성
					txtPool.append("------------------------------------------------------------------------------"
							+ "-----------------------------------------------------------------------------------------------------------\n");// append로 줄치기
					for(CustomerDto cusdto : customers) {
						txtPool.append(cusdto.toString()+"\n");
					}
				}else { // 에러출력
					txtCtel.setText(""); 
					txtPool.setText("해당하는 전화번호의 고객이 검색되지 않습니다.");
				}
			
		}else if(e.getSource() == btnCnameSearch) { // 종료
			txtCid.setText(""); 
			txtCtel.setText(""); 
			txtCpoint.setText(""); 
			txtCamount.setText("");  
			comLevelName.setSelectedItem(""); //창 초기화		
			String cname = txtCname.getText().trim();
			if(cname.length()<1) {
				txtCname.setText("");
				txtPool.setText("올바른 이름을 입력하시오 ");
				return;
			}//if
			ArrayList<CustomerDto> customers = dao.getCnameSearch(cname);
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t이름\t포인트\t 구매누적액\t고객레벨\t레벨업을위한추가구매액 \n"); // 스트링 입력으로 범주 목록 생성
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append로 줄치기
				for(CustomerDto cusdto : customers) {
					txtPool.append(cusdto.toString()+"\n");
				}
			}else { // 에러출력
				txtCname.setText(""); 
				txtPool.setText("해당하는 이름의 고객이 검색되지 않습니다.");
			}
			
		}else if(e.getSource() == btnBuyWithPoint) { // 포인트로만 구매
			int cid, cpoint, camount; //아이디 포인트 구매금액 트라이구문 밖에서 정수 정해주기
			// try catch 구문으로 인서트 구문 실행
			try {
				 cid = Integer.parseInt(txtCid.getText().trim());
				 cpoint = Integer.parseInt(txtCpoint.getText().trim());
				 camount = Integer.parseInt(txtCamount.getText().trim());
				 if(cpoint < camount) { // 포인트가 부족한 경우
					 txtPool.setText("포인트가 부족하여 구매가 불가능합니다. ");
					 return;
				 } // IF문 끝남
				 int result = dao.buyWithPoint(cid, camount); //DAO에서 포인트 함수 가져오기
					if(result ==CustomerDao.SUCCESS) { //DAO의 값이 성공이면!
						txtPool.setText("포인트 구매성공"); //구매성공메시지
						txtCpoint.setText(String.valueOf(cpoint-camount)); //포인트입력창에 줄어든 포인트 출력하기
					}else {
						txtPool.setText("유효한 입력값이 아닙니다.");
					}
			} catch (Exception e2) {
 				txtCid.setText(""); 
 				txtCtel.setText("");  
 				txtCname.setText(""); 
 				txtCpoint.setText(""); 
 				txtCamount.setText("");
				txtPool.setText("유효한 고객 ID , POINT, 구매금액을 입력해주시기 바랍니다. ");
			}	
		}else if(e.getSource() == btnBuy) { // 구매
			int cid, camount; //아이디 포인트 구매금액 트라이구문 밖에서 정수 정해주기
			// try catch 구문으로 인서트 구문 실행
			try {
				 cid = Integer.parseInt(txtCid.getText().trim());
				 camount = Integer.parseInt(txtCamount.getText().trim());
				 int result = dao.buy(cid, camount); //DAO에서 포인트 함수 가져오기
					if(result ==CustomerDao.SUCCESS) { //DAO의 값이 성공이면!
						txtPool.setText("물건 구매성공"); //구매성공메시지
					}else {
						txtPool.setText("유효한 입력값이 아닙니다.");
					}
			} catch (Exception e2) {
 				txtCid.setText(""); 
 				txtCtel.setText("");  
 				txtCname.setText(""); 
 				txtCpoint.setText(""); 
 				txtCamount.setText("");
				txtPool.setText("유효한 고객 ID , 구매금액을 입력해주시기 바랍니다. ");
			}
			
		}else if(e.getSource() == btnLevelNameOutput) { // 등급별 출력
			txtCid.setText(""); 
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText(""); 
			txtCamount.setText(""); //창 초기화	 
			String levelName = comLevelName.getSelectedItem().toString(); 	
			if(levelName.length()==0) {
				txtCid.setText(""); 
				txtCtel.setText("");
				txtCname.setText("");
				txtCpoint.setText(""); 
				txtCamount.setText(""); 
				txtPool.setText("원하시는 등급을 선택하시고 검색하세요");
			}
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t이름\t포인트\t 구매누적액\t고객레벨\t레벨업을위한추가구매액 \n"); // 스트링 입력으로 범주 목록 생성
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append로 줄치기
				for(CustomerDto cusdto : customers) {
					txtPool.append(cusdto.toString()+"\n");
				}
			}else { // 에러출력
				txtPool.setText("유효하지 않은 입력값입니다.");
			}
		}else if(e.getSource() == btnAllOutput) { // 전체출력
			txtCid.setText(""); 
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText(""); 
			txtCamount.setText("");  
			comLevelName.setSelectedItem(""); //창 초기화		
			ArrayList<CustomerDto> customers = dao.getCustomers();
			if(customers.size()!=0) { // 출력
				txtPool.setText("ID\t전화\t이름\t포인트\t 구매누적액\t고객레벨\t레벨업을위한추가구매액 \n"); // 스트링 입력으로 범주 목록 생성
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append로 줄치기
				for(CustomerDto cusdto : customers) {
					txtPool.append(cusdto.toString()+"\n");
				}
			}else { // 에러출력
				txtPool.setText("유효하지 않은 입력값입니다.");
			}
		}else if(e.getSource() == btnInsert) { // 회원가입
			String ctel, cname;
			try {
				ctel = txtCtel.getText().trim();
				cname = txtCname.getText().trim();
				if(cname.length()<2) {
					txtCname.setText("");
					txtPool.setText("올바른 이름을 입력하시오 ");
					return;
				 int result = dao.insertCustomer (ctel, cname); //DAO에서 포인트 함수 가져오기
					if(result ==CustomerDao.SUCCESS) { //DAO의 값이 성공이면!
						
						txtPool.setText("회원가입 성공!\n 포인트 1000점을 가입선물로 드립니다"); //회원가입 성공메시지

					}else {
						txtPool.setText("유효한 입력값이 아닙니다.");
					}
			} catch (Exception e2) {
				txtCid.setText(""); 
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");
				txtPool.setText("유효한 값을 입력해주시기 바랍니다. ");
			}
			
		}else if(e.getSource() == btnCtelUpdate) { // 전화번호 수정
			int cid;
			String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("입력하신 전화번호를 다시한번 확인해주세요");
					return;
				}
				 int result = dao.updateCustomerCtel(cid, ctel); //DAO에서 포인트 함수 가져오기
					if(result ==CustomerDao.SUCCESS) { //DAO의 값이 성공이면!
						
						txtPool.setText("전화번호 수정 성공!"); //회원가입 성공메시지

					}else {
						txtPool.setText("유효한 입력값이 아닙니다.");
					}
			} catch (Exception e2) {
				txtCid.setText(""); 
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");
				txtPool.setText("유효한 ID 값을 입력해주시기 바랍니다. ");
			}
		}else if(e.getSource() == btnDelete) { // 회원 탈퇴
			String ctel;
			try {
				  ctel = txtCtel.getText().trim();
				 int result = dao.deleteCustomer(ctel); //DAO에서 포인트 함수 가져오기
					if(result ==CustomerDao.SUCCESS) { //DAO의 값이 성공이면!					
						txtPool.setText("회원 탈퇴 성공!"); //회원 탈퇴 성공메시지

					}else {
						txtPool.setText("유효한 입력값이 아닙니다.");
					}
			} catch (Exception e2) {
				txtCid.setText(""); 
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");
				txtPool.setText("유효한 값을 입력해주시기 바랍니다. ");
			}
		}else if(e.getSource() == btnExit) { // 종료
			setVisible(false); //눈에 안보임
			dispose(); //데이터 삭제
			System.exit(0);// 창 삭제	
		}
	}
	public static void main(String[] args) {
		new SupermarketGUI("슈퍼마켓");
	}
	
// 초기화 입력값 미리 내놓기 ㅋㅋ	
//	txtCid.setText(""); 
//	txtCtel.setText("");  
//	txtCname.setText(""); 
//	txtCpoint.setText(""); 
//	txtCamount.setText("");  
//	comLevelName.setSelectedItem("");
 
}