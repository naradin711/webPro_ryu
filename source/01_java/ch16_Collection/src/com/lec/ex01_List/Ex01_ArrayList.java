package com.lec.ex01_List;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
       String[] array = new String [5];
       array [0] = "str0"; array [1] = "str1"; array [3] ="str3";
       for(int i=0 ; i<array.length ; i++) {
    	   System.out.printf("array[%d] = %s\t", i, array[i]);
       }
       System.out.println();//개행
       for(String arr : array) {
    	   System.out.print(arr+"\t");
       }
       System.out.println("\n~~~~~~ArrayList~~~~~~");
       ArrayList<String> arrayList = new ArrayList<String>(); //무조건 객체로 들어와야함. 
                         // 맨 처음에는 스트링 인덱스가 0 임.
       arrayList.add("str0");// 0번 인덱스.
       arrayList.add("str1");//	1번 인덱스. 삽입 후 2번 인덱스
       arrayList.add("str2");//	2번 인덱스. 삽입 후 3번 인덱스
       System.out.println(arrayList);
       arrayList.add(1, "str111111111");// 1번 인덱스. 중간 삽입.
       System.out.println(arrayList);
       arrayList.set(1, "11111");// 1번 인덱스. 객체 수정.
       System.out.println(arrayList);
       for (String alist : arrayList) {
    	   System.out.print(alist+"\t");
       }
       System.out.println("\n - remove한 다음 -");
       arrayList.remove("11111"); // 1번째 인덱스의 데이터 삭제.(2->1 3->2)
       arrayList.remove(arrayList.size()-1); //맨 마지막 인덱스 삭제! 자리 이동 없음.
       for (int idx=0; idx<arrayList.size() ; idx++) {
    	   System.out.printf("%d번째 인덱스 값은 %s\t", idx, arrayList.get(idx));
       }
       System.out.println();//개행
       arrayList.clear();//arrayList의 모든 데이터 삭제!
       if(arrayList.size() ==0) {
    	   System.out.println("arrayList의 데이터는 없습니다.");
       }
       if(arrayList.isEmpty()) {
    	   System.out.println("arrayList의 데이터는 없습니다.");
       }
       arrayList=null; //arrayList 자체가 삭제됨.
       //ArrayList<Double> list = new ArrayList<Double>(); //반드시 오브젝트 타입만이 들어와야 함.
	}

}


























