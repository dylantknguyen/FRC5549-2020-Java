/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Simple.Drive.TurnToAngle;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AimTarget extends SequentialCommandGroup {
  double navxAngle, limelightAngle, targetAngle;

  public AimTarget(Drivetrain drive, Limelight limelight) {
    navxAngle = drive.getAngle();
    limelightAngle = limelight.getAngle();
    targetAngle = navxAngle + limelightAngle;
    new TurnToAngle(drive, targetAngle);
  }
}
