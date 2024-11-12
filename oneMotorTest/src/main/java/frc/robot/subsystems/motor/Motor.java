package frc.robot.subsystems.motor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
    private final MotorIO motorIO;

    public Motor(MotorIO motorIO) {
        this.motorIO = motorIO;
    }

    public Command spinClockwise() {
        return run(
            () -> motorIO.setMotorSpeed(MotorConstants.kClockwiseMotorSpeed));
    }

    public Command spinCounterclockwise() {
        return run(
            () -> motorIO.setMotorSpeed(MotorConstants.kCounterclockwiseMotorSpeed));
    }

    public Command stopMotor() {
        return run(
            () -> motorIO.stop());
    }
}
