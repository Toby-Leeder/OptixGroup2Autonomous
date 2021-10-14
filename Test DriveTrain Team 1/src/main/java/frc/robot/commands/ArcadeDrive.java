// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;


public class ArcadeDrive extends CommandBase {

    // intializes movement variables
    private final DriveTrain m_drive;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;
  
    /**
     * 
     * @param drive
     * @param forward
     * @param rotation
     */

     // constrcutor
    public ArcadeDrive(DriveTrain drive, DoubleSupplier forward, DoubleSupplier rotation) {
      m_drive = drive;
      m_forward = forward;
      m_rotation = rotation;
      addRequirements(m_drive);
    }
    
    // runs command
    @Override
    public void execute() {
      m_drive.arcadeDrive(-m_forward.getAsDouble(), m_rotation.getAsDouble());
    }
  }
