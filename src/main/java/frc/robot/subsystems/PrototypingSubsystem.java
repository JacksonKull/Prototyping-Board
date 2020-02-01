/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class PrototypingSubsystem {
    // Motors
    TalonSRX protoMotor1;
    TalonSRX protoMotor2;
    TalonSRX protoMotor3;
    TalonSRX protoMotor4;

    public PrototypingSubsystem() {
        protoMotor1 = new TalonSRX(0);
        protoMotor2 = new TalonSRX(1);
        protoMotor3 = new TalonSRX(2);
        protoMotor4 = new TalonSRX(3);
    }

    public void setprotoMotor1(double power) {
        protoMotor1.set(ControlMode.PercentOutput, power);
    }

    public void setprotoMotor2(double power) {
        protoMotor2.set(ControlMode.PercentOutput, power);
    }

    public void setprotoMotor3(double power) {
        protoMotor3.set(ControlMode.PercentOutput, power);
    }

    public void setprotoMotor4(double power) {
        protoMotor4.set(ControlMode.PercentOutput, power);
    }
}
