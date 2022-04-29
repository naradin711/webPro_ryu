package com.lec.ex05_Lib;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class BookLib implements ILendable {
	private String bNo;       //å��ȣ
	private String bTitle;    //å����
	private String writer;    //����
	private String borrower;  //������
	private Date cDate;       //������
	private byte state; // ������ 1 ���Ⱑ��0

	public BookLib(String bNo, String bTitle, String writer) {
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.writer = writer;
	}
    // BookLib book = new BookLib("89a-09", "java", "�赶��")
	// book.checkOut("������") �������� Ȯ�� - ������� - �������� ���

	@Override
	public void checkOut(String borrower) throws Exception {
		if(state == BORROWED) {
			throw new Exception(bTitle+ "������ ������ �Դϴ�."); //������ ���ܹ߻�
		} // �������
		this.borrower =borrower;
		cDate = new Date (); // ��¥ üũ
		state = BORROWED;    // ���� ����
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-M-d");
		System.out.println("\"" + bTitle + "\"" +"\"\t������ ���� �Ǿ����ϴ�." );
		System.out.println("������ :" +borrower +"\t������ : "+sdf.format(cDate)+"\n2�� �̳��� �ݳ��ϼ���." );
	}
	//  book.checkIn() ���� ���� Ȯ�� -> ��ü���� Ȯ�� (14<������)
	//  ��ü�Ǿ��� ��� ��ü�� ���� y/n

	@Override
	public void checkIn() throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		if(state==NORMAL) {
		   throw new Exception(bTitle+"������ �������� �ƴմϴ�.");
		}
		// ��ü ���� Ȯ�� cDate ~ ���簡�� 14�� �̳����� ���� Ȯ��.
		Date now = new Date();
		long diff = now.getTime()- cDate.getTime();// ���� �������� ���簡���� �и�����
		long day = diff/ (1000*60*60*24);
		if (day>14) {//��ü�� ���.
			System.out.println("��ü��� ���� 100�� �ΰ��˴ϴ�. �����Ͻ� ��ü��� "+(day-14)*100+"�� �Դϴ�.");
			Scanner sc = new Scanner(System.in);
			System.out.print("��ü�Ḧ ���̽��ϱ�? (Y/N)\t");
			if(! sc.next().equalsIgnoreCase("y")) { // ��ü�Ḧ �ȳ´ٰ� �ϴ� ��� Y/y�Դϴ�.
				System.out.println("��ü�Ḧ �����ϼž� �ݳ�ó���� �����մϴ�.");
				return;
			}
			
		} //�ݳ� ����
		borrower = null;
		cDate = null;
		state = NORMAL;
		System.out.println("\""+bTitle+"\"\t������ �ݳ��Ǿ����ϴ�.");
	}

	@Override
	public String toString() {
	  String msg ="å��ȣ :" + bNo + ", å���� " + bTitle + ", ���� " + writer+ "  ";
	  msg +=(state==NORMAL)? "���� ����" : "������";
      if (state == BORROWED) {
    	 Date date = new Date(cDate.getTime()+(1000*60*60*24*14));
    	 SimpleDateFormat sdf = new SimpleDateFormat(" (�ݳ������� : yyyy-M-d(E))");
    	 msg += sdf.format(date); 
      }
      return msg;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}	
	
}
















































