/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {
  
  public static final double IN_POWER = 0.75;
  public static final double OUT_POWER = 0.565;

  public WPI_TalonSRX leftIntakeWheel = RobotMap.leftIntakeWheel;
  public WPI_TalonSRX rightIntakeWheel = RobotMap.rightIntakeWheel;

  public IntakeSubsystem() {
    leftIntakeWheel.setInverted(true);
    rightIntakeWheel.setInverted(false);
  }

  public void spinInwards() {
    leftIntakeWheel.set(IN_POWER);
    rightIntakeWheel.set(IN_POWER);
  }

  public void spinOutwards() {
    leftIntakeWheel.set(OUT_POWER);
    rightIntakeWheel.set(OUT_POWER);
  }

  public void stop() {
    leftIntakeWheel.set(0);
    rightIntakeWheel.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
