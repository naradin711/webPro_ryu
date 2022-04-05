package com.lec.TodayQuiz;
import java.util.*;
public class HashMapTest {
   public static void main(String[] args) {
	  HashMap<Integer, String> map = new HashMap<Integer, String> ();
	  map.put(0, "str0");
	  map.put(5, "str10");
	  //방법 1 추천
	  if(map.get(5)!=null) {
		  System.out.println("같은 변호가 있어서 입력 불가");
	  }
	  System.out.println("없는 키 값으로 get하면 null : "+ map.get(10));
	  //방법2
//	  Iterator<Integer> iterator = map.keySet().iterator();
//	  boolean ok = false;
//	  while(iterator.hasNext()) {
//		  Integer key = iterator.next();
//		  if(key.equals(0)) {
//			  ok = true;
//			  break;
//		  }
//	  }
//	  if(ok) {
//		  System.out.println("같은 번호가 있어서 입력 불가");
//	  }
 }
}
