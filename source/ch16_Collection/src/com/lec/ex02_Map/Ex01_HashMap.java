package com.lec.ex02_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
   public static void main(String[] args) {
	  ArrayList<String> list = new ArrayList<String>();
	  list.add("aaa");
	  System.out.println(list.get(0));//list계열의 collection은 index로 얻음.
	  HashMap<Integer, String> hashMap = new HashMap <Integer, String>();
	  hashMap.put(11, "str11");               //11key값에 데이터 "str11" 추가.
	  hashMap.put(new Integer(20) , "str20"); //20key값에 데이터 "str20" 추가.
	  hashMap.put(33, "str33");               //33key값에 데이터 "str33" 추가.
	  System.out.println(hashMap.get(20));//Key값으로 데이터 get함.
	  System.out.println("remove 전 : "+ hashMap);
	  hashMap.remove(20);                     //20key값이 remove
	  System.out.println("remove 후 : "+ hashMap);
	  hashMap.clear();
	  System.out.println(hashMap.isEmpty() ? "데이터 모두 삭제" : "데이터 아직 있음");
	  hashMap.put(0, "Hong GilDong");
	  hashMap.put(11, "Kim DongIl"); 
	  hashMap.put(22, "Lee SoonSin"); 
	  hashMap.put(40, "Yoo A-In");
	  System.out.println(hashMap); //for문 사용 안됨 - 반복자라는 것을 적용
	  Iterator<Integer> iterator = hashMap.keySet().iterator();
	  while(iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(key +"의 데이터는 " + hashMap.get(key));
	  }
 }
}









































