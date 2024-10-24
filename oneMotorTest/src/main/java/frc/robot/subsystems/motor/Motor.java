package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drivetrain extends SubsystemBase {
    // Declare a single VictorSPX motor controller
    private final WPI_VictorSPX motor;

    /** Constructs a MotorSubsystem */
    public Drivetrain() {
        // Create a new motor controller object and specify its CAN ID from the Constants class
        motor = new WPI_VictorSPX(1); // Use appropriate motor ID from Constants
        // Configure factory defaults for the motor
        motor.configFactoryDefault();
    }

    /**
     * Sets the speed of the motor
     * @param speed The desired speed of the motor (range: -1.0 to 1.0)
     */
    public void setMotorSpeed(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.set(0); // Stop the motor
    }

    @Override
    public void periodic() {
        // This method can be used for periodic updates if needed
    }
}
