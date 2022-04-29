package com.lec.ex03_exceptionExs;
import java.util.Date;
public class Ex02_FriendTestMain {
		public static void main(String[] args) {
			Friend hong = new Friend("È«±æµ¿", "010-9985-4455");
			hong.setEnterDate(new Date(122, 2, 11));
			System.out.println(hong);
			Friend kim = new Friend("±è±æ¿µ");
			System.out.println(kim);
		}
	}
	