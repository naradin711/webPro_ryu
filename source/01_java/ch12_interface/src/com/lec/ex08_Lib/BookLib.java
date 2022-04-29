package com.lec.ex08_Lib;
// Book b1 = new Book("å��ȣ", "å����", "å ����")
public class BookLib extends BookInfo implements ILendable {
   private String borrower;     // ������
   private String checkOutDate; // ������
   private byte state;          // ���� ���� ������(1) ���Ⱑ��(0)	
    public BookLib(String bookNo, String bookTitle, String writer) {
	  super(bookNo,bookTitle,writer);
	  
   }// b.checkout("�ű浿","01-89"); ���� : ���¸� Ȯ���ؼ� ���� ���̸� �ߴ�, ���� �����̸� ����ó��.
	@Override
	public void checkOut(String borrower, String checkOutDate) {
	   if(state == STATE_BORROWED) { //���� ���̸� �޽��� �Ѹ��� ��.
		    System.out.println(getBookTitle()+" ������ �������Դϴ�.");
		    return;
	   }else { // ���� �����̸� ���� ó��. state�� 0�̸� ����ó�� ����.
		  this.borrower = borrower;
		  this.checkOutDate = checkOutDate;
		  state = STATE_BORROWED; //������ ���·� ��ȯ!
		  System.out.println(getBookTitle()+" ������ ���� ó���Ǿ����ϴ�.");
		  System.out.println("������ : "+borrower+"\t������ : "+checkOutDate);
	   }
	}
    // b.checkIn() : state Ȯ���ؼ� ���Ⱑ�� ���� ����();
	// ���Ⱑ��(0)�̸� �޽��� �Ѹ��� �ߴ�, 
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
		System.out.println(getBookTitle() + "�ش� ������ �̹� �ݳ� �Ϸ�� å�Դϴ�.");
		return;
		}//state�� ������(1)�̸� �ݳ� ����.
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");

	}
    // b.printState() => å��ȣ å ���� (����) ���� ��
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
























