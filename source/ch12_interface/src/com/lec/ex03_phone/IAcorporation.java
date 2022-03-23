package com.lec.ex03_phone;
// a제품 : DMB송수신가능, 5G, TV리모콘 탑재, 
public interface IAcorporation {
   public void dmbReceive();// dmb 여부 구현은 하위 클래스에서!
   public void LTE();// LTE 여부 구현은 하위 클래스에서!
   public void tvRemoteControl();
}
