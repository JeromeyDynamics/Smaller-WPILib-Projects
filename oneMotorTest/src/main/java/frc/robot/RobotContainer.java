package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.motor.Motor;
import frc.robot.subsystems.motor.MotorSparkMax;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class RobotContainer {
    private final Motor motor = new Motor(new MotorSparkMax());

    CommandXboxController controller = new CommandXboxController(Constants.kDriverControllerPort);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // Left Bumper: turns the motor counterclockwise only when the left bumper is pressed
        controller.leftBumper().toggleOnTrue(motor.spinCounterclockwise())
            .and(controller.leftBumper().negate()).toggleOnTrue(motor.stopMotor());

        // Right Bumper: turns the motor clockwise
        controller.rightBumper().toggleOnTrue(motor.spinClockwise())
            .and(controller.rightBumper().negate()).toggleOnTrue(motor.stopMotor());
    }

    // Optional: Provide a method to return the autonomous command
    public Command getAutonomousCommand() {
        return null; // No autonomous command in this example
    }
}