package com.lec.ex01_awt;
import java.awt.*;
public class Ex00 {

	public static void main(String[] args) {
		Frame frame = new Frame("�ڹ� ù GUI ����");
		Button btn = new Button("��ư");
		frame.add(btn, BorderLayout.NORTH); // ��ư�� ����(NORTH)���ٰ� �߰��ϰ� ���� �� 
		Button btn1 = new Button("�׳� ��ư");
		frame.add(btn1, BorderLayout.CENTER); // �׳� ��ư�� �߾� CENTER�� �߰�!
	    frame.setSize(new Dimension(300,200));
	    frame.setVisible(true); // �ش� â�� ���ϼ� �ְ� ����
	    frame.setLocation(100, 50);
	    // 3�� �� �ڵ� â �ݰ� ���� �����ϱ�
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
	    frame.setVisible(false);
	    frame.dispose();// �ڿ� ���� - �ش� ���α׷��� �����µ� �Ҵ��ϴ� �޸� ���� ���� 
	    System.exit(0);// ���� ����

	}

}
