package strategy02.car.modulization;
import strategy02.car.interfaces.*;
// 3가지 부품변수 / 생성자 x / drive (일반), shape(추상), engine(일반), km(일반), fuel(일반), setter & getter.
public abstract class Car {
	private IEngine engine;
	private IKm km;
	private IFuel fuel;
	public void drive () {
		System.out.println("해당 차는 운전할 수 있습니다.");
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
