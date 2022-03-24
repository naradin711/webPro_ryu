package com.lec.ex11_robot;
// RobotOrder oreder = new RobutOder:
public class RobotOrder {
   public void action (Robot robot) {
		  if(robot instanceof SingRobot) {
			 ((SingRobot)robot).sing();
		  }else if (robot instanceof DanceRobot) {
			  ((DanceRobot)robot).dance();
	      }else if (robot instanceof DrawRobot) {
			  ((DrawRobot)robot).draw();
	      }else {
	    	  System.out.println("¹¹ÇÏ´Â°Å¾ß");
	      }
   }
}
