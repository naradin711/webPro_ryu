package com.lec.ex07_book1;
// Book�� �۾����� - ������ ����� �߻� �޼ҵ常 ����
public interface ILendable {
   public byte STATE_BORROWED = 1;   // ������
   public byte STATE_NORMAL   = 0;   // ���� ���� ���� ����
   public void checkOut(String borrower, String checkOutDate); 
                                     // ���� (������, ������)
   public void checkIn();            // �ݳ�
   public void printState();         // ���� ������ ���� ���¸� ȭ�鿡 ���.
}
