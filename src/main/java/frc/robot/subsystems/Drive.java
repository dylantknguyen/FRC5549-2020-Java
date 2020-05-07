/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drive extends SubsystemBase {
    // Sets Motors
    WPI_TalonSRX leftFront = new WPI_TalonSRX(DriveConstants.LEFT_FRONT);
    WPI_TalonSRX rightFront = new WPI_TalonSRX(DriveConstants.RIGHT_FRONT);
    WPI_TalonSRX leftBack = new WPI_TalonSRX(DriveConstants.LEFT_BACK);
    WPI_TalonSRX rightBack = new WPI_TalonSRX(DriveConstants.RIGHT_BACK);

    // Creates Speed Controller Groups
    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFront, rightBack);

    // Create Differential Drive
    DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);

  @Override
  public void periodic() {
    // Inverts Motors where Required
    rightFront.setInverted(true);
    rightBack.setInverted(true);
  }

  public void arcadeDrive(int leftJoystickAxis, int rightJoystickAxis) {
      int speed = DriveConstants.DRIVE_SPEED;
      drive.arcadeDrive(leftJoystickAxis * speed, rightJoystickAxis * speed);
  }

  public void tankDrive(int leftJoystickAxis, int rightJoystickAxis) {
    int speed = DriveConstants.DRIVE_SPEED;
    drive.tankDrive(leftJoystickAxis * speed, rightJoystickAxis * speed);
  }
}
 