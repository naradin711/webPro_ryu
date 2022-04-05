package com.lec.ex01_List;

import java.util.Vector;

public class Ex03_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(10);	//vec.add(new Integer(10));
		vec.add(new AClass());
		BClass obB = new BClass();
		vec.add(obB);
		System.out.println(vec);
		for(Object obj : vec) {
			System.out.println(obj);
		}
		for(int idx = 0 ; idx<vec.size();idx++) {
			System.out.println(vec.get(idx));
		}
	}

}
