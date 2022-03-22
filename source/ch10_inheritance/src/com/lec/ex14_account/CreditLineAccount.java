package com.lec.ex14_account;
//CreditLineAccount c2 = new CreditLineAccount("11-11", "ȫ", "1111-2222-3333-4444", 10000)
//CreditLineAccount c2 = new CreditLineAccount("11-11", "ȫ", 3000, "1111-2222-3333-4444", 10000)
public class CreditLineAccount extends CheckingAccount {
   private long creditLine; //ī���ѵ�
   public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
    public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
    @Override
    public void pay(String cardNo, int money) {
       if(this.getCardNo().equals(cardNo)) {//�ùٸ� ī������ Ȯ��
   		 if(getCreditLine()>= money) {// ���� �������� (�ѵ��� ������ �ݾ� �̻�����)
   			System.out.printf("%s(%s) �� �ѵ��� %d������ �����Ͽ� %d�� �����Ϸ�Ǿ����ϴ�.\n", getOwnerName(), getAccountNo(),getCreditLine(),money);
   		 }else {
   			System.out.printf("%s(%s) �� �ѵ� %d������ �ѵ� �ʰ��� ���� ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), getCreditLine()); 
   		 }
   	  }else {
   		 System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���. ");
   	  }	
    }
    public long getCreditLine() {
	return creditLine;
    }
    public void setCreditLine(long creditLine) {
	  this.creditLine = creditLine;
    }
 
   
}
