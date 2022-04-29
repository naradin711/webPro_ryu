package com.lec.ex;
// 논리연산자 : &&(AND), ||(OR) 
public class OpeEx04 {
	public static void main(String[] args) {
    int i=1, j=10, h=10;
    // && 좌항이 false일 때 우향 실행 안 함.
    boolean result = ( (i>j) && (++j>h) );
    System.out.println("result="+result+"\t j="+j);
    //|| 연산자 좌항이 true일 때는 우향 실행 안 함.
    result =  ( (i<j) || (++j>h) );
    System.out.println("result="+result+"\t j="+j);
    
    int num1 = 3, num2 = 1;
    System.out.println(num1&num2);
}
}