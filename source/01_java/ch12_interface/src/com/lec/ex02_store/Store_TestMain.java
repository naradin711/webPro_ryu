package com.lec.ex02_store;

public class Store_TestMain {
   public static void main(String[] args) {
	  HeadQuaterStore [] HQ = { new Store1("= = = 1ȣ�� = = ="),
	                            new Store2("= = = 2ȣ�� = = ="),
	                            new Store3("= = = 3ȣ�� = = =")};
//	  Store1          st1 = new Store1("= = = 1ȣ�� = = =");
//	  Store2          st2 = new Store2("= = = 2ȣ�� = = =");
//	  Store3          st3 = new Store3("= = = 3ȣ�� = = =");
//	  for(int idx=0 ; idx<HQ.length ; idx++) {
//		 HQ[idx].kimchi();
//		 HQ[idx].budae();
//		 HQ[idx].bibim();
//		 HQ[idx].sundae();
//		 HQ[idx].gongibab();
//	  }
	  for(HeadQuaterStore hq : HQ) {
		  System.out.println(hq.getStr());
		  hq.kimchi();
		  hq.budae();
		  hq.bibim();
		  hq.sundae();
		  hq.gongibab();
	  }
  }
}
