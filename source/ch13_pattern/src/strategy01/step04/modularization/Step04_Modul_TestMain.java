package strategy01.step04.modularization;
// 기능 하나 하나를 개체로 부품화 시킨것
public class Step04_Modul_TestMain {

	public static void main(String[] args) {
		SuperRobot    sr  = new SuperRobot();
		StandardRobot str = new StandardRobot();
		LowRobot      lr  = new LowRobot();
		Robot[] rbs = {sr, str, lr};
		for (Robot rs : rbs) {
			rs.shape();
			rs.actionWalk();
			rs.actionRun();
			rs.actionFly();
			rs.actionKnife();
			rs.actionMissile();
		}
      // lr.setFly(new FlyYes()); 이걸 되게 하는게 5단계
	}

}
