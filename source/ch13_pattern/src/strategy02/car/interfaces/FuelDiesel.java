package strategy02.car.interfaces;

public class FuelDiesel implements IFuel {

	@Override
	public void fuel() {
		System.out.println("경유를 사용합니다.");
	}

}
