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
	 	btnCidSearch 		= new JButton("���̵� �˻�"); 
	 	btnCtelSearch		= new JButton("��4�ڸ�(FULL)�˻�");
	 	btnCnameSearch 		= new JButton("�� �̸� �˻�"); 
	 	btnBuyWithPoint		= new JButton("����Ʈ�θ� ����");
	 	btnBuy				= new JButton("��ǰ ����"); 
	 	btnLevelNameOutput	= new JButton("��޺����"); 
	 	btnAllOutput		= new JButton("��ü ���"); 	
	 	btnInsert			= new JButton("ȸ������");
	 	btnCtelUpdate 		= new JButton("��ȣ����"); 
	 	btnDelete 			= new JButton("ȸ��Ż��"); 
	 	btnExit				= new JButton("������");
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