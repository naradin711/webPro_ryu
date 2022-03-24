package com.lec.ex11_robot;

public class Robot_TestMain {
	public static void main(String[] args) {
		Robot [] rs = { new SingRobot(),
				        new DanceRobot(),
				        new DrawRobot()};
		RobotOrder order = new RobotOrder();
		for (Robot r : rs) {
			order.action(r);
		}
	}
}
