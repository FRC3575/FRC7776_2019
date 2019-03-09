/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST Team 7776, Mid Valley Rangers - 4H. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


  public class OI {
    //// CREATING BUTTONS 
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    
    public static Joystick myJoystick = new Joystick(RobotMap.joystickPort);
    //public static Joystick myGamepad = new Joystick(RobotMap.gamePadPort);
    public static XboxController myGamepad = new XboxController(RobotMap.gamePadPort);
    public static Button grabBall = new JoystickButton(myGamepad,5);
    public static Button throwBall = new JoystickButton(myGamepad,6);
    public static Button frontRamDown = new JoystickButton(myGamepad,2);
    public static Button frontRamUp = new JoystickButton(myGamepad,4);
    public static Button backRamDown = new JoystickButton(myGamepad,1);
    public static Button backRamUp = new JoystickButton(myGamepad,3);
    public static Button rearWheelForward = new JoystickButton(myJoystick,5);
    public static Button rearWheelReverse = new JoystickButton(myJoystick,3);
    //public static Button climberUpButton = new JoystickButton(myJoystick,3);
    //public static Button climberDownButton = new JoystickButton(myJoystick,5);
    //public static Button sendPunchButton = new JoystickButton(myJoystick,2);
    //public static Button sendBottomPunchButton = new JoystickButton(myJoystick,1);
    
    public OI() { 
      grabBall.whileHeld(new GrabBall());
      throwBall.whileHeld(new ThrowBall());
      frontRamDown.whenPressed(new FrontRamDown());
      frontRamUp.whileHeld(new FrontRamUp());
      backRamDown.whenPressed(new BackRamDown());
      backRamUp.whileHeld(new BackRamUp());
      rearWheelForward.whileHeld(new RearWheelForward());
      rearWheelReverse.whileHeld(new RearWheelReverse());
      // elevatorDownButton.whileHeld(new ElevatorDown());
       //climberDownButton.whileHeld(new ClimbDown());
       //climberUpButton.whileHeld(new ClimbUp());
       //sendPunchButton.whenPressed(new PunchForward());
       //sendPunchButton.whenReleased(new PunchReverse());
       //sendBottomPunchButton.whenPressed(new BottomPunchForward());
       //sendBottomPunchButton.whenReleased(new BottomPunchReverse());
    }
}
