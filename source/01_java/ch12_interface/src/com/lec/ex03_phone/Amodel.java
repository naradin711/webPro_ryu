package com.lec.ex03_phone;
// a��ǰ : DMB�ۼ��Ű���, 5G, TV������ ž��, 
public class Amodel implements IAcorporation {
   private String modelName;
   public Amodel() {
	   modelName = "A��";
   }
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �ۼ��� ����.");
	}

	@Override
	public void LTE() {
		System.out.println(modelName + "�� 5G.");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV ������ ž��");
	}

}
