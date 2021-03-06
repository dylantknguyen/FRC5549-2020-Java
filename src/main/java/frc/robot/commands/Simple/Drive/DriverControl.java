/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Simple.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class DriverControl extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final double m_axis1;
  private final double m_axis2;
  private final double m_axis3;

  
  public DriverControl(Drivetrain drivetrain, double LeftJoystickAxis, double rightJoystickAxis, double rotateAxis) {
    m_drivetrain = drivetrain;
    m_axis1 = LeftJoystickAxis;
    m_axis2 = rightJoystickAxis;
    m_axis3 = rotateAxis;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.drive(m_axis1, m_axis2, m_axis3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
