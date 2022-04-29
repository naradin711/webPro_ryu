package strategy01.step03;
//로봇을 상속 받을 클래스 : SuperRobot, StandardRobot, LowRobot
public abstract class Robot {
   public void actionWalk() {
	   System.out.println("걸을 수 있습니다.");
   }
   public void actionRun() {
	   System.out.println("달릴 수 있습니다.");
   }
   public void shape() {
	   String className = getClass().getName(); // strategy01.step02.SupeRobot.
	   int idx = className.lastIndexOf('.'); // 맨 마지막 '.'이 있는 위치.
	   String name = className.substring(idx+1); // idx+1번째 글씨부터 끝까지.
	   System.out.println(name + "입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
   }
   public abstract void actionFly();
   public abstract void actionKnife();
   public abstract void actionMissile();
}
