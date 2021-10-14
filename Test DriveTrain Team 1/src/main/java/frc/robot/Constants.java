// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.CAN;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int leftFront = 24, leftBack = 13, rightFront = 23, rightback = 15;
    public static class CAN {
        public static final int drive_lf = 24;
        public static final int drive_lb = 13;
        public static final int drive_rf = 23;
        public static final int drive_rb = 15;
        public static final double AutoSpeed = .5;
        public static final int loopRotation = 1;
         
  }

}
