package com.lec.TodayQuiz;
// 파일에 저장된 재고들을 출력.
import java.io.*;
import java.util.*;
public class ProductPrint {
	public static void main(String[] args) {
		InputStream     fis=null;
		DataInputStream dis=null;
		ArrayList<Product> products = new ArrayList<Product> ();
		try {
			fis = new FileInputStream("src/com/lec/TodayQuiz/product.dat");
			dis = new DataInputStream(fis);
			while (true) {
				String name = dis.readUTF();
				int   price = dis.readInt();
				int      ps = dis.readInt();
				products.add(new Product(name, price, ps));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다.");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();	
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}// try-catch
		}// array
		if(products.isEmpty()) {
			System.out.println("입력된 재고량이 없습니다.");
		}else {
			for(Product p :products) {
				System.out.println(p);
			}
			System.out.println("이상 물품 " + products.size()+"개 입력됨.");
		}
	}
}
