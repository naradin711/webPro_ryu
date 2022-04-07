package com.lec.ex01_awt;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
public class Ex02_LogIn extends Frame{
   private Label lbl1;
   private TextField txtId;
   private Label lbl2;
   private TextField txtPw;
   private Button btnLogin;
   public Ex02_LogIn(String title) {//Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� -> �̺�Ʈ
      super(title);
      //Frame�� ���̾ƿ� Ÿ�� : BorderLayout �� �� �� �� ���� ����� ��ġ�� �ȵ� 
      //                   FlowLayout (���ʿ��� ����������, ������ �Ʒ��� �������� ������Ʈ�� add �ȴ�.)
      //                   GridLayout (�� �� �� ��!)
      setLayout(new FlowLayout()); //Frame�� ���̾ƿ� ����. ������ �� ������ �������� ���̾ƿ��� ��ġ.
      lbl1 = new Label("���̵�   ");
      txtId = new TextField(20); //20 �������� �����ӿ� ����
      lbl2 = new Label("��й�ȣ");
      txtPw = new TextField(20);
      txtPw.setEchoChar('*');//��� ��ȣ�� �Է��� �� ��ǥ�� ����
      btnLogin = new Button("LOGIN");
      add(lbl1);
      add(txtId);
      add(lbl2);
      add(txtPw);
      add(btnLogin);
      setSize(new Dimension(300, 150));
      setLocation(200, 100);
      setVisible(true); //������� GUI ȯ�汸��
      setResizable(false); // ����ڰ� âũ�� ���� �Ұ�
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
   public Ex02_LogIn() {
	this("");
   }
   public static void main(String[] args) {
	  new Ex02_LogIn("Login");
   }
   
}
