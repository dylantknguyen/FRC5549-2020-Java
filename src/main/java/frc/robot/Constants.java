/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ButtonConstants {
        // Driver Buttons
        public static final int GEAR_SHIFT_BUTTON = 1;
        public static final int DRIVE_TYPE_BUTTON = 2;
        
        // Operator Axis
        public static final int INTAKE_AXIS = 1;
        public static final int LIFT_AXIS = 2;
        public static final int SHOOTER_AXIS = 3;

        // Operator Buttons
        public static final int LIFT_STATUS_BUTTON = 5;
        public static final int AUTO_AIM_BUTTON = 6;

        // Tolerance
        public static final double CONTROLLER_TOLERANCE = 0.25;
        public static final double XBOX_TOLERANCE = 0.25;
        
    }

    public static final class DriveConstants {
        // Drive Train Motor IDs
        public static final int LEFT_FRONT = 1;
        public static final int RIGHT_FRONT = 2;
        public static final int LEFT_BACK = 3;
        public static final int RIGHT_BACK = 4;
        
        // Drive Train Speed
        public static final double DRIVE_SPEED = 1;
        public static final boolean DRIVE_SQUARE_INPUTS = true;

        // Drive Train Mode
        public static final boolean TANK_DRIVE = false;
        public static final boolean ARCADE_DRIVE = true;
        public static final boolean PREFERRED_DRIVE = false;

        // Joysticks
        public static final int JOYSTICK_LEFT = 0;
        public static final int JOYSTICK_RIGHT = 1;
        public static final int XBOX_CONTROLLER = 2;

        // Joystick Axis
        public static final int JOYSTICK_LEFTAXIS = 0;
        public static final int JOYSTICK_RIGHTAXIS = 1;
        public static final int JOYSTICK_ROTATEAXIS = 0;

        // Gear Shifting
        public static final int KFORWARD = 2;
        public static final int KREVERSE = 3;

        // PID
        public static final double kP = 0.17;
        public static final double kI = 0.005;
        public static final double kD = 0.01;

        // Tolerants
        public static final double TURN_TOLERANCE_DEGREES = 2;
        public static final boolean GYRO_REVERSED = false;

    }

    public static final class IndexerConstants {
        // Indexer Motor IDs
        public static final int VERTICAL_INDEXER_LEFT = 10;
        public static final int VERTICAL_INDEXER_RIGHT = 9;
        public static final int FLAT_INDEXER = 12;

        // Limit Switch
        public static final int LIMIT_SWITCH = 0;

        // Indexer Speeds
        public static final double VERTICAL_INDEXER_SPEED = 0.75;
        public static final double FLAT_INDEXER_SPEED = 1.0;

    }

    public static final class IntakeConstants {
        // Intake Motor IDs
        public static final int MOTOR = 11;

        // Intake Speeds
        public static final double SPEED = 0.75;
    }

    public static final class LiftConstants {
        // Lift Motor IDs
        public static final int MOTOR = 13;

        // Lift Speeds
        public static final double SPEED = 1;
    }

    public static final class LimelightConstants {
        public static final double HEIGHT_CAMERA = 20.0;
        public static final double HEIGHT_TARGET = 98.25;
        public static final double ANGLE_CAMERA = 24.25;

    }

    public static final class SemicircleConstants {
        // Semicircle Motor IDs
        public static final int MOTOR = 14;

        // Semicircle Speeds
        public static final double SPEED = 0.75;

        // Limit Switch Port
        public static final int LIMIT_SWITCH_PORT = 0;

        // Color Sensor Sensitivity
        public static final int COLOR_SENSOR_SENSITIVITY = 170;
    }

    public static final class ShooterConstants {
        // Intake Motor IDs
        public static final int TOP_ENCODER = 5;
        public static final int TOP_MOTOR = 6;
        public static final int BOTTOM_ENCODER = 7;
        public static final int BOTTOM_MOTOR = 8;
        public static final double VEL_RPM_CONVERSION = 600/4096;
        public static final int TOP_MAX_RPM = 4400;
        public static final int BOTTOM_MAX_RPM = 4400;

        public static final class PIDTop {
            // Top PIDF
            public static final double kP = 0.17;
            public static final double kI = 0.005;
            public static final double kD = 0.01;
            public static final double kF = 0.05;

            // Tolerants
            public static final double TURN_TOLERANCE_DEGREES = 2;
        }
        public static final class PIDBottom {
            // Bottom PIDF
            public static final double kP = 0.3;
            public static final double kI = 0;
            public static final double kD = 0.05;
            public static final double kF = 0.90;
        }
    }
}
