package strategy01.step04.modularization;
import strategy01.step04.Interfaces.*; // 해당 패키지의 모든 클래스, 인터페이스 적용 가능.
public class LowRobot extends Robot {
   
   private IFly fly; //인터페이스 패키지에서 가져옴
   private IMissile missile;
   private IKnife knife;
   public LowRobot() {
	 // fly = new FlyYes();
	 setFly(new FlyNo()); // 여기 말고 외부에서 new 다음만 바꾸면 됨.
	// missile = new MissileYes();
	 setMissile(new MissileNo());
	 setKnife(new KnifeNo()); // knife = new KnifeLazer.
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
