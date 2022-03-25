package strategy01.step05.modularization;
import strategy01.step04.Interfaces.*; // �ش� ��Ű���� ��� Ŭ����, �������̽� ���� ����.
public class SuperRobot extends Robot {
   public SuperRobot() {
	 // fly = new FlyYes();
	 setFly(new FlyHigh()); // ���� ���� �ܺο��� new ������ �ٲٸ� ��.
	// missile = new MissileYes();
	 setMissile(new MissileYes());
	 setKnife(new KnifeLazer()); // knife = new KnifeLazer.
    }// public SuperRobot
}
