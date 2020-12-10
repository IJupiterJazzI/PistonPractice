package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class PneumaticSubsystem extends SubsystemBase {

    public void initDefaultCommand() {
        //TODO
        retract();
    }

    public boolean isPistonExtended() {
        boolean value = RobotMap.punchSolenoid.get();
        return value;
    }

    public void extend() {
        RobotMap.punchSolenoid.set(true);
    }

    public void retract() {
        RobotMap.punchSolenoid.set(false);
    }
}