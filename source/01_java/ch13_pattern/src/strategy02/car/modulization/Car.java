package strategy02.car.modulization;
import strategy02.car.interfaces.*;
// 3���� ��ǰ���� / ������ x / drive (�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�), fuel(�Ϲ�), setter & getter.
public abstract class Car {
	private IEngine engine;
	private IKm km;
	private IFuel fuel;
	public void drive () {
		System.out.println("�ش� ���� ������ �� �ֽ��ϴ�.");
	}
	public abstract void shape();
	public void listEngine() {
		engine.engine();
		}

    public void listKm() {
		km.km();
	}

    public void listFuel() {
	   fuel.fuel();
	}
	public IEngine getEngine() {
		return engine;
	}
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public IKm getKm() {
		return km;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	public IFuel getFuel() {
		return fuel;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}  
	
}
