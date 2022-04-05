package com.lec.ex02_DataStream;
import java.io.*;
// 1. 스트림 객체 생성-파일을 연다. 2. 데이터를 쓴다. 3. 스트림 객체 닫는다 = 파일을 닫는다.
public class Ex01_DateOutputStream {
	public static void main(String[] args) {
	   OutputStream     fos = null;
	   DataOutputStream dos = null;
	   try {
		fos = new FileOutputStream("txtfile/dataFile.dat", true);//기본 스트림
		dos = new DataOutputStream(fos); // 보조 스트림은 기본 스트림을 통해서만 생성 가능하다.
		// 이름 - 학년 - 점수 write
		dos.writeUTF("홍길동"); //문자열 값 저장
		dos.writeInt(2);       // 정수값 저장
		dos.writeDouble(95.5); // 실수값 저장

		dos.writeUTF("철길동"); //문자열 값 저장
		dos.writeInt(1);       // 정수값 저장
		dos.writeDouble(87.6); // 실수값 저장
		
		dos.writeUTF("꽃길동"); //문자열 값 저장
		dos.writeInt(4);       // 정수값 저장
		dos.writeDouble(98.2); // 실수값 저장
	    System.out.println("파일 저장 완료");
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
		
			try {
				if (dos!=null) dos.close();
				if (fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} 
	}
	   
	}

}
