package com.lec.ex03_phone;
// b��ǰ : DMB�ۼ��Ű���, LTE, TV������ ž��, 
public class Bmodel implements IAcorporation {
   private String modelName;
   public Bmodel() {
	   modelName = "B��";
   }
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �ۼ��� ����.");
	}

	@Override
	public void LTE() {
		System.out.println(modelName + "�� LTE.");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV ������ ž��");
	}

}
