package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private final CANSparkMax leftFront, rightFront, leftBack, rightBack;

    private final MotorControllerGroup leftMotors, rightMotors;

    private final DifferentialDrive drive;

    public Drivetrain() {
        leftFront = new CANSparkMax(Constants.kLeftFrontMotorID, MotorType.kBrushless);
        rightFront = new CANSparkMax(Constants.kRightFrontMotorID, MotorType.kBrushless);
        leftBack = new CANSparkMax(Constants.kLeftBackMotorID, MotorType.kBrushless);
        rightBack = new CANSparkMax(Constants.kRightBackMotorID, MotorType.kBrushless);
        
        leftBack.follow(leftFront);
        rightBack.follow(rightFront);

        drive = new DifferentialDrive(leftFront, rightFront);

        rightFront.setInverted(true);

        leftFront.configFactoryDefault();
        rightFront.configFactoryDefault();
        leftBack.configFactoryDefault();
        rightBack.configFactoryDefault();
    }

    public void drive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        drive.tankDrive(0, 0);
    }
}
