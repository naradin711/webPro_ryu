package com.lec.ex01_Runnable;
// �ȳ��ϼ���. �ݰ����ϴ�. ���ÿ� ó��.
// "�ȳ��ϼ��� 10��" �ϴ� target.
public class TargetEx02 implements Runnable {

	@Override
	public void run() {
		for (int i=0; i<10 ; i++) {
			System.out.println( i + "��° �ݰ����ϴ�.");
			try { // 0.5�� ���� ��� ���·� ����
				Thread.sleep(500);
			} catch (InterruptedException e) { } 
		}
	}

}
