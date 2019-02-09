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
	
	 public static int leftMotor = 0;
	 public static int rightMotor = 1;
	 //public static int climberPort = 2;
	 //public static int drivePort = 3;
	 //public static int elevatorPort = 4;
	 public static int joystickPort = 0;

	 // DriveTrain Variables
	 public static int driveTrainArraySize = 50;
	 public static int driveTurnArraySize = 30;
	 
	 //autonomous code 
	 
	 //public static double driveForwardTime= 2.2;
	 //public static double driveForwardSpeed= -0.7;
	 //public static double elevatorUpTimeOut= 1.3;
	 //public static double elevatorUpSpeed= 1.0;
	 
	 //telop throttling 
	 
	 public static double driveThrottle= 0.3;
   public static double turnThrottle= 0.9;
}