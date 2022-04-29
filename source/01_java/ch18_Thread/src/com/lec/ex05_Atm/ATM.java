package com.lec.ex05_Atm;

public class ATM {
   private int balance;
   public ATM(int balance) {
	   this.balance = balance;
   }
   public synchronized void deposit (int amount, String who) {
	   System.out.println(who+"가 입금 시작~~~");
	   balance += amount;
	   System.out.println(who+"가 "+amount+"원을 입금하여 잔액 :"+balance+"원");
	   System.out.println(who+"가 입금 종료~~~");
   }
   public synchronized void withdraw (int amount, String who) {
	   System.out.println(who+"가 출금 시작@@@");
	   balance -= amount;
	   System.out.println(who+"가 "+amount+"원을 출금하여 잔액 :"+balance+"원");
	   System.out.println(who+"가 출금 종료@@@");
   }
   public int getBalance() {
	   return balance;
   }
}
