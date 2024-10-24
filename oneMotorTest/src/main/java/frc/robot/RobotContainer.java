package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
    private final Drivetrain motorSubsystem;
    private final XboxController controller;

    public RobotContainer() {
        motorSubsystem = new Drivetrain(0); // Motor on PWM port 0
        controller = new XboxController(0); // Xbox controller on port 0

        // Set the default command for the motor subsystem
        motorSubsystem.setDefaultCommand(new RunCommand(
            () -> motorSubsystem.setMotorSpeed(controller.getY(0)), 
            motorSubsystem
        ));
    }

    // Optional: Provide a method to return the autonomous command
    public Command getAutonomousCommand() {
        return null; // No autonomous command in this example
    }
}