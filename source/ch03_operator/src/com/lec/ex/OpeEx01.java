package com.lec.ex;

public class OpeEx01 {
	public static void main (String[] args) {
    System.out.println("====��� ������====");
    int n1 = 33;
    int n2 = 10;
    int result; //+-*% �ǰ��
    double resultDouble; // /�� ���
    result = n1 + n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '+', n2, result);
    result = n1 - n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '-', n2, result);
    result = n1 * n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '*', n2, result);
    result = n1 % n2; // ������
    System.out.printf("%d %c %d = %d\n\n", n1, '%', n2, result);
    result = n1 / n2;
    resultDouble = (double)n1 / n2;
    System.out.printf("%d %c %d = %d\n\n", n1, '/', n2, result);
    System.out.printf("%d %c %d = %.1f\n\n", n1, '/', n2, resultDouble);
    if ( (n1%2) == 0) {  // if ���� {}�� ���� ���� ��� �߼�
    	System.out.printf("n1�� ¦���Դϴ�.\n");
        System.out.printf("n1�� ¦���� �����ϴ�.\n"); }
    else 
    	{System.out.printf("n1�� Ȧ���Դϴ�.\n");
        System.out.printf("n1�� Ȧ���� �Ƚ��ϴ�.\n");}
    if ( (n1%5) ==0 )
    	System.out.printf("n1�� 5�� ����Դϴ�.\n");
    else
    	System.out.printf("n1�� 5�� ����� �ƴմϴ�.\n");
}
}