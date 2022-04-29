package strategy01.step04.Interfaces;

public class MissileNo implements IMissile {
	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수 없습니다.");
	}

}
