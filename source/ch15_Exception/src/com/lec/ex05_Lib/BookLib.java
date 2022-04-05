package com.lec.ex05_Lib;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class BookLib implements ILendable {
	private String bNo;       //책번호
	private String bTitle;    //책제목
	private String writer;    //저자
	private String borrower;  //대출인
	private Date cDate;       //대출일
	private byte state; // 대출중 1 대출가능0

	public BookLib(String bNo, String bTitle, String writer) {
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.writer = writer;
	}
    // BookLib book = new BookLib("89a-09", "java", "김독자")
	// book.checkOut("유중혁") 도서상태 확인 - 대출로직 - 도서상태 출력

	@Override
	public void checkOut(String borrower) throws Exception {
		if(state == BORROWED) {
			throw new Exception(bTitle+ "도서는 대출중 입니다."); //강제로 예외발생
		} // 대출로직
		this.borrower =borrower;
		cDate = new Date (); // 날짜 체크
		state = BORROWED;    // 상태 변경
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-M-d");
		System.out.println("\"" + bTitle + "\"" +"\"\t도서가 대출 되었습니다." );
		System.out.println("대출인 :" +borrower +"\t대출일 : "+sdf.format(cDate)+"\n2주 이내로 반납하세요." );
	}
	//  book.checkIn() 도서 상태 확인 -> 연체여부 확인 (14<대출일)
	//  연체되었을 경우 연체료 납부 y/n

	@Override
	public void checkIn() throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		if(state==NORMAL) {
		   throw new Exception(bTitle+"도서는 대출중이 아닙니다.");
		}
		// 연체 여부 확인 cDate ~ 현재가지 14일 이내인지 여부 확인.
		Date now = new Date();
		long diff = now.getTime()- cDate.getTime();// 대출 시점부터 현재가지의 밀리세컨
		long day = diff/ (1000*60*60*24);
		if (day>14) {//연체된 경우.
			System.out.println("연체료는 일일 100원 부가됩니다. 결제하실 연체료는 "+(day-14)*100+"원 입니다.");
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료를 내셨습니까? (Y/N)\t");
			if(! sc.next().equalsIgnoreCase("y")) { // 연체료를 안냈다고 하는 경우 Y/y입니다.
				System.out.println("연체료를 결제하셔야 반납처리가 가능합니다.");
				return;
			}
			
		} //반납 로직
		borrower = null;
		cDate = null;
		state = NORMAL;
		System.out.println("\""+bTitle+"\"\t도서가 반납되었습니다.");
	}

	@Override
	public String toString() {
	  String msg ="책번호 :" + bNo + ", 책제목 " + bTitle + ", 저자 " + writer+ "  ";
	  msg +=(state==NORMAL)? "대출 가능" : "대출중";
      if (state == BORROWED) {
    	 Date date = new Date(cDate.getTime()+(1000*60*60*24*14));
    	 SimpleDateFormat sdf = new SimpleDateFormat(" (반납예정일 : yyyy-M-d(E))");
    	 msg += sdf.format(date); 
      }
      return msg;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}	
	
}
















































