package frc.robot;

import frc.robot.commands.PunchIn;
import frc.robot.commands.PunchOut;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LaserSubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ManualRollIntake;

public class RobotContainer {

    // Creates an instance of the pneumatics subsystem
    public static PneumaticSubsystem pneumaticSubsystem = new PneumaticSubsystem();
    public static CameraSubsystem cameraSubsystem = new CameraSubsystem(); 
    public static LaserSubsystem laserSubsystem = new LaserSubsystem();
    public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    // This sets the port number for the Xbox controller to 0
    public static XboxController controller = new XboxController(0);

    // public final JoystickButton extendPunchButton = new JoystickButton(controller, 4);

    public RobotContainer() {
        // calls configureButtonBindings() which in effect makes it so that pressing 
        // "Y" makes the flipper extend out
        configureButtonBindings();

        intakeSubsystem.setDefaultCommand(
            new ManualRollIntake(intakeSubsystem)
        );
    }

    private void configureButtonBindings() {
        // Setting the command for pushing the flipper out when the 
        // driver presses "Y"
        
        new JoystickButton(controller, Button.kY.value).whenPressed(
            new PunchOut()
        );

        new JoystickButton(controller, Button.kA.value).whenPressed(
            new PunchIn()
        );
    }

}