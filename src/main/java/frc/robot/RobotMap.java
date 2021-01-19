package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;

public class RobotMap {
    // Setting the port numbers for the pneumatics
    public static Solenoid punchSolenoid = new Solenoid(0, 4); 
    public static AnalogInput laserVision = new AnalogInput(3);

    public static final int LEFT_INTAKE = 21;
    public static final int RIGHT_INTAKE = 22;

    public static WPI_TalonSRX leftIntakeWheel = new WPI_TalonSRX(LEFT_INTAKE);
    public static WPI_TalonSRX rightIntakeWheel = new WPI_TalonSRX(RIGHT_INTAKE);
}