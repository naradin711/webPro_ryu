package strategy01.step04.Interfaces;

public class MissileYes implements IMissile {
	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

}
