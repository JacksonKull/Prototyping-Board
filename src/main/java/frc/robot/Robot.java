package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.PrototypingSubsystem;

public class Robot extends TimedRobot {
  // Subsystems
  PrototypingSubsystem protoSystem;
  // Doubles
  double motor1, motor2, motor3, motor4;

  @Override
  public void robotInit() {
    protoSystem = new PrototypingSubsystem();
    // SmartDashboard Entries
    SmartDashboard.putNumber("Motor1", 0);
    SmartDashboard.putNumber("Motor2", 0);
    SmartDashboard.putNumber("Motor3", 0);
    SmartDashboard.putNumber("Motor4", 0);
    SmartDashboard.putBoolean("Vision Button", false);
    // Motor Powers
    motor1 = SmartDashboard.getNumber("Motor1", 0);
    motor2 = SmartDashboard.getNumber("Motor2", 0);
    motor3 = SmartDashboard.getNumber("Motor3", 0);
    motor4 = SmartDashboard.getNumber("Motor4", 0);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    // Motor Powers
    motor1 = SmartDashboard.getNumber("Motor1", 0);
    motor2 = SmartDashboard.getNumber("Motor2", 0);
    motor3 = SmartDashboard.getNumber("Motor3", 0);
    motor4 = SmartDashboard.getNumber("Motor4", 0);
    // Setting Motor Powers
    protoSystem.setprotoMotor1(motor1);
    protoSystem.setprotoMotor2(motor2);
    protoSystem.setprotoMotor3(motor3);
    protoSystem.setprotoMotor4(motor4);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
    // Motor Powers
    motor1 = SmartDashboard.getNumber("Motor1", 0);
    motor2 = SmartDashboard.getNumber("Motor2", 0);
    motor3 = SmartDashboard.getNumber("Motor3", 0);
    motor4 = SmartDashboard.getNumber("Motor4", 0);
    // Setting Motor Powers
    protoSystem.setprotoMotor1(motor1);
    protoSystem.setprotoMotor2(motor2);
    protoSystem.setprotoMotor3(motor3);
    protoSystem.setprotoMotor4(motor4);
  }
}
