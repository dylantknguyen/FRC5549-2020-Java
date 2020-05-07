/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimelightConstants;

public class Limelight extends SubsystemBase {
  NetworkTable limelightTable;
  double ty, tv, tx, angle, distance;

  public Limelight() {
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    ty = limelightTable.getEntry("ty").getDouble(0);
    tv = limelightTable.getEntry("tv").getDouble(0);
    tx = limelightTable.getEntry("tv").getDouble(0);
  }

  public double getAngle() {
    if (ty != 0) {
      return ty;
    }
    return 0;
  }

  public double getDistance() {
    if (tv != 0) {
      angle = (LimelightConstants.ANGLE_CAMERA + ty) * Math.PI / 180;
      distance = (LimelightConstants.HEIGHT_TARGET - LimelightConstants.HEIGHT_CAMERA) / Math.tan(angle);
      return distance;
    }
    return 0;
  }

  public void setLEDMode(boolean bool) {
    if (bool) {
      limelightTable.getEntry("ledMode").setNumber(3);
    }
    else {
      limelightTable.getEntry("ledMode").setNumber(1);
    }
  }
}
