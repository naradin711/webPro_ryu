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
			System.out.printf("%s�� %d�г� %.1f�� \n", name, grade, score);
		}
	} catch (FileNotFoundException e) {
		System.out.println("������ ã�� ���߽��ϴ�. "+e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
		System.out.println("������ ��");
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
