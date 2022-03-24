package strategy01.step04.Interfaces;

public class StandardRobot extends Robot {
	@Override
   public void actionFly() {
	   System.out.println("날 수 없습니다.");
   }
	@Override
   public void actionMissile() {
	   System.out.println("미사일을 쏠 수 있습니다.");
   }
	@Override
   public void actionKnife() {
	   System.out.println("목검을 사용할 수 있습니다.");
   }

}
