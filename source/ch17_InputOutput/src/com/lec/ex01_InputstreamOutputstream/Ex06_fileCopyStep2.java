package com.lec.ex01_InputstreamOutputstream;

import java.io.*;

// 1. 우선 스트링 객체 생성 (입력용, 출력용) 2. 읽고 쓴다. 3. 스트림 객체 닫는다. (스트림객체.close)
public class Ex06_fileCopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:/webPro/bts.jpg");
			os = new FileOutputStream("d:/webPro/bts_copyed.jpg");
			int cnt = 0; // 계산이 반복된 횟수 세기.
			byte [] bs = new byte [1024]; //bs 배열 1kb씩 읽기
			while(true) {// 2단계 읽고 쓴다
				int readByCount = is.read(bs); //1kbyte읽기
				if(readByCount==-1) break;
				os.write(bs, 0, readByCount);//bs를 출력할 때 0번 index부터 readByCount만큼 쓴다.
				cnt ++;
			}
			System.out.println(cnt+"번 실행하여 복사 성공!");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os!=null) os.close(); //
				if (is!=null) is.close(); // 처음 만든 객체를 나중에 클로즈 해야함. is os 순으로 만들면 os is순으로 클로즈
				System.out.println("실행 완료!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
