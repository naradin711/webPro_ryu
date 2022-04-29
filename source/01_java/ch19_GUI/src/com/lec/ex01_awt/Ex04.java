package com.lec.ex01_awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Ex04 extends Frame implements ActionListener {
   private Panel panel;
   private TextField txtfield;
   private Button btnOk, btnExit;
   private List list;
   public Ex04() {//layout setting, creating component add, setVisible, setSize
   // setLayout(new BorderLayout()); //�⺻ ���̾ƿ����� ��������.
      panel = new Panel(); //�г��� �⺻ ���̾ƿ��� FlowLayout���� ����
      txtfield = new TextField(20);
      btnOk = new Button (" OK ");
      btnExit = new Button("EXIT");
      list = new List();
      panel.add(new Label("write"));
      panel.add(txtfield);
      panel.add(btnOk);
      panel.add(btnExit);
      add(panel, BorderLayout.NORTH);
      add(list, BorderLayout.CENTER);
      setVisible(true);
      setSize(new Dimension(350,150));
      setLocation(150, 150);
      //x Ŭ���� ����.
      addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    		setVisible(false); //�Ⱥ��̰�
    		dispose();         // �ڿ�����
    		System.exit(0);    // ��������
    	}
	  });
      // �̺�Ʈ �߰�  1. implements ActionListener -> override
      //          2. �̺�Ʈ �����ʸ� �߰��մϴ�.
      btnOk.addActionListener(this); // ���⼭ ���̵� �޼ҵ��� �׼� ������ �ڵ� ȣ��
      btnExit.addActionListener(this);
      //          3. �������̵��� action �޼ҵ忡 �����߰�
   }
   public Ex04(String title) {
	 this();
	 setTitle(title);
   }
   public static void main(String[] args) {
	  new Ex04();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnOk) { // ok��ư Ŭ���� �� ���� : txtfield�� �ؽ�Ʈ�� list�� �߰� 
    	  list.add(txtfield.getText().trim().toUpperCase()); //�� �� ���� ���� ��� ���� �빮��
    	  txtfield.setText("");
      }else if (e.getSource()==btnExit) {// exit��ư Ŭ���� �� ����
    	  setVisible(false); // �Ⱥ��̰�
  		  dispose();         // �ڿ�����
  		  System.exit(0);    // ��������
      }
      
	}
}












