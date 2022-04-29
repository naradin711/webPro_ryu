package strategy01.step05.modularization;
// ��� �ϳ� �ϳ��� ��ü�� ��ǰȭ ��Ų��
// 5�ܰ� : ����� ��ǰȭ -> ���������� �����ϰ�.
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
      // lr.setFly(new FlyYes()); �̰� �ǰ� �ϴ°� 5�ܰ�
	}
      // SuperRobot ���׷��̵� ��û : �� �� �ֽ��ϴ�. - ���� ��������մϴ�.
	  // ��� �����ϴ� ��ǰ�� ���� setFly�� ȣ���Ѵ�.
	  // LowRobot ���׷��̵� ��û : ���� �����ϴ�. - �峭�� ���� ����� �� �ֽ��ϴ�.
}
