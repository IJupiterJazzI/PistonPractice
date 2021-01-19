package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PneumaticSubsystem extends SubsystemBase {

    public void initDefaultCommand() {

    }

    public boolean isPistonExtended() {
        boolean value = RobotMap.punchSolenoid.get();
        SmartDashboard.putBoolean("Is Piston Extended", value);
        return value;
    }

    public void extend() {
        RobotMap.punchSolenoid.set(true);
    }

    public void retract() {
        RobotMap.punchSolenoid.set(false);
    }
}