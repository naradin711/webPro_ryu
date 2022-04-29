package com.lec.ex01_InputstreamOutputstream;
import java.io.*;
// 1. 파일을 연다 
// 2. 데이터를 읽는다. read(); 1byte씩 읽음. 속도가 느림. / read(byte[]) byte[]만큼 읽기.
// 3. 파일을 닫는다.
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
	   InputStream is = null;
	   try {
		is = new FileInputStream("txtfile/inTest.txt"); //1. 파일을 연다.
		byte [] bs = new byte [10];
		while(true) { // 2. 파일을 읽는다.
	                  int readByteCount = is.read(bs);
	                  if(readByteCount ==-1) break; 
	                    for (int i =0; i<readByteCount ; i ++) {
	                	  System.out.print((char)bs[i]);
	                    }
		            }
	    }catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	    }catch (IOException e) {
		System.out.println(e.getMessage());
	    } finally {
	    	try {//파일 닫기
	    		if(is!=null) is.close();
	    		System.out.println("\n끝");
	    	} catch (IOException e) {}
	    }

  }
}
