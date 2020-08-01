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
  boolean preferredDrive;
  
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

    // Set Preferred Drive
    preferredDrive = DriveConstants.PREFERRED_DRIVE;
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

  // Default Drive
  public void drive(double axis1, double axis2, double axis3) {
    if (preferredDrive == DriveConstants.TANK_DRIVE) {
      drive.tankDrive(axis1, axis2);
    }
    else if (preferredDrive == DriveConstants.ARCADE_DRIVE) {
      drive.arcadeDrive(axis1, axis3);
    }
  }

  public void changePreferredDrive() {
    preferredDrive = !preferredDrive;
  }

  // Set Specific Gear
  public void setGear(String str) {
    if (str == "Forward") {
      gearShift.set(Value.kForward);
    }
    else if (str == "Reverse") {
      gearShift.set(Value.kReverse);
    }
  }

  // Changes Gear
  public void changeGear() {
    if (gearShift.get() == Value.kForward) {
      gearShift.set(Value.kReverse);
    }
    else if (gearShift.get() == Value.kReverse) {
      gearShift.set(Value.kForward);
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
 