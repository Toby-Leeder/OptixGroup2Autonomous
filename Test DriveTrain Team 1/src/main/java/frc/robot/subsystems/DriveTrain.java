package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import edu.wpi.first.wpilibj.motorcontrol.MotorController;

/**
 * Drivetrain
 * 
 * https://drive.google.com/drive/u/2/folders/1nbEa38pF2X69KUjKDAiirit1GARPqtWp - Tech slides
 * 
 * @author Aadit Gupta
 * @author Raadwan Masum
 * @author Rohan Juneja
 */
@SuppressWarnings("PMD.TooManyFields")
public class DriveTrain extends SubsystemBase {
  
  // initializes left motor variables
  private WPI_VictorSPX m_leftFrontMotor = new WPI_VictorSPX(Constants.CAN.drive_lf);
  private WPI_TalonSRX m_leftBackMotor = new WPI_TalonSRX(Constants.CAN.drive_lb);
  public SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(m_leftFrontMotor, m_leftBackMotor);
  
  // initializes right motor variables
  private WPI_VictorSPX m_rightFrontMotor = new WPI_VictorSPX(Constants.CAN.drive_rf);
  private WPI_TalonSRX m_rightBackMotor = new WPI_TalonSRX(Constants.CAN.drive_rb);
  public SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(m_rightFrontMotor, m_rightBackMotor);
  
  // controlls all variables simultaniously
  public DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  // used to controll the motors on the x axis and rotation
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }
  
  // constuctor for DriveTrain class
  public DriveTrain() {
    
    // sets the values to positive
    m_leftMotors.setInverted(true);
    m_rightMotors.setInverted(true);

  }
public void stopMotors(){
  m_drive.arcadeDrive(0,0);
}

  }
