package com.lec.ex08_Lib;

import java.util.Scanner;

public class LIb_TestMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890ㅁ-101-1ㄱ", "java", "홍길동"), new BookLib("746ㅅ-106-7ㅎ", "oracle", "신길동"),
				new BookLib("184ㅊ-291-4ㅂ", "mysql", "고길동"), new BookLib("866ㅍ-971-6ㅌ", "spring", "유길동"),
				new BookLib("890ㅊ-101-1ㄹ", "jsp", "무길동") };
		Scanner sc = new Scanner(System.in);
		int fn; // 기능번호 (1 : 대출 | 2:반납 | 3:책 목록 | 0:종료)
		int idx;// 대출하거나 반납하려고 할 때 조회된 책의 index
		String bTitle, borrower, checkOutDate; // 책이름, 대출인, 대출일
		do {
			System.out.print("1 : 대출 | 2:반납 | 3:책 목록 | 0:종료\t");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				// 대출 진행 1.책 제목 입력 2.책이 있는지 여부 조회 3. 책 상태 확인
				// 4.대출인 입력 5.대출일 입력 6.대출 메소드 호출
				System.out.println("대출하시고자 하는 책의 제목을 입력하세요.");
				bTitle = sc.next(); // white-space 앞까지의 스트링만 받음.
				// 2. 책 조회
				for (idx = 0; idx < books.length; idx++) {
					if ((books[idx].getBookTitle()).equals(bTitle)) {
						break;
					}
				} // 책 조회 for
				if (idx == books.length) { // 못 찾았단 이야기.
					System.out.println("현재 보유하지 않은 도서입니다.");
				} else { // books[idx] 도서를 대출 처리
							// 3. 책 상태 확인
					if (books[idx].getState() == BookLib.STATE_BORROWED) { // 대출 불가 상태
						System.out.println("현재 대출 중인 도서입니다.");
					} else {// 대출 가능 상태
							// 4.대출인 입력 5.대출일 입력 6.대출 메소드 호출
						System.out.print("대출하시는 분의 성함을 입력해주세요. : ");
						borrower = sc.next();
						System.out.print("오늘 날짜를 입력해주세요. : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				} // if
				break;

			case 2: // 반납 진행 : 1. 책 제목 2. 책 조회 3. 반납 처리
				System.out.print("반납하실 책의 제목을 입력하시오 . : "); // 1. 책 제목.
				bTitle = sc.next();
				// 2. 책 조회.
				for (idx=0; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}//if 구문
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				}else {//idx가 찾은 위치.
					   //3. 반납
					   books[idx].checkIn();
				}// if else 반납 구문
				break;
			case 3: // 책 목록 출력
				System.out.println("책 목록은 다음과 같습니다.");
				for (BookLib bks : books) {
					bks.toString();
				}
				break;
			}// switch

		} while (fn != 0);
		System.out.println("감사합니다. 안녕히 가십시오.");
//	    while(true) {
//	    	System.out.println("1 : 대출 | 2:반납 | 3:책 목록 | 0:종료");
//	    	fn = sc.nextInt();
//	    	if(fn==0) {
//	    		break;
//	    	}//if
//	    }//while
	}// main
}// class
