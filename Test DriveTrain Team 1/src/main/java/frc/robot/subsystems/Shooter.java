// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.controller.PIDController;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem.*/
  public CANSparkMax m_motor = new CANSparkMax(10, MotorType.kBrushless);
  private CANPIDController m_pidController = m_motor.getPIDController();
  private PIDController m_pidController2;
  private CANEncoder m_encoder = m_motor.getEncoder();
  
  
   public double kP = .006; 
   public double kI = 0;
   public double kD = 0; 
   public double kIz = 0; 
   public double kFF = 0.000015; 
   public double kMaxOutput = 1; 
   public double kMinOutput = -1;
   public double maxRPM = 5700;

  public Shooter(){
    m_motor.restoreFactoryDefaults();
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    m_pidController2 = new PIDController(kP,kI,kD);
    
  }

  public double getEncoderValue() {
    return m_encoder.getVelocity();
  }
  public void set(double current, double target) {
    m_motor.set(m_pidController2.calculate(current, target) * 0.004);
    System.out.println(m_pidController2.calculate(current, target) * 0.004);
  }
  public void stop(){
    m_motor.set(0);
  }
}

