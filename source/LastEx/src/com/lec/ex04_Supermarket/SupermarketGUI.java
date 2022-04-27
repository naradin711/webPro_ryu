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
		jpup.add(new JLabel("���̵�",(int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("����ȭ",(int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("���̸�",(int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("����Ʈ",(int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("���űݾ�",(int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel("  ",(int) CENTER_ALIGNMENT));
		jpup.add(new JLabel("�����",(int) CENTER_ALIGNMENT));
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
		
		txtPool.setText("\t\t�ڡڡڡڡڡ� �� �˻� �� �����ϼ��� �ڡڡڡڡڡ�");
		
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
		if(e.getSource() == btnCidSearch) { // ���̵� �˻�
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText("");  
				comLevelName.setSelectedItem(""); 
			String cidStr = txtCid.getText().trim(); // ���̵� �Է�â�� ���� �¿쿩����� ����
			int cid = Integer.parseInt(cidStr);	 // ���̵� �Է�â�� ���� ���������� ġȯ��.
			CustomerDto customer = dao.cidGetCustomer(cid); //dto �ش��ϴ�  customer ���� ���� dao���� ���̵� �˻� ���ǿ� �ش� ������ �ְ� ����
			if(customer!=null) { // �ش� dto�� null�� �ƴϸ�!
				txtCtel.setText(customer.getCtel()); // ��ȭ��ȣ�Է�â�� ��ȣ ���
				txtCname.setText(customer.getCname()); // �̸��Է�â�� �̸� ���
				txtCpoint.setText(String.valueOf(customer.getCpoint())); // ����Ʈ �Է�â�� ����Ʈ ��� �̶� ����Ʈ�� �ؽ�Ʈ�� ���������� ��ȯ!
				comLevelName.setSelectedItem(customer.getLevelName()); // �޺��ڽ��� �ش� ��� �̸� �߰�
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t ���Ŵ�����\t������\t�������������߰����ž� \n"); // ��Ʈ�� �Է����� ���� ��� ����
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append�� ��ġ��
				txtPool.append(customer.toString()); //append�� �ش� dto�� toString() �޾Ƽ� ���
			}else {
 				txtCid.setText(""); 
 				txtCtel.setText("");  
 				txtCname.setText(""); 
 				txtCpoint.setText("");  
 				txtCamount.setText("");  
 				comLevelName.setSelectedItem(""); //â �ʱ�ȭ
				txtPool.setText("�������� �ʴ� ID�Դϴ�.");// �����޽��� ����
			}
		}else if(e.getSource() == btnCtelSearch) { // ��4�ڸ� �˻�
				txtCid.setText(""); 
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");  
				comLevelName.setSelectedItem(""); //â �ʱ�ȭ		
				String ctel = txtCtel.getText().trim();
				if(ctel.length()>4) {
					txtPool.setText("4�ڸ��� ���ӵ� ��ȣ�� 010-0000-0000 ���� �������� ��ȭ��ȣ�� �Է��Ͻʽÿ�. ");
					return;
				}//if
				ArrayList<CustomerDto> customers = dao.getCtelSearch(ctel);
				if(customers.size()!=0) { // ���
					txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t ���Ŵ�����\t������\t�������������߰����ž� \n"); // ��Ʈ�� �Է����� ���� ��� ����
					txtPool.append("------------------------------------------------------------------------------"
							+ "-----------------------------------------------------------------------------------------------------------\n");// append�� ��ġ��
					for(CustomerDto cusdto : customers) {
						txtPool.append(cusdto.toString()+"\n");
					}
				}else { // �������
					txtCtel.setText(""); 
					txtPool.setText("�ش��ϴ� ��ȭ��ȣ�� ���� �˻����� �ʽ��ϴ�.");
				}
			
		}else if(e.getSource() == btnCnameSearch) { // ����
			txtCid.setText(""); 
			txtCtel.setText(""); 
			txtCpoint.setText(""); 
			txtCamount.setText("");  
			comLevelName.setSelectedItem(""); //â �ʱ�ȭ		
			String cname = txtCname.getText().trim();
			if(cname.length()<1) {
				txtCname.setText("");
				txtPool.setText("�ùٸ� �̸��� �Է��Ͻÿ� ");
				return;
			}//if
			ArrayList<CustomerDto> customers = dao.getCnameSearch(cname);
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t ���Ŵ�����\t������\t�������������߰����ž� \n"); // ��Ʈ�� �Է����� ���� ��� ����
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append�� ��ġ��
				for(CustomerDto cusdto : customers) {
					txtPool.append(cusdto.toString()+"\n");
				}
			}else { // �������
				txtCname.setText(""); 
				txtPool.setText("�ش��ϴ� �̸��� ���� �˻����� �ʽ��ϴ�.");
			}
			
		}else if(e.getSource() == btnBuyWithPoint) { // ����Ʈ�θ� ����
			int cid, cpoint, camount; //���̵� ����Ʈ ���űݾ� Ʈ���̱��� �ۿ��� ���� �����ֱ�
			// try catch �������� �μ�Ʈ ���� ����
			try {
				 cid = Integer.parseInt(txtCid.getText().trim());
				 cpoint = Integer.parseInt(txtCpoint.getText().trim());
				 camount = Integer.parseInt(txtCamount.getText().trim());
				 if(cpoint < camount) { // ����Ʈ�� ������ ���
					 txtPool.setText("����Ʈ�� �����Ͽ� ���Ű� �Ұ����մϴ�. ");
					 return;
				 } // IF�� ����
				 int result = dao.buyWithPoint(cid, camount); //DAO���� ����Ʈ �Լ� ��������
					if(result ==CustomerDao.SUCCESS) { //DAO�� ���� �����̸�!
						txtPool.setText("����Ʈ ���ż���"); //���ż����޽���
						txtCpoint.setText(String.valueOf(cpoint-camount)); //����Ʈ�Է�â�� �پ�� ����Ʈ ����ϱ�
					}else {
						txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
					}
			} catch (Exception e2) {
 				txtCid.setText(""); 
 				txtCtel.setText("");  
 				txtCname.setText(""); 
 				txtCpoint.setText(""); 
 				txtCamount.setText("");
				txtPool.setText("��ȿ�� �� ID , POINT, ���űݾ��� �Է����ֽñ� �ٶ��ϴ�. ");
			}	
		}else if(e.getSource() == btnBuy) { // ����
			int cid, camount; //���̵� ����Ʈ ���űݾ� Ʈ���̱��� �ۿ��� ���� �����ֱ�
			// try catch �������� �μ�Ʈ ���� ����
			try {
				 cid = Integer.parseInt(txtCid.getText().trim());
				 camount = Integer.parseInt(txtCamount.getText().trim());
				 int result = dao.buy(cid, camount); //DAO���� ����Ʈ �Լ� ��������
					if(result ==CustomerDao.SUCCESS) { //DAO�� ���� �����̸�!
						txtPool.setText("���� ���ż���"); //���ż����޽���
					}else {
						txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
					}
			} catch (Exception e2) {
 				txtCid.setText(""); 
 				txtCtel.setText("");  
 				txtCname.setText(""); 
 				txtCpoint.setText(""); 
 				txtCamount.setText("");
				txtPool.setText("��ȿ�� �� ID , ���űݾ��� �Է����ֽñ� �ٶ��ϴ�. ");
			}
			
		}else if(e.getSource() == btnLevelNameOutput) { // ��޺� ���
			txtCid.setText(""); 
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText(""); 
			txtCamount.setText(""); //â �ʱ�ȭ	 
			String levelName = comLevelName.getSelectedItem().toString(); 	
			if(levelName.length()==0) {
				txtCid.setText(""); 
				txtCtel.setText("");
				txtCname.setText("");
				txtCpoint.setText(""); 
				txtCamount.setText(""); 
				txtPool.setText("���Ͻô� ����� �����Ͻð� �˻��ϼ���");
			}
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t ���Ŵ�����\t������\t�������������߰����ž� \n"); // ��Ʈ�� �Է����� ���� ��� ����
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append�� ��ġ��
				for(CustomerDto cusdto : customers) {
					txtPool.append(cusdto.toString()+"\n");
				}
			}else { // �������
				txtPool.setText("��ȿ���� ���� �Է°��Դϴ�.");
			}
		}else if(e.getSource() == btnAllOutput) { // ��ü���
			txtCid.setText(""); 
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText(""); 
			txtCamount.setText("");  
			comLevelName.setSelectedItem(""); //â �ʱ�ȭ		
			ArrayList<CustomerDto> customers = dao.getCustomers();
			if(customers.size()!=0) { // ���
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t ���Ŵ�����\t������\t�������������߰����ž� \n"); // ��Ʈ�� �Է����� ���� ��� ����
				txtPool.append("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------\n");// append�� ��ġ��
				for(CustomerDto cusdto : customers) {
					txtPool.append(cusdto.toString()+"\n");
				}
			}else { // �������
				txtPool.setText("��ȿ���� ���� �Է°��Դϴ�.");
			}
		}else if(e.getSource() == btnInsert) { // ȸ������
			String ctel, cname;
			try {
				ctel = txtCtel.getText().trim();
				cname = txtCname.getText().trim();
				if(cname.length()<2) {
					txtCname.setText("");
					txtPool.setText("�ùٸ� �̸��� �Է��Ͻÿ� ");
					return;
				 int result = dao.insertCustomer (ctel, cname); //DAO���� ����Ʈ �Լ� ��������
					if(result ==CustomerDao.SUCCESS) { //DAO�� ���� �����̸�!
						
						txtPool.setText("ȸ������ ����!\n ����Ʈ 1000���� ���Լ����� �帳�ϴ�"); //ȸ������ �����޽���

					}else {
						txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
					}
			} catch (Exception e2) {
				txtCid.setText(""); 
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");
				txtPool.setText("��ȿ�� ���� �Է����ֽñ� �ٶ��ϴ�. ");
			}
			
		}else if(e.getSource() == btnCtelUpdate) { // ��ȭ��ȣ ����
			int cid;
			String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("�Է��Ͻ� ��ȭ��ȣ�� �ٽ��ѹ� Ȯ�����ּ���");
					return;
				}
				 int result = dao.updateCustomerCtel(cid, ctel); //DAO���� ����Ʈ �Լ� ��������
					if(result ==CustomerDao.SUCCESS) { //DAO�� ���� �����̸�!
						
						txtPool.setText("��ȭ��ȣ ���� ����!"); //ȸ������ �����޽���

					}else {
						txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
					}
			} catch (Exception e2) {
				txtCid.setText(""); 
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");
				txtPool.setText("��ȿ�� ID ���� �Է����ֽñ� �ٶ��ϴ�. ");
			}
		}else if(e.getSource() == btnDelete) { // ȸ�� Ż��
			String ctel;
			try {
				  ctel = txtCtel.getText().trim();
				 int result = dao.deleteCustomer(ctel); //DAO���� ����Ʈ �Լ� ��������
					if(result ==CustomerDao.SUCCESS) { //DAO�� ���� �����̸�!					
						txtPool.setText("ȸ�� Ż�� ����!"); //ȸ�� Ż�� �����޽���

					}else {
						txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
					}
			} catch (Exception e2) {
				txtCid.setText(""); 
				txtCtel.setText("");  
				txtCname.setText(""); 
				txtCpoint.setText(""); 
				txtCamount.setText("");
				txtPool.setText("��ȿ�� ���� �Է����ֽñ� �ٶ��ϴ�. ");
			}
		}else if(e.getSource() == btnExit) { // ����
			setVisible(false); //���� �Ⱥ���
			dispose(); //������ ����
			System.exit(0);// â ����	
		}
	}
	public static void main(String[] args) {
		new SupermarketGUI("���۸���");
	}
	
// �ʱ�ȭ �Է°� �̸� ������ ����	
//	txtCid.setText(""); 
//	txtCtel.setText("");  
//	txtCname.setText(""); 
//	txtCpoint.setText(""); 
//	txtCamount.setText("");  
//	comLevelName.setSelectedItem("");
 
}