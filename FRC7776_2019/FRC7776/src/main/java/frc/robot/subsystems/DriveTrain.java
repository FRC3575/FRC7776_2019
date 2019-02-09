/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.Arrays;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 * Add your docs here.
 */


  public class DriveTrain extends Subsystem {

    // Define and set ports for both left and right drives
	private Spark leftMotor; 
	private Spark rightMotor;
	
	private SpeedControllerGroup leftSide;
	private SpeedControllerGroup rightSide;
	
	private DifferentialDrive driveTrain;
	
	private double deadZone = 0.1;

	private double[] driveTrainArray = new double[RobotMap.driveTrainArraySize];
	private double[] driveTurnArray = new double[RobotMap.driveTurnArraySize];
	
	public DriveTrain() {
		leftMotor = new Spark(RobotMap.leftMotor);
		rightMotor = new Spark(RobotMap.rightMotor);
		
		leftSide = new SpeedControllerGroup(leftMotor);
		rightSide = new SpeedControllerGroup(rightMotor);
		
		rightMotor.setInverted(true);
		
		driveTrain = new DifferentialDrive(leftSide, rightSide);

		Arrays.fill(driveTrainArray, 0);
		Arrays.fill(driveTurnArray, 0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveRobot());
    }
    
    public void driveRobot(double throttle, double turn) {
    	driveTrain.arcadeDrive(throttle , -(turn));
    	
    }
    
    public void driveRobotJoystick() {
    	double throttle = OI.myJoystick.getRawAxis(1);
    	double turn = OI.myJoystick.getRawAxis(2);
    	if(Math.abs(throttle) < deadZone) {
    		throttle = 0.0;
    	}
    	if(Math.abs(turn) < deadZone) {
    		turn = 0.0;
    	}
    	//driveTrain.arcadeDrive(NormalThrottleInput(throttle) * RobotMap.driveThrottle , -turn * RobotMap.turnThrottle);   	
		driveTrain.arcadeDrive(NormalizeThrottleInput(throttle) , NormalizeTurnInput(-turn) * RobotMap.turnThrottle);   	

    }
    
    public void driveStop() {
    	driveTrain.arcadeDrive(0.0, 0.0);
	}

	private double NormalizeThrottleInput(double throttleValue){
		LoadDriveTrainArray(throttleValue);
		ShiftDriveTrainArrayValues();
		return GetDriveTrainArrayAveraga();
	}
	
	private void LoadDriveTrainArray(double throttleValue){
		driveTrainArray[RobotMap.driveTrainArraySize-1] = throttleValue;
	}

	private void ShiftDriveTrainArrayValues(){
		for (int i = 0; i < RobotMap.driveTrainArraySize -1; i++) {                
			driveTrainArray[i] = driveTrainArray[i+1];
		}
	}

	private double GetDriveTrainArrayAveraga(){
		double total = 0;

        for(int i=0; i<driveTrainArray.length; i++){
        	total = total + driveTrainArray[i];
        }

		double average = total / driveTrainArray.length;
		
		return average;
	}
	private double NormalizeTurnInput(double turnValue){
		LoadDriveTurnArray(turnValue);
		ShiftDriveTurnArrayValues();
		return GetDriveTurnArrayAveraga();
	}
	
	private void LoadDriveTurnArray(double turnValue){
		driveTurnArray[RobotMap.driveTurnArraySize-1] = turnValue;
	}

	private void ShiftDriveTurnArrayValues(){
		for (int i = 0; i < RobotMap.driveTurnArraySize -1; i++) {                
			driveTurnArray[i] = driveTurnArray[i+1];
		}
	}

	private double GetDriveTurnArrayAveraga(){
		double total = 0;

        for(int i=0; i<driveTurnArray.length; i++){
        	total = total + driveTurnArray[i];
        }

		double average = total / driveTurnArray.length;
		
		return average;
	}
}
