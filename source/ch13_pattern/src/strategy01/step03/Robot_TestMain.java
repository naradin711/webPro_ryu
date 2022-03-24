package strategy01.step03;

public class Robot_TestMain {
	public static void main(String[] args) {
	   Robot[] robots = {new SuperRobot(), new StandardRobot(),  new LowRobot()};
	   for(Robot r : robots) {
		   r.shape();
		   r.actionRun();
		   r.actionWalk();
		   r.actionFly();
		   r.actionMissile();
		   r.actionKnife();
//		   if(r instanceof SuperRobot) {
//			   SuperRobot sr = (SuperRobot) r;
//			   sr.actionFly();
//			   sr.actionKnife();
//			   sr.actionMissile();
//		   }else if(r instanceof StandardRobot) {
//			   StandardRobot str = (StandardRobot) r;
//			   str.actionFly();
//			   str.actionKnife();
//			   str.actionMissile();
//		   }else if(r instanceof LowRobot) {
//			   LowRobot lr = (LowRobot) r;
//			   lr.actionFly();
//			   lr.actionKnife();
//			   lr.actionMissile();
//		   } //sr if
	   }// for
	}// main
}// class
