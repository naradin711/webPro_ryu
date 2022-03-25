package strategy01.step05.modularization;
import strategy01.step04.Interfaces.*; // 해당 패키지의 모든 클래스, 인터페이스 적용 가능.
public class SuperRobot extends Robot {
   public SuperRobot() {
	 // fly = new FlyYes();
	 setFly(new FlyHigh()); // 여기 말고 외부에서 new 다음만 바꾸면 됨.
	// missile = new MissileYes();
	 setMissile(new MissileYes());
	 setKnife(new KnifeLazer()); // knife = new KnifeLazer.
    }// public SuperRobot
}
