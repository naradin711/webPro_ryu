package com.lec.ex08_Lib;
// Book b1 = new Book("책번호", "책제목", "책 저자")
public class BookLib extends BookInfo implements ILendable {
   private String borrower;     // 대출인
   private String checkOutDate; // 대출일
   private byte state;          // 대출 상태 대출중(1) 대출가능(0)	
    public BookLib(String bookNo, String bookTitle, String writer) {
	  super(bookNo,bookTitle,writer);
	  
   }// b.checkout("신길동","01-89"); 대출 : 상태를 확인해서 대출 중이면 중단, 대출 가능이면 대출처리.
	@Override
	public void checkOut(String borrower, String checkOutDate) {
	   if(state == STATE_BORROWED) { //대출 중이면 메시지 뿌리고 끝.
		    System.out.println(getBookTitle()+" 도서는 대출중입니다.");
		    return;
	   }else { // 대출 가능이면 대출 처리. state가 0이면 대출처리 진행.
		  this.borrower = borrower;
		  this.checkOutDate = checkOutDate;
		  state = STATE_BORROWED; //대출중 상태로 전환!
		  System.out.println(getBookTitle()+" 도서가 대출 처리되었습니다.");
		  System.out.println("대출인 : "+borrower+"\t대출일 : "+checkOutDate);
	   }
	}
    // b.checkIn() : state 확인해서 대출가능 여부 묻기();
	// 대출가능(0)이면 메시지 뿌리고 중단, 
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
		System.out.println(getBookTitle() + "해당 도서는 이미 반납 완료된 책입니다.");
		return;
		}//state가 대출중(1)이면 반납 진행.
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " 도서가 반납 완료되었습니다.");

	}
    // b.printState() => 책번호 책 제목 (저자) 대출 중
	public String toString() {
		return getBookNo() + "\t"+getBookTitle()+" ("+getWriter()+")"+"지음";	
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
}
























