package com.lec.ex03_phone;

public class Phone_TestMain {

	public static void main(String[] args) {
		Amodel a = new Amodel();
		Bmodel b = new Bmodel();
		Cmodel c = new Cmodel();
		a.dmbReceive();
		a.LTE();
		a.tvRemoteControl();
		IAcorporation [] phone = {a ,b ,c};
        for ( IAcorporation p  : phone) {
        System.out.println(p.getClass().getName()); 
        p.dmbReceive();
		p.LTE();
		p.tvRemoteControl();
        }
	}

}
