package strategy02.car.interfaces;

public class FuelGasoline implements IFuel {

	@Override
	public void fuel() {
		System.out.println("휘발유를 사용합니다.");
	}

}
