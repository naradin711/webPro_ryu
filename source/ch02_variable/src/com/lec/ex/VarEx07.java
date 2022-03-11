package com.lec.ex;

public class VarEx07 {
       public static void main(String[] args) {
       int i1 = 10;              // 4byte
       long l = 2200000000L;     // 8byte
       double d1 = 10;           // 8byte = 4byte (묵시적인 형변환 = 작은 바이트 값을 큰 바이트 공간에)
       System.out.println("d1="+d1);
       double d2 = 10.19; //8byte
       int i2 = (int)d2;  //4byte 명시적인 형변환 = 데이터 손실이 발생할 수 있음.
       System.out.println("i2="+i2);
       }
}