/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class RearWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PWMVictorSPX _wheel = new PWMVictorSPX(RobotMap.robotWheelPort);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void forward(double speedIn){
    _wheel.setSpeed(speedIn * -1.0);
  }
  public void reverse(double speedIn){
    _wheel.setSpeed(speedIn);
  }
  public void stop(){
    _wheel.setSpeed(0.0);
  }
}
