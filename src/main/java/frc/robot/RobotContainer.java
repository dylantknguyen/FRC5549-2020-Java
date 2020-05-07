package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Drive;

public class RobotContainer {
  // Subsystems
  private final Drive drive = new Drive();

  // Joysticks
  public static Joystick joystickLeft = new Joystick(0);
  public static Joystick joystickRight = new Joystick(1);
  public static XboxController xbox = new XboxController(1);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
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
