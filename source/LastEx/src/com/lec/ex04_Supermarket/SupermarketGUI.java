package com.lec.ex04_Supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SupermarketGUI extends JFrame {
	private Container contenPane;
	private JPanel  jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount ;
	private JComboBox<String> comLevelName;
	private JButton  btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint, btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	
	 
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
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		setSize(new Dimension(800, 400));
		setLocation(200, 150);
		setVisible(true);
		
		
	}
}