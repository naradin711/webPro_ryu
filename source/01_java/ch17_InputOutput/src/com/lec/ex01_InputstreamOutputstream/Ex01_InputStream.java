package com.lec.ex01_InputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 파일을 연다. (스트림 객체를 생성) 2. 데이터를 읽는다. 3. 파일을 닫는다.
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
       try {
		is = new FileInputStream("txtfile/inTest.txt");//1. 파일을 연다.
		while(true) { // 2 데이터를 읽는다
			int i =is.read(); // 데이터 읽기 1byte씩 책 읽기
			if(i==-1) break; // 파일의 끝이면 반복문 break
		    System.out.print((char)i+"("+i+")");
		}
		
	   } catch (FileNotFoundException e) {
		System.out.println("파일을 찾지 못한 경우 제외할 것 "+e.getMessage());
	   } //추상 클래스임.
         catch (IOException e) {
	    System.out.println("파일을 찾지 못한 경우 제외할 것"+e.getMessage());
	}    finally {
		// 3. 파일을 닫는다.  
		try {
			if(is!=null)is.close();
			System.out.println("끝");
		} catch (IOException e) {
		System.out.println(e.getMessage());
	    }
        
	  }
	}
}
