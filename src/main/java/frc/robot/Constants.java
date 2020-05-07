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

    public static final class DriveConstants {
    // Drive Train Motor IDs
    public static final int LEFT_FRONT = 1;
    public static final int RIGHT_FRONT = 2;
    public static final int LEFT_BACK = 3;
    public static final int RIGHT_BACK = 4;
    
    // Drive Train Speed
    public static final int DRIVE_SPEED = 1;
    public static final Boolean DRIVE_SQUARE_INPUTS = true;

    // Drive Train Mode
    public static final Boolean TANK_DRIVE = false;
    public static final Boolean ARCADE_DRIVE = true;

    // Joysticks
    public static final int JOYSTICK_LEFT = 0;
    public static final int JOYSTICK_RIGHT = 1;
    public static final int XBOX_CONTROLLER = 2;

    // Joystick Axis
    public static final int JOYSTICK_LEFTAXIS = 0;
    public static final int JOYSTICK_RIGHTAXIS = 1;
    public static final int JOYSTICK_ROTATEAXIS = 0;
    }
}
