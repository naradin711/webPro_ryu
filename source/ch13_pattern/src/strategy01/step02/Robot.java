package strategy01.step02;
//�κ��� ��� ���� Ŭ���� : SuperRobot, StandardRobot, LowRobot
public class Robot {
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
}
