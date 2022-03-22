package com.lec.ex14_account;
//a2.pay("1111-2222-3333-4444", 1000);
public class CheckingAccount extends Account {
   private String cardNo;

   public CheckingAccount(String accountNo, String ownerName, String cardNo) {
	  super(accountNo, ownerName);
	  this.cardNo = cardNo; //카드 번호 초기화.
	  }
   public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
	  super(accountNo, ownerName, balance);
	  this.cardNo = cardNo; //카드 번호 초기화.
	  }
   public void pay(String cardNo, int money) {
	  if(this.cardNo.equals(cardNo)) {//올바른 카드인지 확인
		 if(getBalance()>= money) {
			setBalance(getBalance()-money);
			System.out.printf("%s(%s) 님 잔액 %d원으로 지불하여 잔액 %d원 입니다.\n", getOwnerName(), getAccountNo(),money,getBalance());
		 }else {
			System.out.printf("%s(%s) 님 잔액 %d원으로 지불 불가합니다.\n", getOwnerName(), getAccountNo(), getBalance(),money); 
		 }
	  }else {
		 System.out.println("올바른 카드번호를 입력하세요. ");
	     }
      }
   public String getCardNo() {
	  return cardNo;
   }
   public void setCardNo(String cardNo) {
	  this.cardNo = cardNo;
   }
   
   
}
