package com.lec.ex03_phone;
// c��ǰ : DMB�ۼ��źҰ�, LTE, TV������ ��ž��,  
public class Cmodel implements IAcorporation {
   private String modelName;
   public Cmodel() {
	   modelName = "C��";
   }
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �ۼ��� �Ұ�.");
	}

	@Override
	public void LTE() {
		System.out.println(modelName + "�� LTE.");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV ������ ��ž��");
	}

}
