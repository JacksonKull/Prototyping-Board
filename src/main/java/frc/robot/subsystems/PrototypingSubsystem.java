/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class PrototypingSubsystem {
    //Motors
    TalonSRX protoMotor1;
    TalonFX protoMotor2;
    TalonFX protoMotor3;
    TalonSRX protoMotor4;
    //Double
    double visionP;
    double tv;
    double ty;
    double tx;
    // NETWORK TABLE
	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	
    public PrototypingSubsystem(){
        protoMotor1 = new TalonSRX(0);
        protoMotor2 = new TalonFX(1);
        protoMotor3 = new TalonFX(2);
        protoMotor4 = new TalonSRX(3);
        //Limelight
        //tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getValue().getDouble();
        //ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getValue().getDouble();
	    //tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getValue().getDouble();
        //visionP = .25;
    }

    public void setprotoMotor1(double power){
        protoMotor1.set(ControlMode.PercentOutput, power);
    }

    public void setprotoMotor2(double power){
        protoMotor2.set(ControlMode.PercentOutput, power);
    }

    public void setprotoMotor3(double power){
        protoMotor3.set(ControlMode.PercentOutput, power);
    }

    public void setprotoMotor4(double power){
        protoMotor4.set(ControlMode.PercentOutput, power);
    }

    public double getTargetVisible(){
        return tv;
    }

    public double getTargetX(){
        return tx;
    }

    public double getTargetY(){
        return ty;
    }

    public double getVisionP(){
        return visionP;
    }
}
