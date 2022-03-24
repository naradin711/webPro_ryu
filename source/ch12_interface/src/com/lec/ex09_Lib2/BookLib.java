package com.lec.ex09_Lib2;

public class BookLib extends BookInfo implements ILendable{
   private String borrower ;    // ������
   private String checkOutDate; // ������
   private byte state;          // ���� ���� ������ 1 ���Ⱑ�� 0
   public BookLib() {}
   public BookLib(String bookNo, String bookTitle, String writer) {
	  super(bookNo,bookTitle,writer);
   }
   public void checkOut(String borrower, String checkOutDate) {
	  if(state == STATE_BORROWED) {//���� ���̸� �޽��� �Ѹ��� ������
		 System.out.println(getBookTitle()+" ������ �������Դϴ�.");
		 return;
	  }else { // ���� ����(state == 0)�̸� ���� ó�� ����!
		 this.borrower = borrower;
		 this.checkOutDate = checkOutDate;
		 state = STATE_BORROWED; // ���� �� ���·� ��ȯ!
		 System.out.println(getBookTitle()+" ������ ���� ó���Ǿ����ϴ�.");
		 System.out.println("������ : "+ borrower +"\t������ :  "+checkOutDate);
	  }// if else ��
   }// void checkOut
   public void checkIn() {
	  if(state == STATE_NORMAL) {
	     System.out.println(getBookTitle()+" �ش� ������ �̹� �ݳ� �Ϸ�� �����Դϴ�.");
	  return;
	  }
	  borrower = null;
	  checkOutDate = null;
	  state = STATE_NORMAL;
	  System.out.println(getBookTitle()+" �ش� ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
   }
   public String toString() {
	   return getBookNo() + "\t"+getBookTitle()+" ("+getWriter()+")"+"����";
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
