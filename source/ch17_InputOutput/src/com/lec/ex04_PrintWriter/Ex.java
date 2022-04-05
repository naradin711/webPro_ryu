package com.lec.ex04_PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter prWriter = null;
		try {
//			os = new FileOutputStream("txtfile/outTest.txt", true);//기본스트림
//			prWriter = new PrintWriter(os); // 보조스트림
//			writer = new FileWriter("txtfile/outTest.txt", true); //기본스트림
//			prWriter = new PrintWriter(writer); // 보조스트림
			prWriter = new PrintWriter("txtfile/outTest.txt"); // 파일 append 불가능.
			System.out.println("안녕하세요 \n반갑습니다");
			prWriter.println("안녕하세요 \n반갑습니다");
			System.out.print("print는 개행이 안되서 개행추가 \n");
			prWriter.print("print는 개행이 안되서 개행추가 \n");
			System.out.printf("%s \t %3d \t %3d \t %4.1f\n", "홍길동", 90, 91, 90.78);
			prWriter.printf("%s \t %3d \t %3d \t %4.1f\n", "홍길동", 90, 91, 90.78);

			System.out.printf("%s \t %3d \t %3d \t %4.1f\n", "꽃길동", 100, 100, 100.00);
			prWriter.printf("%s \t %3d \t %3d \t %4.1f\n", "꽃길동", 100, 100, 100.00);
		} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
		} catch (IOException e) {
            System.out.println(e.getMessage());
		} finally {
			try {
				if(prWriter!=null) prWriter.close();
			} catch (Exception e2) {
	            System.out.println(e2.getMessage());
			}
		}
	}

}


























