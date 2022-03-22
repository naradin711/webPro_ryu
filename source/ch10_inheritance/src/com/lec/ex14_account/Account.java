package com.lec.ex14_account;
//데이터(속성) : 계좌번호(accountNo:String), 
//             예금주(ownerName:String), 
//             잔액(balance:int)
//기능(메소드) : 예금하다(void deposit(int)). 
//            인출하다(int withdraw(int)), 
//            잔액조회(long getBalance())
// Account a = New Account("100-1", "홍길동"); / Account("100-2", "신길동", 2200000000000);
public class Account {
   private String accountNo ;
   private String ownerName ;
   private long balance;
// 여기까지가 데이터 영역
   public Account() {} // default 생성자. 매개변수 없고 아무 일도 안하는 생성자.
   public Account(String accountNo, String ownerName ) { // 생성자 역할 : 데이터 초기화.
	 this.accountNo =   accountNo;
	 this.ownerName = ownerName;
	 System.out.printf("%s(%s)님 계좌 개설 감사합니다. 돈은 왜 안갖고 오셨나요? \n", ownerName,accountNo);
   }
   public Account(String accountNo, String ownerName, long balance ) { // 생성자 역할 : 데이터 초기화.
		 this.accountNo =   accountNo;
		 this.ownerName = ownerName;
		 this.balance = balance;
		 System.out.printf("%s(%s)님 계좌 개설 감사합니다. 지금 계좌의 현재 잔액은 %d 원입니다. \n", ownerName,accountNo,balance);
	   }
   //여기 아래부터 메소드 시작
   //예금하다(void deposit(int)), 인출하다(int withdraw(int)), 
   // 잔액조회(long getBalance())
   public void deposit(int money) { // 예금은 무조건
	   if(money>=0) {
		   balance += money ;
		   System.out.printf("%s(%s)님 %d원 입금완료했습니다. 현재 잔액 : %d\n",ownerName, accountNo, money, balance);
	   } else {
		   System.out.println("잘못된 입력입니다. ");
	   }
   }
   public void withdraw(int money) {
	   if(money<=balance) {
		   balance -= money ; 
		   System.out.println(ownerName + "님 의 계좌에서 " +money+ "원이 인출되었습니다.\n" + ownerName + "님 계좌의 잔액은 " + balance +  "원 입니다.");
	   } else {
		   System.out.println(ownerName + "님 잔액이 부족합니다. ");
	   }
   }
   public String inforPrint() {
	   return String.format("%s(%s)님의 잔액 : %d 원 입니다. \n", ownerName, accountNo, balance);
	//   return ownerName + "("+ accountNo +")"+"님의 잔액 : " + balance + "원 입니다.";
   }
    // setter & getter
   public String getAccountNo() {
	  return accountNo;
   }
   public void setAccountNo(String accountNo) {
	  this.accountNo = accountNo;
   }
   public String getOwnerName() {
	  return ownerName;
   }
   public void setOwnerName(String ownerName) {
	  this.ownerName = ownerName;
   }
   public long getBalance() {
	  return balance;
   }
   public void setBalance(long balance) {
	  this.balance = balance;
   }
// source에서 자동으로 setter와 getter를 생성할 수 있다.   
//   public void setAccountNo(String accountNo) {
//	   this.accountNo = accountNo;
//   }
//   public String setAccountNo() {
//	   return accountNo;
//   }
} 
