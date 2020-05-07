/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Complex;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Simple.Intake.IntakeForward;
import frc.robot.commands.Simple.Limelight.LimelightLED;
import frc.robot.commands.Simple.Semicircle.SemicircleAdvance;
import frc.robot.commands.Simple.Semicircle.SemicircleForward;
import frc.robot.commands.Simple.Shooter.Shoot;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Semicircle;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootTarget extends ParallelCommandGroup {
  /**
   * Creates a new ShootTarget.
   */
  public ShootTarget(Shooter m_shooter, Intake m_intake, Semicircle m_semicircle, Limelight m_limelight, int setpointTop, int setpointBottom) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
    super(
      new Shoot(m_shooter, setpointTop, setpointBottom),
      new IntakeForward(m_intake),
      new SemicircleForward(m_semicircle),
      new LimelightLED(m_limelight)
    );
  }
}
