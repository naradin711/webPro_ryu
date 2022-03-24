package strategy01.step04.Interfaces;

public class FlyNo implements IFly {
	@Override
	public void fly() {
		System.out.println("날 수 없습니다.");
	}
}
