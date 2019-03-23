/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import java.lang.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Robot;

public class ClimbUp extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ClimbUp() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    requires(Robot.frontRam);
    requires(Robot.backRam);
    //requires(Robot.rearWheel);
   // requires(Robot.mydrive);

    addParallel(new FrontRamUp());
    addParallel(new BackRamDown());
    //addParallel(new RearWheelForward(2.0, -0.2));
    //addSequential(new FrontRamDown());
    //addSequential(new BackRamDown());


    // Sleep
    //addSequential(new RearWheelForward(2.0, 0.0));


    //addParallel(new RearWheelForward(2.0, -0.3));

  }
}
