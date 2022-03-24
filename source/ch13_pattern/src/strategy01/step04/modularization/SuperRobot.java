package strategy01.step04.modularization;
import strategy01.step04.Interfaces.*; // �ش� ��Ű���� ��� Ŭ����, �������̽� ���� ����.
public class SuperRobot extends Robot {
   
   private IFly fly; //�������̽� ��Ű������ ������
   private IMissile missile;
   private IKnife knife;
   public SuperRobot() {
	 // fly = new FlyYes();
	 setFly(new FlyYes()); // ���� ���� �ܺο��� new ������ �ٲٸ� ��.
	// missile = new MissileYes();
	 setMissile(new MissileYes());
	 setKnife(new KnifeLazer()); // knife = new KnifeLazer.
    }// public SuperRobot
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}

	@Override
	public void actionMissile() {
	   missile.missile();

	}
	public IFly getFly() {
		return fly;
	}
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public IMissile getMissile() {
		return missile;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public IKnife getKnife() {
		return knife;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	  
	  
        
}
