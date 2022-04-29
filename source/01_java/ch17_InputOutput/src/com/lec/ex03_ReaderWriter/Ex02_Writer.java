package com.lec.ex03_ReaderWriter;
import java.io.*;
public class Ex02_Writer {
  public static void main(String[] args) {
	  Writer writer = null;
	  try {
		writer = new FileWriter("txtfile/outTest.txt",true);
		String msg = "\n추가한 텍스트 파일입니다. 안녕하세요 ";
		writer.write(msg);
		System.out.println("파일 출력 성공!");
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
