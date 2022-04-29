package com.lec.ex01_InputstreamOutputstream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 1. 파일을 연다. 출력용 스트림 객체 생성.
// 2. write 한다. 
// 3. 파일을 닫는다. (스트림객체.close)
public class Ex03_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {                                                       // 1. 올바른 경로로 없는 파일을 적으면 해당하는 파일을 새로 만든다
			os = new FileOutputStream("txtfile/outTest.txt", true); //  true를 쓰면 덮어쓴다.
			byte [] bs = {'H','e','l','l','o'};
			for (int i = 0; i<bs.length ; i++) {
				os.write(bs[i]);
			}
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
