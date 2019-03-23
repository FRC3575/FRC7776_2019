/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class RobotHand extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PWMVictorSPX _hand = new PWMVictorSPX(RobotMap.robotHandPort);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ThrowBall());
  }
public void grabBall() {
//_hand.setSpeed(1.0 * RobotMap.handThrottle);
double speed = OI.myGamepad.getTriggerAxis(Hand.kLeft);
    _hand.setSpeed(speed);

}

public void thorwBall() {
  double speed = OI.myGamepad.getTriggerAxis(Hand.kRight);
    _hand.setSpeed(speed*-1.0);
}


 public void holdBall(){
   _hand.setSpeed(0.1);
 }

public void stopBall() {
  _hand.setSpeed(0.0);
}

}
