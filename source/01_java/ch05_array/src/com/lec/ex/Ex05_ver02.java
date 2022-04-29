package com.lec.ex;
// 수정, 지애, 지수, 미주, 지연의 키를 입력받고, 평균 키를 출력하시오.
// 최장신 친구이름과 키, 최단신 친구 이름과 키 출력
import java.util.Scanner;
public class Ex05_ver02{
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
		   System.out.println((double)totalHeight/arrName.length + "cm \n\n");
		   sc.close();
		   int maxIdx=0, maxHeight=0; // 최장신 키와 인덱스
		   int minIdx=0, minHeight=999; // 최단신 키와 인덱스
		   for (int i=0; i<arrName.length; i++) {
			   if(arrHeight[i]>maxHeight) {
				     maxHeight = arrHeight[i];
				     maxIdx = i;
			   }
			   if(arrHeight[i]<minHeight) {
				     minHeight = arrHeight[i];
				     minIdx = i;
			   }
		   }
		   System.out.printf("가장 작은 학생은 : %s, 키 : %d cm\n", arrName[minIdx], minHeight);
		   System.out.printf("가장 큰 학생은 : %s, 키 : %d cm\n", arrName[maxIdx], maxHeight);
	}
}














