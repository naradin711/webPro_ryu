package com.lec.ex04_object;
import java.util.Random;
//♠◆♣♥ 모양에 1-13숫자
public class Ex03_Card_TestMain {

	public static void main(String[] args) {
		Card[] cards = { new Card ('◆', 1),
				new Card ('◆', 3),
				new Card ('◆', 5),
				new Card ('◆', 12)
		                };
		for (Card card : cards) {
			System.out.println(card);
		}
		Random rd = new Random();
		char [] kinds = {'♠', '◆', '♣', '♥'};
		Card comCard = new Card (kinds[rd.nextInt(4)], rd.nextInt(13)+1);
		System.out.println("무작위로 선택된 카드 : "+comCard);
		if(cards[2].equals(comCard)) {
			System.out.println("두 카드는 일치합니다.");
		}else {
			System.out.println("두 카드는 불일치합니다.");
		}
	}

}
