package com.lec.ex02_DataStream;
import java.io.*;
public class Ex02_DataInputStream {
	public static void main(String[] args) {
	   InputStream     fis = null;
	   DataInputStream dis = null;
	   try {
		fis = new FileInputStream("txtfile/dataFile.dat");
		dis = new DataInputStream(fis);
		while(true) {
			String name = dis.readUTF();
			int grade = dis.readInt();
			double score = dis.readDouble();
			System.out.printf("%s는 %d학년 %.1f점 \n", name, grade, score);
		}
	} catch (FileNotFoundException e) {
		System.out.println("파일을 찾지 못했습니다. "+e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
		System.out.println("데이터 끝");
	} finally {
		try {
			if(dis!=null) dis.close();
			if(fis!=null) fis.close();	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	   
	}

}
