package com.lec.ex05_Lib;

public interface ILendable {
	public byte BORROWED = 1; //(������)
	public byte NORMAL = 0; //(���Ⱑ��)
	public void checkOut (String borrower) throws Exception;
	public void checkIn() throws Exception;

}
