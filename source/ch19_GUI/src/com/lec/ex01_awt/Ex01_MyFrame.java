package com.lec.ex01_awt;
import java.awt.*;
public class Ex01_MyFrame extends Frame {
   private Button btn;
   private Button btn1;
   public Ex01_MyFrame(String title){
	   super(title);
	   // ��ư 2���� �߰��� Frame ����.
	   btn = new Button("��ư 1");
	   btn1 = new Button("��ư 2");
	   add(btn, BorderLayout.NORTH);
	   add(btn1, BorderLayout.CENTER);
	   pack(); // �ּ����� ������
	   setVisible(true);// â�� ���̰� �Ѵ�.
	   setLocation(100, 50);
	   try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
	    setVisible(false); // ȭ�鿡 �Ⱥ��̰�
	    dispose();// �ڿ� ���� - �ش� ���α׷��� �����µ� �Ҵ��ϴ� �޸� ���� ���� 
	    System.exit(0);// ���� ����
    }
    public static void main(String[] args) {
		new Ex01_MyFrame("My first Java GUI");
	}
   
}
