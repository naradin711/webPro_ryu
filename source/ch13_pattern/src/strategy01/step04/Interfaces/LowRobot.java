package strategy01.step04.Interfaces;

public class LowRobot extends Robot {
	@Override
   public void actionFly() {
	   System.out.println("�� �� �����ϴ�.");
   }
	@Override
   public void actionMissile() {
	   System.out.println("�̻����� �� �� �����ϴ�.");
   }
	@Override
   public void actionKnife() {
	   System.out.println("���� �����ϴ�.");
   }

}
