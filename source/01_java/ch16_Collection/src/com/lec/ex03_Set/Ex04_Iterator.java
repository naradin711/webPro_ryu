package com.lec.ex03_Set;
import java.util.*;
public class Ex04_Iterator {
	public static void main(String[] args) {
	ArrayList <String> list = new ArrayList <String> ();
	list.add("STR1"); list.add("STR2"); list.add("STR3");
	System.out.println(list);
	Iterator <String> iterator1 = list.iterator ();
//	while (iterator1.hasNext()) {
//		   System.out.print(iterator1.next()+"\t");
//	}
	for (String l : list) {
		System.out.println(l);
	}
	//��
    HashMap<String, String> map = new HashMap<String, String> ();
    map.put("�赶��", "010-8888-8888");
    map.put("������", "010-5555-5555");
    map.put("������", "010-7777-7777");
    Iterator<String> iterator2 = map.keySet().iterator();
    while(iterator2.hasNext()) {
    	String key = iterator2.next();
    	System.out.println(key+"\nŰ�� ������ : " + map.get(key));
    }
    // ��
    HashSet <String> hSet = new  HashSet <String> ();
    hSet.add("str0");  hSet.add("str1");  hSet.add("str1");
    Iterator <String> iterator3 = hSet.iterator();
    while (iterator3.hasNext()) {
    	System.out.println(iterator3.next());
    }
  }
}






















