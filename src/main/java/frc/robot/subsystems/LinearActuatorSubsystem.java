/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LinearActuatorSubsystem extends SubsystemBase {
  /**
   * Creates a new LinearActuatorSubsystem.
   */
  private static final int TIMEOUT_MS = 10;
  private static final int ENC_COUNTS_PER_ROTATION = 4096;

  public static WPI_TalonSRX boomMotor = RobotMap.boomLinearActuatorMotor;
  public static WPI_TalonSRX vertMotor = RobotMap.vertLinearActuatorMotor;

  public LinearActuatorSubsystem() {
    vertMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, TIMEOUT_MS);
    boomMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, TIMEOUT_MS);

    vertMotor.set(ControlMode.PercentOutput, 0);
    boomMotor.set(ControlMode.PercentOutput, 0);

    vertMotor.setSensorPhase(true);
    boomMotor.setSensorPhase(false);
  }

  public void setVertPower(double power) {
    vertMotor.set(power);
  }

  public void setBoomPower(double power) {
    boomMotor.set(power);
  }

  public static double getBoomEncoder() {
    return(boomMotor.getSensorCollection().getQuadraturePosition());
  }

  public static double getVertEncoder() {
    return(boomMotor.getSensorCollection().getQuadraturePosition());
  }

  public static double getBoomEncoderRotations() {
    double rotations = getBoomEncoder()/ENC_COUNTS_PER_ROTATION;
    return rotations;
  }

  public static double getVertEncoderRotations() {
    double rotations = getVertEncoder()/ENC_COUNTS_PER_ROTATION;
    return rotations;
  }



  public void stop() {
    vertMotor.set(0.0);
    boomMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
