package com.lec.ex03_ReaderWriter;
import java.io.*;
public class Ex02_Writer {
  public static void main(String[] args) {
	  Writer writer = null;
	  try {
		writer = new FileWriter("txtfile/outTest.txt",true);
		String msg = "\n�߰��� �ؽ�Ʈ �����Դϴ�. �ȳ��ϼ��� ";
		writer.write(msg);
		System.out.println("���� ��� ����!");
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			if(writer!=null) writer.close();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}
	  
	}

}
