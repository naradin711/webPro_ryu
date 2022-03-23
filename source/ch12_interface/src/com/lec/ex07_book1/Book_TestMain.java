package com.lec.ex07_book1;

import java.util.Scanner;

public class Book_TestMain {
	public static void main(String[] args) {
		Book[] books = { new Book("890��-101-1��", "java", "ȫ�浿"), new Book("746��-106-7��", "oracle", "�ű浿"),
				new Book("184��-291-4��", "mysql", "��浿"), new Book("866��-971-6��", "spring", "���浿"),
				new Book("890��-101-1��", "jsp", "���浿") };
		Scanner sc = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1 : ���� | 2:�ݳ� | 3:å ��� | 0:����)
		int idx;// �����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate; // å�̸�, ������, ������
		do {
			System.out.print("1 : ���� | 2:�ݳ� | 3:å ��� | 0:����\t");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				// ���� ���� 1.å ���� �Է� 2.å�� �ִ��� ���� ��ȸ 3. å ���� Ȯ��
				// 4.������ �Է� 5.������ �Է� 6.���� �޼ҵ� ȣ��
				System.out.println("�����Ͻð��� �ϴ� å�� ������ �Է��ϼ���.");
				bTitle = sc.next(); // white-space �ձ����� ��Ʈ���� ����.
				// 2. å ��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if ((books[idx].getBookTitle()).equals(bTitle)) {
						break;
					}
				} // å ��ȸ
				if (idx == books.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				} else { // books[idx] ������ ���� ó��
							// 3. å ���� Ȯ��
					if (books[idx].getState() == Book.STATE_BORROWED) { // ���� �Ұ� ����
						System.out.println("���� ���� ���� �����Դϴ�.");
					} else {// ���� ���� ����
							// 4.������ �Է� 5.������ �Է� 6.���� �޼ҵ� ȣ��
						System.out.print("�����Ͻô� ���� ������ �Է����ּ���. : ");
						borrower = sc.next();
						System.out.print("���� ��¥�� �Է����ּ���. : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				} // if
				break;

			case 2: // �ݳ� ����
				System.out.println("�ݳ� �����ϴ� ���� �� ����");
				break;
			case 3: // å ��� ���
				System.out.println("å ����� ������ �����ϴ�.");
				for (Book bks : books) {
					bks.printState();
				}
				break;
			}// swich

		} while (fn != 0);
		System.out.println("�����մϴ�. �ȳ��� ���ʽÿ�.");
//	    while(true) {
//	    	System.out.println("1 : ���� | 2:�ݳ� | 3:å ��� | 0:����");
//	    	fn = sc.nextInt();
//	    	if(fn==0) {
//	    		break;
//	    	}//if
//	    }//while
	}// main
}// class
