package com.lec.ex09_Lib2;
// Book�� �۾����� - ������ ����� �߻� �޼ҵ常 ����
public interface ILendable {
   public byte STATE_BORROWED = 1;   // ������
   public byte STATE_NORMAL   = 0;   // ���� ���� ���� ����
   public void checkOut(String borrower, String checkOutDate); 
                                     // ���� (������, ������)
   public void checkIn();            // �ݳ�
   public String toString();         // ���� ������ ���� ���¸� ȭ�鿡 ���.
}
