package com.lec.ex09_Lib2;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;     // 대출인
	private String checkOutDate; // 대출일
	private byte state;          // 대출 상태 대출중(1) 대출가능(0)	
	public CDLib() {}
	public CDLib(String cdNo, String cdTitle) {
		super(cdNo, cdTitle);
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { //대출 중이면 메시지 뿌리고 끝.
		    System.out.println(getCdTitle()+" 도서는 대출중입니다.");
		    return;
	   }else { // 대출 가능이면 대출 처리. state가 0이면 대출처리 진행.
		  this.borrower = borrower;
		  this.checkOutDate = checkOutDate;
		  state = STATE_BORROWED; //대출중 상태로 전환!
		  System.out.println(getCdTitle()+" 도서가 대출 처리되었습니다.");
		  System.out.println("대출인 : "+borrower+"\t대출일 : "+checkOutDate);
	   }//if else
	}//void checkOut

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getCdTitle() + "해당 도서는 이미 반납 완료된 책입니다.");
			return;
			}//state가 대출중(1)이면 반납 진행.
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(getCdTitle() + " 도서가 반납 완료되었습니다.");	
	}
	public String toString() {
		return getCdNo() + "\t"+getCdTitle();	
    }
}