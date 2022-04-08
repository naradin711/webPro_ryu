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
	private Container  contenPane; // �����̳� ���� ����
    private JPanel     jp1; //�̸� ��ȭ ���� ������
    private JPanel     jp2; // �Է� ��� ��ư ������
    private JTextField txtName, txtTel, txtAge;
    private ImageIcon  iconIn, iconOut;
    private JButton    btnIn;
    private JButton    btnOut;
    private int        cnt ;
    ArrayList<Person> pp = new ArrayList<Person>(); // �ش� ����Ʈ�� �ٱ����� ���� ���� ��� �Լ��� ����ǵ��� ���µ��� �ʵ��� �Ѵ�.
    public MyFrame (String title) {
       super(title);
       setDefaultCloseOperation(EXIT_ON_CLOSE);//x��ư ������ ������� ��.
       contenPane = getContentPane(); //�����̳� ��� �����!
       jp1 = new JPanel(new GridLayout(3,2));
       jp2 = new JPanel(new FlowLayout());
       txtName    = new JTextField();                // �̸��� �Է��� �ؽ�Ʈ �ʵ� ��ü ����
	   txtTel     = new JTextField();                // ��ȭ��ȣ�� �Է��� �ؽ�Ʈ �ʵ� ��ü ����
	   txtAge     = new JTextField();
	   iconIn     = new ImageIcon ("src/icon/join.png"); 
	   iconOut    = new ImageIcon ("src/icon/output.png");
	   btnIn      = new JButton ("�Է�", iconIn);
	   btnOut     = new JButton ("���", iconOut);
	   jp1.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT)); //�̸� �� ������ ��� ����
	   jp1.add(txtName);                                    // �̸��� �Է��� �ؽ�Ʈ �ʵ� ����
	   jp1.add(new JLabel("��  ȭ", (int) CENTER_ALIGNMENT)); //��ȭ �� ������ ��� ����
	   jp1.add(txtTel);                                     // ��ȭ��ȣ�� �Է��� �ؽ�Ʈ �ʵ� ����
	   jp1.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT)); //���� �� ������ ��� ����
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
					System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�.");
					return;
				}
			    int age = 0;
			    try {
					age = Integer.parseInt(txtAge.getText());	//txtAge�� �Է��� �������� ���ڿ�ȭ ��Ŵ
					if(age <0 || age>150) {
						System.out.println("��ȿ���� ���� ���̸� �Է��ϼ̽��ϴ�.");
						age = 0; // ��ȿ���� ���� ���̴� age ���� 0���� ���.
					}
				}catch(Exception e1) {
					System.out.println("��ȿ���� ���� ���̸� �Է��ϼ̽��ϴ�.");
				}
			    pp.add(new Person(name, tel, age));
			    break;
			}while(true); 
			txtName.setText(""); // �� �Է� �ؽ�Ʈ�ʵ� �ʱ�ȭ
			txtTel.setText("");  // �� �Է� �ؽ�Ʈ�ʵ� �ʱ�ȭ
			txtAge.setText("");  // �� �Է� �ؽ�Ʈ�ʵ� �ʱ�ȭ
		}
		if(e.getSource()== btnOut) {
			OutputStream os = null;
			try {
				os = new FileOutputStream("src/com/lec/ex02_Swing/Person.txt",true);
			    for (Person p : pp) {
			    	System.out.println(p);
			    	os.write(p.toString().getBytes());
			    }
			    System.out.println("���� "+pp.size()+"���� ȸ���� �����Ͽ����ϴ�.");
				   String str1 = "\n���� "+pp.size()+"���� ȸ���� �����Ͽ����ϴ�.";
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
		new MyFrame("GUI ����");

	}//main

}//class






