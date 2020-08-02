package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Semicircle;
import frc.robot.Constants.*;
import frc.robot.commands.Simple.Drive.ChangeDrive;
import frc.robot.commands.Simple.Drive.DriverControl;
import frc.robot.commands.Simple.Drive.ShiftGear;
import frc.robot.commands.Simple.Intake.IntakeForward;
import frc.robot.commands.Simple.Semicircle.SemicircleAdvance;

public class RobotContainer {
  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Semicircle semicircle = new Semicircle();

  // Joysticks
  public static Joystick joystickLeft = new Joystick(DriveConstants.JOYSTICK_LEFT);
  public static Joystick joystickRight = new Joystick(DriveConstants.JOYSTICK_RIGHT);
  public static XboxController xbox = new XboxController(DriveConstants.XBOX_CONTROLLER);

  // Axis
  public static double joystickLeftAxis = joystickLeft.getRawAxis(DriveConstants.JOYSTICK_LEFTAXIS);
  public static double joystickRightAxis = joystickRight.getRawAxis(DriveConstants.JOYSTICK_RIGHTAXIS);
  public static double joystickRightRotate = joystickLeft.getRawAxis(DriveConstants.JOYSTICK_ROTATEAXIS);

  // Drive Type
  public static Boolean driveType = joystickRight.getTrigger();

  // Driver Buttons
  JoystickButton shiftGearButton = new JoystickButton(joystickRight, ButtonConstants.GEAR_SHIFT_BUTTON);
  JoystickButton driveTypeButton = new JoystickButton(joystickRight, ButtonConstants.DRIVE_TYPE_BUTTON);

  // Operator Buttons
  JoystickButton intakeButton = new JoystickButton(xbox, ButtonConstants.INTAKE_BUTTON);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // Default Commands
    drivetrain.setDefaultCommand(new DriverControl(drivetrain, joystickLeftAxis, joystickRightAxis, joystickRightRotate));
    semicircle.setDefaultCommand(new SemicircleAdvance(semicircle));

    // Driver Buttons
    shiftGearButton.whenPressed(new ShiftGear(drivetrain));
    driveTypeButton.whenPressed(new ChangeDrive(drivetrain));

    // Intake Buttons
    intakeButton.whileHeld(new IntakeForward(intake));

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
