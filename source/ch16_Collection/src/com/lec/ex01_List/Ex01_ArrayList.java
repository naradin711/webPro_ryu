package com.lec.ex01_List;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
       String[] array = new String [5];
       array [0] = "str0"; array [1] = "str1"; array [3] ="str3";
       for(int i=0 ; i<array.length ; i++) {
    	   System.out.printf("array[%d] = %s\t", i, array[i]);
       }
       System.out.println();//����
       for(String arr : array) {
    	   System.out.print(arr+"\t");
       }
       System.out.println("\n~~~~~~ArrayList~~~~~~");
       ArrayList<String> arrayList = new ArrayList<String>(); //������ ��ü�� ���;���. 
                         // �� ó������ ��Ʈ�� �ε����� 0 ��.
       arrayList.add("str0");// 0�� �ε���.
       arrayList.add("str1");//	1�� �ε���. ���� �� 2�� �ε���
       arrayList.add("str2");//	2�� �ε���. ���� �� 3�� �ε���
       System.out.println(arrayList);
       arrayList.add(1, "str111111111");// 1�� �ε���. �߰� ����.
       System.out.println(arrayList);
       arrayList.set(1, "11111");// 1�� �ε���. ��ü ����.
       System.out.println(arrayList);
       for (String alist : arrayList) {
    	   System.out.print(alist+"\t");
       }
       System.out.println("\n - remove�� ���� -");
       arrayList.remove("11111"); // 1��° �ε����� ������ ����.(2->1 3->2)
       arrayList.remove(arrayList.size()-1); //�� ������ �ε��� ����! �ڸ� �̵� ����.
       for (int idx=0; idx<arrayList.size() ; idx++) {
    	   System.out.printf("%d��° �ε��� ���� %s\t", idx, arrayList.get(idx));
       }
       System.out.println();//����
       arrayList.clear();//arrayList�� ��� ������ ����!
       if(arrayList.size() ==0) {
    	   System.out.println("arrayList�� �����ʹ� �����ϴ�.");
       }
       if(arrayList.isEmpty()) {
    	   System.out.println("arrayList�� �����ʹ� �����ϴ�.");
       }
       arrayList=null; //arrayList ��ü�� ������.
       //ArrayList<Double> list = new ArrayList<Double>(); //�ݵ�� ������Ʈ Ÿ�Ը��� ���;� ��.
	}

}


























