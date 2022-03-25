package strategy01.step05.modularization;
// 기능 하나 하나를 개체로 부품화 시킨것
// 5단계 : 기능을 부품화 -> 유지보수를 간편하게.
public class Step05_Modul_TestMain {

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
      // SuperRobot 업그레이드 요청 : 날 수 있습니다. - 높이 고공비행합니다.
	  // 고공 비행하는 부품을 만들어서 setFly를 호출한다.
	  // LowRobot 업그레이드 요청 : 검이 없습니다. - 장난감 검을 사용할 수 있습니다.
}
