package com.lec.ex01_InputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ������ ����. (��Ʈ�� ��ü�� ����) 2. �����͸� �д´�. 3. ������ �ݴ´�.
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
       try {
		is = new FileInputStream("txtfile/inTest.txt");//1. ������ ����.
		while(true) { // 2 �����͸� �д´�
			int i =is.read(); // ������ �б� 1byte�� å �б�
			if(i==-1) break; // ������ ���̸� �ݺ��� break
		    System.out.print((char)i+"("+i+")");
		}
		
	   } catch (FileNotFoundException e) {
		System.out.println("������ ã�� ���� ��� ������ �� "+e.getMessage());
	   } //�߻� Ŭ������.
         catch (IOException e) {
	    System.out.println("������ ã�� ���� ��� ������ ��"+e.getMessage());
	}    finally {
		// 3. ������ �ݴ´�.  
		try {
			if(is!=null)is.close();
			System.out.println("��");
		} catch (IOException e) {
		System.out.println(e.getMessage());
	    }
        
	  }
	}
}
