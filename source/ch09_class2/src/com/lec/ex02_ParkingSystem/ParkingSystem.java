package com.lec.ex02_ParkingSystem;

public class ParkingSystem {
	private String carId;
	private int in;
	private int out;
	private int bill;
	public ParkingSystem() {}
public ParkingSystem(String carId, int in, int out) {
       this.carId = carId;
       this.in = in;
       this.out = out ;
       bill = (out-in)*1000;
}
public void ParkingIn(String carId, int in) {
	 System.out.print('"'+carId+'"'+"�� �������.\n"+"�����ð� : "+in+"��\n");  
}
public void Parkingout(String carId, int in, int out) {
	//int bill = (out - in) * 1000 ;
	System.out.print('"'+carId+'"'+"�� �ȳ��� ������.\n"+"* �����ð� : "+in+"��\n"+"* �����ð� : "+out+"��\n"+"* ������� : "+bill+"��\n");
}
public String getCarId() {
	return carId;
}
public void setCarId(String carId) {
	this.carId = carId;
}
public int getIn() {
	return in;
}
public void setIn(int in) {
	this.in = in;
}
public int getOut() {
	return out;
}
public void setOut(int out) {
	this.out = out;
}
public int getBill() {
	return bill;
}
public void setBill(int bill) {
	this.bill = bill;
}

}
