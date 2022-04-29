package strategy01.step05.modularization;
import strategy01.step04.Interfaces.*; // �ش� ��Ű���� ��� Ŭ����, �������̽� ���� ����.
public class LowRobot extends Robot { 
   public LowRobot() {
	 // fly = new FlyYes();
	 setFly(new FlyNo()); // ���� ���� �ܺο��� new ������ �ٲٸ� ��.
	// missile = new MissileYes();
	 setMissile(new MissileNo());
	 setKnife(new KnifeToy()); // knife = new KnifeLazer.
    }// public SuperRobot
}
