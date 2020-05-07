/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Simple.Indexer;

// import com.revrobotics.ColorSensorV3;
// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class IndexerForward extends CommandBase {
  private final Indexer m_indexer;
  // private final ColorSensorV3 m_colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
  // private final DigitalInput m_limitSwitch = new DigitalInput(IndexerConstants.LIMIT_SWITCH);
  public int balls = 0;

  public IndexerForward(Indexer indexer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_indexer = indexer;
    addRequirements(indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_indexer.forward();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
