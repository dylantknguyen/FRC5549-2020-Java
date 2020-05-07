/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Simple.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Simple.Semicircle.SemicircleAdvance;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
  private final Shooter m_shooter;
  private final int m_setpointTop, m_setpointBottom;

  public Shoot(Shooter shooter, int setpointTop, int setpointBottom) {
    m_shooter = shooter;
    m_setpointTop = setpointTop;
    m_setpointBottom = setpointBottom;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.setTop(m_setpointTop);
    m_shooter.setBottom(m_setpointBottom);
    SemicircleAdvance.balls = 0;
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
