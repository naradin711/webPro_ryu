package com.lec.ex01_InputstreamOutputstream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 1. 파일을 연다. 출력용 스트림 객체 생성.
// 2. write 한다. 
// 3. 파일을 닫는다. (스트림객체.close)
public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {                                                       // 1. 올바른 경로로 없는 파일을 적으면 해당하는 파일을 새로 만든다
			os = new FileOutputStream("txtfile/outTest.txt", true); //  true를 쓰면 덮어쓴다.
			String str = "Hello, Java\n이 시국에 모두 건강하세요!";
			byte [] bs = str.getBytes();// 해당 문자열을 byte 배열로 바꾸는 함수.
				os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
		  System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null)os.close();
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
		}

	}

}
