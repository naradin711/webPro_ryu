package com.lec.ex;
// 수정, 지애, 지수, 미주, 지연의 키를 입력받고, 평균 키를 출력하시오.
// 최장신 친구이름과 키, 최단신 친구 이름과 키 출력
import java.util.Scanner;
public class Ex05_ver01{
	public static void main (String [] args) {
		   String[] arrName= {"수정", "지애", "지수", "미주", "지연"};
		   int [] arrHeight = new int[arrName.length];
		   int totalHeight = 0;
		   Scanner sc = new Scanner(System.in);
		   for(int i=0; i<arrHeight.length ; i++) {
			   System.out.print(arrName[i]+ "의 키는? ");
			   arrHeight[i] = sc.nextInt();
			   totalHeight += arrHeight[i];
		   }
		   System.out.print("평균키 : ");
		   System.out.println((double)totalHeight/arrName.length + "cm ");
		   sc.close();
	}
}