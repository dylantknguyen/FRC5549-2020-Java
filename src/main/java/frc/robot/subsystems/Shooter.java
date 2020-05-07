/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  WPI_TalonSRX encoderTop, encoderBottom;
  WPI_VictorSPX motorTop, motorBottom;
  double topRPM, topError, topIntegral, topDerivative, previousTopError, rcwTop, outputTop;
  double bottomRPM, bottomError, bottomIntegral, bottomDerivative, previousBottomError, rcwBottom, outputBottom;


  public Shooter() {
    encoderTop = new WPI_TalonSRX(ShooterConstants.TOP_ENCODER);
    encoderBottom = new WPI_TalonSRX(ShooterConstants.BOTTOM_ENCODER);
    motorTop = new WPI_VictorSPX(ShooterConstants.TOP_MOTOR);
    motorBottom = new WPI_VictorSPX(ShooterConstants.BOTTOM_MOTOR);
  }

  public void setTop(int setpoint) {
    topRPM = encoderTop.getSelectedSensorVelocity() * ShooterConstants.VEL_RPM_CONVERSION;
    topError = setpoint - (topRPM);
    topIntegral = topIntegral + topError;
    if (topIntegral > ShooterConstants.TOP_MAX_RPM) {
      topIntegral = 4400;
    }
    topDerivative = topError - previousTopError;
    rcwTop = (ShooterConstants.PIDTop.kP * topError) + (ShooterConstants.PIDTop.kI * topIntegral) + (ShooterConstants.PIDTop.kD * topDerivative)  + (ShooterConstants.PIDTop.kF * setpoint);
    outputTop = (rcwTop / ShooterConstants.TOP_MAX_RPM);
    previousTopError = topError;
  }

  public void setBottom(int setpoint) {
    bottomRPM = encoderBottom.getSelectedSensorVelocity() * ShooterConstants.VEL_RPM_CONVERSION;
    bottomError = setpoint - (bottomRPM);
    bottomIntegral = bottomIntegral + bottomError;
    if (bottomIntegral > ShooterConstants.BOTTOM_MAX_RPM) {
      bottomIntegral = 4400;
    }
    bottomDerivative = bottomError - previousBottomError;
    rcwBottom = (ShooterConstants.PIDBottom.kP * bottomError) + (ShooterConstants.PIDBottom.kI * bottomIntegral) + (ShooterConstants.PIDBottom.kD * bottomDerivative) + (ShooterConstants.PIDBottom.kF * setpoint);
    outputBottom = (rcwBottom / ShooterConstants.BOTTOM_MAX_RPM);
    previousBottomError = bottomError;
  }
}
