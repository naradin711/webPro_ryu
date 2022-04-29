package com.lec.ex09_Lib2;

public class BookLib extends BookInfo implements ILendable{
   private String borrower ;    // 대출인
   private String checkOutDate; // 대출일
   private byte state;          // 대출 상태 대출중 1 대출가능 0
   public BookLib() {}
   public BookLib(String bookNo, String bookTitle, String writer) {
	  super(bookNo,bookTitle,writer);
   }
   public void checkOut(String borrower, String checkOutDate) {
	  if(state == STATE_BORROWED) {//대출 중이면 메시지 뿌리고 마무리
		 System.out.println(getBookTitle()+" 도서는 대출중입니다.");
		 return;
	  }else { // 대출 가능(state == 0)이면 대출 처리 진행!
		 this.borrower = borrower;
		 this.checkOutDate = checkOutDate;
		 state = STATE_BORROWED; // 대출 중 상태로 전환!
		 System.out.println(getBookTitle()+" 도서가 대출 처리되었습니다.");
		 System.out.println("대출인 : "+ borrower +"\t대출일 :  "+checkOutDate);
	  }// if else 문
   }// void checkOut
   public void checkIn() {
	  if(state == STATE_NORMAL) {
	     System.out.println(getBookTitle()+" 해당 도서는 이미 반납 완료된 도서입니다.");
	  return;
	  }
	  borrower = null;
	  checkOutDate = null;
	  state = STATE_NORMAL;
	  System.out.println(getBookTitle()+" 해당 도서가 반납 완료되었습니다.");
   }
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
