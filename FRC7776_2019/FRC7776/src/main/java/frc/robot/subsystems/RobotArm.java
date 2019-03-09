/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class RobotArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PWMVictorSPX _arm = new PWMVictorSPX(RobotMap.robotArmPort);
  private double[] armArray = new double[RobotMap.armArraySize];

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveArm());
  }

  public void GetGamePadInput(){
    double armSpeed = OI.myGamepad.getRawAxis(1);
    //double armSpeed = OI.myGamepad.getYChannel();
    RaiseArm(NormalizeArmInput(armSpeed));

  }

  public void RaiseArm(double armSpeed){
    _arm.setSpeed(armSpeed * RobotMap.armThrottle);
  }

  public void LowerArm(double armSpeed){
    _arm.setSpeed(armSpeed * RobotMap.armThrottle);

  }

  public void StopArm(){
    _arm.setSpeed(0.0);
  }

  private double NormalizeArmInput(double armValue){
		LoadArmArray(armValue);
		ShiftArmArrayValues();
		return GetArmArrayAveraga();
	}
	
	private void LoadArmArray(double armValue){
		armArray[RobotMap.armArraySize-1] = armValue;
	}

	private void ShiftArmArrayValues(){
		for (int i = 0; i < RobotMap.armArraySize -1; i++) {                
			armArray[i] = armArray[i+1];
		}
	}

	private double GetArmArrayAveraga(){
		double total = 0;

        for(int i=0; i<armArray.length; i++){
        	total = total + armArray[i];
        }

		double average = total / armArray.length;
		
		return average;
	}
}
