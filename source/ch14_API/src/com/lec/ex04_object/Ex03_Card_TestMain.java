package com.lec.ex04_object;
import java.util.Random;
//���ߢ��� ��翡 1-13����
public class Ex03_Card_TestMain {

	public static void main(String[] args) {
		Card[] cards = { new Card ('��', 1),
				new Card ('��', 3),
				new Card ('��', 5),
				new Card ('��', 12)
		                };
		for (Card card : cards) {
			System.out.println(card);
		}
		Random rd = new Random();
		char [] kinds = {'��', '��', '��', '��'};
		Card comCard = new Card (kinds[rd.nextInt(4)], rd.nextInt(13)+1);
		System.out.println("�������� ���õ� ī�� : "+comCard);
		if(cards[2].equals(comCard)) {
			System.out.println("�� ī��� ��ġ�մϴ�.");
		}else {
			System.out.println("�� ī��� ����ġ�մϴ�.");
		}
	}

}
