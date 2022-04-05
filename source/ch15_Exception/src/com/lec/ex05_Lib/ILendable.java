package com.lec.ex05_Lib;

public interface ILendable {
	public byte BORROWED = 1; //(대출중)
	public byte NORMAL = 0; //(대출가능)
	public void checkOut (String borrower) throws Exception;
	public void checkIn() throws Exception;

}
