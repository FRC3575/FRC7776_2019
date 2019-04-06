/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	//system ports

	
	 public static int leftFrontMotor = 0;
	 public static int leftRearMotor = 1;
	 public static int rightFrontMotor = 2;
	 public static int rightRearMotor = 3;
	 public static int robotArmPort = 4;
	 public static int robotHandPort = 5;
	 
	
	 public static int joystickPort = 0;
	 public static int gamePadPort = 1;


	 // DriveTrain Variables
	 public static int driveTrainArraySize = 20;
	 public static int driveTurnArraySize = 8;

	 //arm Variables
	 public static int armArraySize = 15;
	 
	 //autonomous code 
	 
	
	 
	 //telop throttling 
	 
	 public static double driveThrottle= 0.3;
		public static double turnThrottle= 0.9;
		
		public static double armThrottle= 0.6;

		public static double handThrottle= 1.0;
}