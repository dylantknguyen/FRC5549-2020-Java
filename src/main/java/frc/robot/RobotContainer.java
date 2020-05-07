package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;

import frc.robot.Constants.*;
import frc.robot.commands.Drive.DriverControl;

public class RobotContainer {
  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();

  // Joysticks
  public static Joystick joystickLeft = new Joystick(DriveConstants.JOYSTICK_LEFT);
  public static Joystick joystickRight = new Joystick(DriveConstants.JOYSTICK_RIGHT);
  public static XboxController xbox = new XboxController(DriveConstants.XBOX_CONTROLLER);

  // Axis
  public static Double joystickLeftAxis = joystickLeft.getRawAxis(DriveConstants.JOYSTICK_LEFTAXIS);
  public static Double joystickRightAxis = joystickRight.getRawAxis(DriveConstants.JOYSTICK_RIGHTAXIS);
  public static Double joystickRightRotate = joystickLeft.getRawAxis(DriveConstants.JOYSTICK_ROTATEAXIS);

  // Drive Type
  public static Boolean driveType = joystickRight.getTrigger();


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(new DriverControl(drivetrain, joystickLeftAxis, joystickRightAxis, joystickRightRotate, driveType));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
