/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  WPI_TalonSRX intakeMotor;

  public Intake() {
    intakeMotor = new WPI_TalonSRX(IntakeConstants.MOTOR);
  }

  public void forward() {
    intakeMotor.set(IntakeConstants.SPEED);
  }

  public void reverse() {
    intakeMotor.set(-IntakeConstants.SPEED);
  }

  public void stop() {
    intakeMotor.set(0);
  }
}
