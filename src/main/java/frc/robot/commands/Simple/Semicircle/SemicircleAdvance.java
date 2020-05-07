/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Simple.Semicircle;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SemicircleConstants;
import frc.robot.subsystems.Semicircle;

public class SemicircleAdvance extends CommandBase {
  private final Semicircle m_semicircle;
  DigitalInput limitSwitch;
  ColorSensorV3 colorSensor;
  public static int balls;

  public SemicircleAdvance(Semicircle semicircle) {
    m_semicircle = semicircle;
    balls = 0;
    colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    limitSwitch = new DigitalInput(SemicircleConstants.LIMIT_SWITCH_PORT);
    addRequirements(semicircle);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (colorSensor.getProximity() >= SemicircleConstants.COLOR_SENSOR_SENSITIVITY && balls <= 3) {
      m_semicircle.forward();
      balls++;
    }
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
