/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.PneumaticSubsystem;;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PunchOut extends InstantCommand {

  // creates an object/instance of the pneumatic subsystem so that we can
  // call methods from that subsystem
  private final PneumaticSubsystem pneumaticSubsystem;
  //TODO

  public PunchOut(PneumaticSubsystem punch) {
    // Use addRequirements() here to declare subsystem dependencies.
    pneumaticSubsystem = punch;
    addRequirements(punch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pneumaticSubsystem.extend();
  }
}
