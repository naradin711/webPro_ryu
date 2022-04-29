package strategy01.step03;
//�κ��� ��� ���� Ŭ���� : SuperRobot, StandardRobot, LowRobot
public abstract class Robot {
   public void actionWalk() {
	   System.out.println("���� �� �ֽ��ϴ�.");
   }
   public void actionRun() {
	   System.out.println("�޸� �� �ֽ��ϴ�.");
   }
   public void shape() {
	   String className = getClass().getName(); // strategy01.step02.SupeRobot.
	   int idx = className.lastIndexOf('.'); // �� ������ '.'�� �ִ� ��ġ.
	   String name = className.substring(idx+1); // idx+1��° �۾����� ������.
	   System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
   }
   public abstract void actionFly();
   public abstract void actionKnife();
   public abstract void actionMissile();
}
