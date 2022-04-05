package com.lec.ex01_InputstreamOutputstream;
import java.io.*;
// 1. ������ ���� 
// 2. �����͸� �д´�. read(); 1byte�� ����. �ӵ��� ����. / read(byte[]) byte[]��ŭ �б�.
// 3. ������ �ݴ´�.
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
	   InputStream is = null;
	   try {
		is = new FileInputStream("txtfile/inTest.txt"); //1. ������ ����.
		byte [] bs = new byte [10];
		while(true) { // 2. ������ �д´�.
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
	    	try {//���� �ݱ�
	    		if(is!=null) is.close();
	    		System.out.println("\n��");
	    	} catch (IOException e) {}
	    }

  }
}
