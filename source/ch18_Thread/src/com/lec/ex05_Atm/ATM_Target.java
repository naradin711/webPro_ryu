package com.lec.ex05_Atm;

public class ATM_Target implements Runnable {
    private boolean flag;
    private ATM card;
    public ATM_Target(ATM card){
    	this.card = card;
    }
	@Override
	public void run() { //�����ߴ� ����ߴ�.
		for(int i=0; i<10; i++) {
			if(flag) {//���
            card.withdraw(1000, Thread.currentThread().getName());	
            flag = false;
			}else { // ����
			card.deposit(1000,Thread.currentThread().getName());
			flag = true;
			}
		}

	}

}
