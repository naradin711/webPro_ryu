package com.lec.ex02_Swing;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ex01_Thursday extends JFrame implements ActionListener{
   private JPanel panel; // �޾ƿ� �����̳ʸ� ����.
   private JLabel jlbl;
   //private Container conPanel;// �޾ƿ� �����̳ʸ� ����.
   private JButton jbtn;
   //private JTextField txtF = new JTextField();
	
   public Ex01_Thursday() {
	}
   public Ex01_Thursday(String title) {
	   super(title);
	   setDefaultCloseOperation(EXIT_ON_CLOSE); // x ��ư Ŭ���� �������
	   panel = (JPanel) getContentPane();
	   panel.setLayout(new FlowLayout());
	   jlbl = new JLabel("��ſ� �����", (int) CENTER_ALIGNMENT);
	   jbtn = new JButton("EXIT");
	   panel.add(jlbl);// null ������ ���� �㶧 �ش� ������Ʈ�� ������ ����� �Ǿ��ִ��� Ȯ��
	   jlbl.setPreferredSize(new Dimension(150,200));
	   panel.add(jbtn);
	   jbtn.setPreferredSize(new Dimension(200,200));
	   setVisible(true);
	   setSize(new Dimension(400,250));
	   setLocation(200, 200);
	   //�̺�Ʈ ������ �߰�
	   jbtn.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbtn) {// exit��ư Ŭ���� �� ����
	    	  setVisible(false); // �Ⱥ��̰�
	  		  dispose();         // �ڿ�����
	  		  System.exit(0);    // ��������
	      }
	}
	
	public static void main(String[] args) {
		new Ex01_Thursday("title");
	}

	
}



















