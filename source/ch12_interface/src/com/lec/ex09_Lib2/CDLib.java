package com.lec.ex09_Lib2;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;     // ������
	private String checkOutDate; // ������
	private byte state;          // ���� ���� ������(1) ���Ⱑ��(0)	
	public CDLib() {}
	public CDLib(String cdNo, String cdTitle) {
		super(cdNo, cdTitle);
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { //���� ���̸� �޽��� �Ѹ��� ��.
		    System.out.println(getCdTitle()+" ������ �������Դϴ�.");
		    return;
	   }else { // ���� �����̸� ���� ó��. state�� 0�̸� ����ó�� ����.
		  this.borrower = borrower;
		  this.checkOutDate = checkOutDate;
		  state = STATE_BORROWED; //������ ���·� ��ȯ!
		  System.out.println(getCdTitle()+" ������ ���� ó���Ǿ����ϴ�.");
		  System.out.println("������ : "+borrower+"\t������ : "+checkOutDate);
	   }//if else
	}//void checkOut

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(getCdTitle() + "�ش� ������ �̹� �ݳ� �Ϸ�� å�Դϴ�.");
			return;
			}//state�� ������(1)�̸� �ݳ� ����.
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(getCdTitle() + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");	
	}
	public String toString() {
		return getCdNo() + "\t"+getCdTitle();	
    }
}