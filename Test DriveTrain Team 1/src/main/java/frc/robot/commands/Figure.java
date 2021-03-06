// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project./
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

// /** An example command that uses an example subsystem. */

public class Figure extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_drive;
  private final Timer m_timer = new edu.wpi.first.wpilibj.Timer();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Figure(DriveTrain drive) {
    m_drive = drive;
    addRequirements(m_drive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
    if (m_timer.get() < 4){
      m_drive.arcadeDrive(Constants.CAN.AutoSpeed, -Constants.CAN.loopRotation);
    }
    else if (m_timer.get() < 12 && m_timer.get() > 4){
      m_drive.arcadeDrive(Constants.CAN.AutoSpeed, Constants.CAN.loopRotation);
    }
    else if (m_timer.get() < 16 && m_timer.get() > 12){
      m_drive.arcadeDrive(Constants.CAN.AutoSpeed, -Constants.CAN.loopRotation);
    }   
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_timer.get() < 2){
      m_drive.arcadeDrive(Constants.CAN.AutoSpeed, -Constants.CAN.loopRotation);
    }
    else if (m_timer.get() < 6 && m_timer.get() > 2){
      m_drive.arcadeDrive(Constants.CAN.AutoSpeed, Constants.CAN.loopRotation);
    }
    else if (m_timer.get() < 8 && m_timer.get() > 6){
      m_drive.arcadeDrive(Constants.CAN.AutoSpeed, -Constants.CAN.loopRotation);
    }   
  }
// Negative Constants.CAN makes motor turn other way.

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_timer.get() > 8;
  }
}
