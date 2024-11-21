package frc.robot.subsystems.vision;

import frc.robot.subsystems.vision.PhotonCamera;
import frc.robot.subsystems.vision.PhotonPipelineResult;
import frc.robot.subsystems.vision.PhotonTrackedTarget;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.vision.VisionConstants;
import java.util.List;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision extends SubsystemBase {
    private final PhotonCamera camera;
    private PhotonPipelineResult currentResult;
    private List<PhotonTrackedTarget> currentTargets;
    private PhotonTrackedTarget currentBestTarget;
    public Pose2d[] estimate = new Pose2d[0];
    public double timestamp = 0;
    public double[] timestampArray = new double[0];
    public boolean hasEstimate = false;
    public byte[] results;
    
    public Vision() {
        camera = new PhotonCamera("7587_Camera");
    }

    public void getLatestResult() {
        currentResult = camera.getLatestResult();
    }

    public void getLatestTargets() {
        currentTargets = currentResult.getTargets();
        currentBestTarget = currentResult.getBestTarget();
    }

    public boolean hasTargets() {
        return currentResult.hasTargets();
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Has Targets", hasTargets());
        if (hasTargets()) {
            SmartDashboard.putNumber("Best Target Area", currentBestTarget.getArea());
            SmartDashboard.putNumber("Best Target X", currentBestTarget.getPitch());
            SmartDashboard.putNumber("Best Target Y", currentBestTarget.getYaw());
            SmartDashboard.putNumber("Best Target ID", currentBestTarget.getFiducialId());
        }
    }
}
