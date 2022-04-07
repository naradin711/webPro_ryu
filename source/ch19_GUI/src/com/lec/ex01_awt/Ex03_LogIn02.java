package com.lec.ex01_awt;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
public class Ex03_LogIn02 extends Frame{
   private Panel panel;
   private Label lbl1;
   private TextField txtId;
   private Label lbl2;
   private TextField txtPw;
   private Button btnLogin;
   public Ex03_LogIn02(String title) {//Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� -> �̺�Ʈ
      super(title);
      //Frame�� ���̾ƿ� Ÿ�� : BorderLayout �� �� �� �� ���� ����� ��ġ�� �ȵ� 
      //                   FlowLayout (���ʿ��� ����������, ������ �Ʒ��� �������� ������Ʈ�� add �ȴ�.)
      //                   GridLayout (�� �� �� ��!)
      panel = new Panel();// �ƹ� ���� ������ �г��� �⺻ ���̾ƿ� : FlowLayout
      //setLayout(new GridLayout(2,2));
      lbl1 = new Label("���̵�   ");
      txtId = new TextField(20); //20 �������� �����ӿ� ����
      lbl2 = new Label("��й�ȣ");
      txtPw = new TextField(20);
      txtPw.setEchoChar('*');//��� ��ȣ�� �Է��� �� ��ǥ�� ����
      btnLogin = new Button("LOGIN");
      panel.add(lbl1);
      panel.add(txtId);
      panel.add(lbl2);
      panel.add(txtPw);
      panel.setPreferredSize(new Dimension(280,50));
      add(panel, BorderLayout.NORTH);
      add(btnLogin, BorderLayout.SOUTH);
      setSize(new Dimension(300, 150));
      setLocation(200, 100);
      setVisible(true); //������� GUI ȯ�汸��
      //x Ŭ���� ����.
      addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    		setVisible(false); //�Ⱥ��̰�
    		dispose();         // �ڿ�����
    		System.exit(0);    // ��������
    	}
	  });
   }
   public Ex03_LogIn02() {
	this("");
   }
   public static void main(String[] args) {
	  new Ex03_LogIn02("Login");
   }
   
}
