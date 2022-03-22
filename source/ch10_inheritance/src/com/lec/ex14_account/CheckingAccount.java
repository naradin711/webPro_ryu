package com.lec.ex14_account;
//a2.pay("1111-2222-3333-4444", 1000);
public class CheckingAccount extends Account {
   private String cardNo;

   public CheckingAccount(String accountNo, String ownerName, String cardNo) {
	  super(accountNo, ownerName);
	  this.cardNo = cardNo; //ī�� ��ȣ �ʱ�ȭ.
	  }
   public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
	  super(accountNo, ownerName, balance);
	  this.cardNo = cardNo; //ī�� ��ȣ �ʱ�ȭ.
	  }
   public void pay(String cardNo, int money) {
	  if(this.cardNo.equals(cardNo)) {//�ùٸ� ī������ Ȯ��
		 if(getBalance()>= money) {
			setBalance(getBalance()-money);
			System.out.printf("%s(%s) �� �ܾ� %d������ �����Ͽ� �ܾ� %d�� �Դϴ�.\n", getOwnerName(), getAccountNo(),money,getBalance());
		 }else {
			System.out.printf("%s(%s) �� �ܾ� %d������ ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), getBalance(),money); 
		 }
	  }else {
		 System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���. ");
	     }
      }
   public String getCardNo() {
	  return cardNo;
   }
   public void setCardNo(String cardNo) {
	  this.cardNo = cardNo;
   }
   
   
}
