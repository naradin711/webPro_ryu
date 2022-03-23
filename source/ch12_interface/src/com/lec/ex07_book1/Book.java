package com.lec.ex07_book1;
// Book b1 = new Book("å��ȣ", "å����", "å ����")
public class Book implements ILendable {
   private String bookNo;       // å��ȣ
   private String bookTitle;    // å����
   private String writer;       // ����
   private String borrower;     // ������
   private String checkOutDate; // ������
   private byte state;          // ���� ���� ������(1) ���Ⱑ��(0)	
    public Book(String bookNo, String bookTitle, String writer) {
	this.bookNo = bookNo;
	this.bookTitle = bookTitle;
	this.writer = writer;
   }// b.checkout("�ű浿","01-89"); ���� : ���¸� Ȯ���ؼ� ���� ���̸� �ߴ�, ���� �����̸� ����ó��.
	@Override
	public void checkOut(String borrower, String checkOutDate) {
	   if(state == STATE_BORROWED) { //���� ���̸� �޽��� �Ѹ��� ��.
		    System.out.println(bookTitle+" ������ �������Դϴ�.");
		    return;
	   }else { // ���� �����̸� ���� ó��. state�� 0�̸� ����ó�� ����.
		  this.borrower = borrower;
		  this.checkOutDate = checkOutDate;
		  state = STATE_BORROWED; //������ ���·� ��ȯ!
		  System.out.println(bookTitle+" ������ ���� ó���Ǿ����ϴ�.");
		  System.out.println("������ : "+borrower+"\t������ : "+checkOutDate);
	   }
	}
    // b.checkIn() : state Ȯ���ؼ� ���Ⱑ�� ���� ����();
	// ���Ⱑ��(0)�̸� �޽��� �Ѹ��� �ߴ�, 
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
		System.out.println(bookTitle + "�ش� ������ �̹� �ݳ� �Ϸ�� å�Դϴ�.");
		return;
		}//state�� ������(1)�̸� �ݳ� ����.
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");

	}
    // b.printState() => å��ȣ å ���� (����) ���� ��
	@Override
	public void printState() {
	   if(state==STATE_NORMAL) {
		    System.out.println(bookNo + "\t"+bookTitle+"("+writer+"����) ���Ⱑ��");
	   } else if (state==STATE_BORROWED) {
		   System.out.println(bookNo + "\t"+bookTitle+"("+writer+"����) ������");
	   } else {
		   System.out.println(bookNo + "\t"+bookTitle+"("+writer+"����) �Է� ����");
	   }
//	   String msg = bookNo + "\t"+bookTitle+"("+writer+"����)";
//	   msg = msg + ((state==STATE_NORMAL)? "���Ⱑ��" : (state==STATE_BORROWED)? "������" : "�Է� ����");
//	   System.out.println();
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
























