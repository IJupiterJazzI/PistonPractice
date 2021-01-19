/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LaserSubsystem extends SubsystemBase {
  /**
   * Creates a new LaserSubsystem.
   */

  public LaserSubsystem() {

  }

  public static double getLaserDistance() {
    double volts = RobotMap.laserVision.getAverageVoltage();
    double distance = (volts * 28.9) + 2.78;
    return(distance);
  }

  public static double getLaserVoltage() {
    double voltage = RobotMap.laserVision.getAverageVoltage();
    return(voltage);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
