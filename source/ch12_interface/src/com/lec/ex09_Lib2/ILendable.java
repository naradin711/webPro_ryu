package com.lec.ex09_Lib2;
// Book의 작업명세서 - 오로지 상수와 추상 메소드만 존재
public interface ILendable {
   public byte STATE_BORROWED = 1;   // 대출중
   public byte STATE_NORMAL   = 0;   // 대출 되지 않은 상태
   public void checkOut(String borrower, String checkOutDate); 
                                     // 대출 (대출인, 대출일)
   public void checkIn();            // 반납
   public String toString();         // 도서 정보와 대출 상태를 화면에 출력.
}
