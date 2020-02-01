package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.PrototypingSubsystem;

public class Robot extends TimedRobot {
  //Subsystems
  PrototypingSubsystem protoSystem;
  //Doubles
  double motor1;
  double motor2;
  double motor3;
  double motor4;
  double sdmotor1;
  double sdmotor2;
  double sdmotor3;
  double sdmotor4;
  double turretPower;
  double visionP;
  double tv;
  double ty;
  double tx;
  //Booleans
  boolean visionEnabled;
  // NETWORK TABLE
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  
  @Override
  public void robotInit() {
    protoSystem = new PrototypingSubsystem();
    //SmartDashboard Entries
    SmartDashboard.putNumber("Motor1", 0);
    SmartDashboard.putNumber("Motor2", 0);
    SmartDashboard.putNumber("Motor3", 0);
    SmartDashboard.putNumber("Motor4", 0);
    SmartDashboard.putBoolean("Vision Button", false);
    //Motor Powers
    sdmotor1 = SmartDashboard.getNumber("Motor1", 0);
    sdmotor2 = SmartDashboard.getNumber("Motor2", 0);
    sdmotor3 = SmartDashboard.getNumber("Motor3", 0);
    sdmotor4 = SmartDashboard.getNumber("Motor4", 0);
    //Vision Button
    visionEnabled = SmartDashboard.getBoolean("Vision Button", false);
    //Double
    turretPower = 0;
    //Vision
    try{
      tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getValue().getDouble();
      ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getValue().getDouble();
	    tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getValue().getDouble();
    }finally{
      System.out.println("Vision Not Yet Available!");
    }
    visionP = .08;
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
    System.out.println("Teleop");
     //Vision Data updates
     tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getValue().getDouble();
     ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getValue().getDouble();
     tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getValue().getDouble();
     visionEnabled = SmartDashboard.getBoolean("Vision Button", false);
     //System.out.println(tv + " " + tx + " " + ty);
     //Motor Powers
     sdmotor1 = SmartDashboard.getNumber("Motor1", 0);
     sdmotor2 = SmartDashboard.getNumber("Motor2", 0);
     sdmotor3 = SmartDashboard.getNumber("Motor3", 0);
     sdmotor4 = SmartDashboard.getNumber("Motor4", 0);  
 
     if(!visionEnabled){  
       System.out.println("NO vision");
       protoSystem.setprotoMotor1(sdmotor1);
       protoSystem.setprotoMotor2(sdmotor2);
       protoSystem.setprotoMotor3(sdmotor3);
       protoSystem.setprotoMotor4(sdmotor4);
     }else if(visionEnabled & tv > 0){
       System.out.println("Vision Active!");
       turretPower = -visionP*tx;
       System.out.println(turretPower);
       if(turretPower>.2){
          motor1 = .2;
          System.out.println(motor1);
          protoSystem.setprotoMotor1(motor1);
       }else if(turretPower<-.2){
          motor1 = -.2;
          System.out.println(motor1);
          protoSystem.setprotoMotor1(motor1);
       }else{
          motor1 = turretPower;
          System.out.println(motor1);
          protoSystem.setprotoMotor1(motor1);
        }
        if(tx>0 && tx<1){
          protoSystem.setprotoMotor1(0);
          protoSystem.setprotoMotor2(sdmotor2);
        }else if(tx<-0 && tx>-1){
          protoSystem.setprotoMotor1(0);
          protoSystem.setprotoMotor2(sdmotor2);
        }
     }
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
    //Vision Data updates
    tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getValue().getDouble();
    ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getValue().getDouble();
	  tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getValue().getDouble();
    visionEnabled = SmartDashboard.getBoolean("Vision Button", false);
   // System.out.println(tv + " " + tx + " " + ty); 
    //Motor Powers
    sdmotor1 = SmartDashboard.getNumber("Motor1", 0);
    sdmotor2 = SmartDashboard.getNumber("Motor2", 0);
    sdmotor3 = SmartDashboard.getNumber("Motor3", 0);
    sdmotor4 = SmartDashboard.getNumber("Motor4", 0);  

    if(!visionEnabled){  
      protoSystem.setprotoMotor1(sdmotor1);
      protoSystem.setprotoMotor2(sdmotor2);
      protoSystem.setprotoMotor3(sdmotor3);
      protoSystem.setprotoMotor4(sdmotor4);
    }else if(visionEnabled & tv > 0){
      System.out.println("Vision Active!");
      turretPower = protoSystem.getVisionP()*tx;
      motor1 = Math.min(.25, turretPower);
      System.out.println(motor1);
      protoSystem.setprotoMotor1(motor1);
    }
  }
}
