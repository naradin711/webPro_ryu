package com.lec.ex14_account;

public class Account_TestMain {
   public static void main (String [] args) {
	   Account a1 = new Account("111-11111","È«±æµ¿");
	   a1.deposit(3000);
	   a1.deposit(6000);
	   a1.withdraw(10000);
	   System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       CheckingAccount a2 = new CheckingAccount("2222-2222", "È«ÁøÈ£", 1000, "1111-2222-3333-4444");
       a2.deposit(15000);
       a2.withdraw(30000);
       a2.pay("1111-2222-3333-4444", 5000);
       CreditLineAccount c2 = new CreditLineAccount("11-11", "È«", "1111-2222-3333-4444", 10000);
       c2.pay("1111-2222-3333-4444", 5000);
   }
}
