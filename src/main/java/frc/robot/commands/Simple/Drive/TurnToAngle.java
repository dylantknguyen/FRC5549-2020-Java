/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Simple.Drive;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;

public class TurnToAngle extends PIDCommand {
  public TurnToAngle(Drivetrain drive, double targetAngle) {
    super(
        // PIDController of Command
        new PIDController(DriveConstants.kP, DriveConstants.kI, DriveConstants.kD),
        // Gets Current Angle
        drive::getAngle,
        // Gets Target Angle
        targetAngle,
        // Uses Output
        output -> drive.arcadeDrive(0, output),
        // Require Drive Subsystem
        drive);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    getController().enableContinuousInput(-180, 180);
    getController().setTolerance(DriveConstants.TURN_TOLERANCE_DEGREES);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
