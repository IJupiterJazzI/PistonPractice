/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ManualRollIntake extends CommandBase {
  
  private final IntakeSubsystem intakeSubsystem;
  private final static XboxController manipulator = RobotContainer.controller;

  public ManualRollIntake(IntakeSubsystem intake) {
    intakeSubsystem = intake;
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean mLeftTrigger = manipulator.getTriggerAxis(Hand.kLeft) > 0.25;
    boolean mRightTrigger = manipulator.getTriggerAxis(Hand.kRight) > 0.25;

    if(mLeftTrigger) { // intake balls
      intakeSubsystem.spinInwards();
    } else if(mRightTrigger) { // outtake balls
      intakeSubsystem.spinOutwards();
    } else {
      intakeSubsystem.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
