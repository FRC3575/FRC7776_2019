/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class BackRam extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private DoubleSolenoid punchSolenoid;

  public BackRam(){
    punchSolenoid = new DoubleSolenoid(1,0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    ramUp();
  }

  public void ramUp() {
    punchSolenoid.set(DoubleSolenoid.Value.kForward);
    
  }
  public void ramDown() {
    punchSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void ramStop() {
    punchSolenoid.set(DoubleSolenoid.Value.kOff);
  }
}
