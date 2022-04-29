package strategy01.step05.modularization;
import strategy01.step04.Interfaces.*; // �ش� ��Ű���� ��� Ŭ����, �������̽� ���� ����.
public class StandardRobot extends Robot {
   public StandardRobot() {
	 // fly = new FlyYes();
	 setFly(new FlyNo()); // ���� ���� �ܺο��� new ������ �ٲٸ� ��.
	// missile = new MissileYes();
	 setMissile(new MissileYes());
	 setKnife(new KnifeWood()); // knife = new KnifeLazer.
    }// public SuperRobot
        
}
