package com.lec.ex;
// �������� : &&(AND), ||(OR) 
public class OpeEx04 {
	public static void main(String[] args) {
    int i=1, j=10, h=10;
    // && ������ false�� �� ���� ���� �� ��.
    boolean result = ( (i>j) && (++j>h) );
    System.out.println("result="+result+"\t j="+j);
    //|| ������ ������ true�� ���� ���� ���� �� ��.
    result =  ( (i<j) || (++j>h) );
    System.out.println("result="+result+"\t j="+j);
    
    int num1 = 3, num2 = 1;
    System.out.println(num1&num2);
}
}