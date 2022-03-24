package strategy01.step03;

public class SuperRobot extends Robot {
	@Override
   public void actionFly() {
	   System.out.println("날 수 있습니다.");
   }
	@Override
   public void actionMissile() {
	   System.out.println("미사일을 쏠 수 있습니다.");
   }
	@Override
   public void actionKnife() {
	   System.out.println("레이저 검을 사용할 수 있습니다.");
   }

}
