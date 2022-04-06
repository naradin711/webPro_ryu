package com.lec.ex01_Runnable;
// �ȳ��ϼ��� �ݰ����ϴ� 10�� ���ÿ� ��
public class TargetTestMain {
	public static void main(String[] args) {
		Runnable t1 = new TargetEx01();
		Runnable t2 = new TargetEx02(); // �� ��ü �� ���ʺ� Ÿ��
		// "A"��� �̸��� ������ ����.
		Thread threadA = new Thread (t1, "A");
		// "B"��� �̸��� ������ ����.
		Thread threadB = new Thread (t2, "B");
		threadA.start();
		threadB.start();
		for(int i = 0; i <10 ; i ++) {
			System.out.println("���� " + Thread.currentThread().getName()+i);
		}// Thread.currentThread().getName() ������ ������ �̸�.
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		//������ �� ���� �Ź� �޶���.
	}

}
