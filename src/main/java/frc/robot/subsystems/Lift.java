/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LiftConstants;

public class Lift extends SubsystemBase {
  WPI_VictorSPX liftMotor;
  DoubleSolenoid liftStatus;

  public Lift() {
    liftMotor = new WPI_VictorSPX(LiftConstants.MOTOR);
  }

  public void run() {
    liftMotor.set(LiftConstants.SPEED);
  }

  public void changeLift(boolean bool) {
    if (bool = true) {
      liftStatus.set(Value.kForward);
    }
    else if (bool = false) {
      liftStatus.set(Value.kReverse);
    }
  }
}
