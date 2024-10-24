package frc.robot.subsystems.motor;

import com.revrobotics.CANSparkMax;

public class MotorSparkMax implements MotorIO{
    private final CANSparkMax motor;

    public MotorSparkMax() {
        motor = new CANSparkMax(1, MotorType.kBrushless);
    }

    @Override
    public void setMotorSpeed(double speed) {
        motor.set(speed);
    }
    
}
