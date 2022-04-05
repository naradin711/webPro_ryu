package com.lec.TodayQuiz;
import java.io.*;
import java.util.*;
public class ProductTest { // n을 누르기 전까지는 계속 재고(상품명, 가격, 재고량) 입력받아 파일 출력. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream     fos = null;
		DataOutputStream dos = null;
        try {
			fos = new FileOutputStream("src/com/lec/TodayQuiz/product.dat", true);
	        dos = new DataOutputStream(fos);
	        while (true) {
	        	System.out.print("입력하실 재고가 있으신가요? Y/N : ");
	        	answer = sc.next();
	        	if(answer.equalsIgnoreCase("n")) {
	        		break;
	        	}else if(answer.equalsIgnoreCase("y")) { // 상품명, 가격, 재고량을 파일로 출력.
	        		System.out.print("상품명은? : ");
	        		dos.writeUTF(sc.next());
	        		System.out.print("가격은? : ");
	        		dos.writeInt(sc.nextInt());
	        		System.out.print("재고 수량은? : ");
	        		dos.writeInt(sc.nextInt());
	        	}
	        }
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (dos!=null) dos.close();
				if (fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
