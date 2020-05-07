/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {
  // Creates Motors / Speed Controller Groups / Differential Drive
  WPI_TalonSRX leftFront, rightFront, leftBack, rightBack;
  SpeedControllerGroup leftMotors, rightMotors;
    DifferentialDrive drive;
  DoubleSolenoid gearShift;
  AHRS navx;
  
  public Drivetrain() {
    // Sets Motors
    leftFront = new WPI_TalonSRX(DriveConstants.LEFT_FRONT);
    rightFront = new WPI_TalonSRX(DriveConstants.RIGHT_FRONT);
    leftBack = new WPI_TalonSRX(DriveConstants.LEFT_BACK);
    rightBack = new WPI_TalonSRX(DriveConstants.RIGHT_BACK);

    // Sets Speed Controller Groups
    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);

    // Sets Differential Drive
    drive = new DifferentialDrive(leftMotors, rightMotors);

    // Sets Drive Pneumatics
    gearShift = new DoubleSolenoid(DriveConstants.KFORWARD, DriveConstants.KREVERSE);

    // NavX
    navx = new AHRS(SPI.Port.kMXP);
  }

  // Arcade Drive
  public void arcadeDrive(double rightJoystickAxis, double rightJoystickRotation) {
    double speed = DriveConstants.DRIVE_SPEED;
    drive.arcadeDrive(rightJoystickAxis * speed, rightJoystickRotation * speed);
  }
  
  // Tank Drive
  public void tankDrive(double leftJoystickAxis, double rightJoystickAxis) {
    double speed = DriveConstants.DRIVE_SPEED;
    drive.tankDrive(leftJoystickAxis * speed, rightJoystickAxis * speed);
  }

  public void changeGear(boolean bool) {
    if (bool = true) {
      gearShift.set(Value.kForward);
    }
    else if (bool = false) {
      gearShift.set(Value.kReverse);
    }
  }

  /**
   * Returns the heading of the robot.
   *
   * @return the robot's heading in degrees, from 180 to 180
   */
  public double getAngle() {
    return Math.IEEEremainder(navx.getAngle(), 360) * (DriveConstants.GYRO_REVERSED ? -1.0 : 1.0);  
  }
}
 