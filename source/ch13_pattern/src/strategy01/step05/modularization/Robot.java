package strategy01.step05.modularization;

import strategy01.step04.Interfaces.*;

public class Robot {
	//Robot r = new Robot ();
	// r.actionfly(); 에러(생성자에서 fly = new FlyNo(); 안해서 에러)
	// 이를 방지하고자 객체생성 불가하도록 abstract class 

	   private IFly fly; //인터페이스 패키지에서 가져옴
	   private IMissile missile;
	   private IKnife knife;
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
		   public void actionFly() {
				fly.fly();
		   }

		   public void actionKnife() {
				knife.knife();
			}

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