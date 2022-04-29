package com.lec.ex;

public class OpeEx01 {
	public static void main (String[] args) {
    System.out.println("====산술 연산자====");
    int n1 = 33;
    int n2 = 10;
    int result; //+-*% 의결과
    double resultDouble; // /의 결과
    result = n1 + n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '+', n2, result);
    result = n1 - n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '-', n2, result);
    result = n1 * n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '*', n2, result);
    result = n1 % n2; // 나머지
    System.out.printf("%d %c %d = %d\n\n", n1, '%', n2, result);
    result = n1 / n2;
    resultDouble = (double)n1 / n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '/', n2, result);
    System.out.printf("%d %c %d = %.1f\n\n", n1, '/', n2, resultDouble);
    if ( (n1%2) == 0) {  // if 문에 {}를 쓰는 것이 요새 추세
    	System.out.printf("n1은 짝수입니다.\n");
        System.out.printf("n1은 짝수라 좋습니다.\n"); }
    else 
    	{System.out.printf("n1은 홀수입니다.\n");
        System.out.printf("n1은 홀수라 싫습니당.\n");}
    if ( (n1%5) ==0 )
    	System.out.printf("n1은 5의 배수입니다.\n");
    else
    	System.out.printf("n1은 5의 배수가 아닙니다.\n");
}
}