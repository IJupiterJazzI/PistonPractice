/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LinearActuatorSubsystem;

public class ManualMoveActuator extends CommandBase {
  private LinearActuatorSubsystem actuator;
  private static XboxController controller = RobotContainer.controller;
  double rightStickYValue;
  double leftStickYValue;
  double vertPower;
  double boomPower;
  double boomEnc;
  double vertEnc;

  public ManualMoveActuator(LinearActuatorSubsystem linearActuator) {
    actuator = linearActuator;
    addRequirements(actuator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rightStickYValue = controller.getY(Hand.kRight);
    leftStickYValue = controller.getY(Hand.kLeft);
    vertEnc = actuator.getVertEncoder();
    boomEnc = actuator.getBoomEncoder();


    vertPower = rightStickYValue;
    boomPower = leftStickYValue;

    // deadband on the controller
    if (Math.abs(vertPower) < .2) {
      vertPower = 0;
    } 
    if (Math.abs(boomPower) < .2) {
      boomPower = 0;
    }

    //Makes sure we do not make the linear actuators move too far out 
    if ((vertEnc > 700) && (boomEnc > 400)) {
      actuator.setVertPower(-0.01);
      actuator.setBoomPower(-0.01);
    } else if (vertEnc > 700) {
      actuator.setVertPower(-0.01);
      actuator.setBoomPower(boomPower);
    } else if (boomEnc > 400) {
      actuator.setVertPower(vertPower);
      actuator.setBoomPower(-0.01);
    } else {
      //sets the boom and vert actuators to the power taken from the controllers 
      actuator.setVertPower(vertPower);
      actuator.setBoomPower(boomPower);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
