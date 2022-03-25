package strategy01.step05.modularization;

import strategy01.step04.Interfaces.*;

public class Robot {
	//Robot r = new Robot ();
	// r.actionfly(); ����(�����ڿ��� fly = new FlyNo(); ���ؼ� ����)
	// �̸� �����ϰ��� ��ü���� �Ұ��ϵ��� abstract class 

	   private IFly fly; //�������̽� ��Ű������ ������
	   private IMissile missile;
	   private IKnife knife;
		   public void actionWalk() {
			   System.out.println("���� �� �ֽ��ϴ�.");
		   }
		   public void actionRun() {
			   System.out.println("�޸� �� �ֽ��ϴ�.");
		   }
		   public void shape() {
			   String className = getClass().getName(); // strategy01.step02.SupeRobot.
			   int idx = className.lastIndexOf('.'); // �� ������ '.'�� �ִ� ��ġ.
			   String name = className.substring(idx+1); // idx+1��° �۾����� ������.
			   System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
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