package com.lec.ex02_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
   public static void main(String[] args) {
	  ArrayList<String> list = new ArrayList<String>();
	  list.add("aaa");
	  System.out.println(list.get(0));//list�迭�� collection�� index�� ����.
	  HashMap<Integer, String> hashMap = new HashMap <Integer, String>();
	  hashMap.put(11, "str11");               //11key���� ������ "str11" �߰�.
	  hashMap.put(new Integer(20) , "str20"); //20key���� ������ "str20" �߰�.
	  hashMap.put(33, "str33");               //33key���� ������ "str33" �߰�.
	  System.out.println(hashMap.get(20));//Key������ ������ get��.
	  System.out.println("remove �� : "+ hashMap);
	  hashMap.remove(20);                     //20key���� remove
	  System.out.println("remove �� : "+ hashMap);
	  hashMap.clear();
	  System.out.println(hashMap.isEmpty() ? "������ ��� ����" : "������ ���� ����");
	  hashMap.put(0, "Hong GilDong");
	  hashMap.put(11, "Kim DongIl"); 
	  hashMap.put(22, "Lee SoonSin"); 
	  hashMap.put(40, "Yoo A-In");
	  System.out.println(hashMap); //for�� ��� �ȵ� - �ݺ��ڶ�� ���� ����
	  Iterator<Integer> iterator = hashMap.keySet().iterator();
	  while(iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(key +"�� �����ʹ� " + hashMap.get(key));
	  }
 }
}









































