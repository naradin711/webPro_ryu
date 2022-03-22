package com.lec.ex14_account;
//CreditLineAccount c2 = new CreditLineAccount("11-11", "홍", "1111-2222-3333-4444", 10000)
//CreditLineAccount c2 = new CreditLineAccount("11-11", "홍", 3000, "1111-2222-3333-4444", 10000)
public class CreditLineAccount extends CheckingAccount {
   private long creditLine; //카드한도
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
       if(this.getCardNo().equals(cardNo)) {//올바른 카드인지 확인
   		 if(getCreditLine()>= money) {// 지불 가능한지 (한도가 지불할 금액 이상인지)
   			System.out.printf("%s(%s) 님 한도는 %d원으로 지불하여 %d원 결제완료되었습니다.\n", getOwnerName(), getAccountNo(),getCreditLine(),money);
   		 }else {
   			System.out.printf("%s(%s) 님 한도 %d원으로 한도 초과로 인해 지불 불가합니다.\n", getOwnerName(), getAccountNo(), getCreditLine()); 
   		 }
   	  }else {
   		 System.out.println("올바른 카드번호를 입력하세요. ");
   	  }	
    }
    public long getCreditLine() {
	return creditLine;
    }
    public void setCreditLine(long creditLine) {
	  this.creditLine = creditLine;
    }
 
   
}
