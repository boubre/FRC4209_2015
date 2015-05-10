package org.usfirst.frc.team4209.robot.subsystems;

import org.usfirst.frc.team4209.robot.OI;
import org.usfirst.frc.team4209.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The robot drive train subsystem
 */
public class DriveTrain extends Subsystem {
	private static DriveTrain instance = new DriveTrain();
	
	/**
	 * @return The singleton instance of the drive train.
	 */
	public static DriveTrain getInstance() {
		return instance;
	}
	
	/**
	 * Create a new drive train.
	 */
	private DriveTrain() { }
	
	@Override
	public void initDefaultCommand() {

	}
	
	/**
	 * Drive the robot based on joystick input.
	 */
	public void drive() {
		OI oi = OI.getInstance();
        double x = Robot.deadzone(Robot.DEADZONE, oi.leftJoy.getX());
        double y = Robot.deadzone(Robot.DEADZONE, oi.leftJoy.getY());
        double r = Robot.deadzone(Robot.DEADZONE, oi.rightJoy.getX());
        oi.drive.mecanumDrive_Cartesian(x, y, r, 0);
	}
	
	/**
	 * Dive forward for autonomous.
	 */
	public void driveAuto() {
		OI oi = OI.getInstance();
		oi.drive.mecanumDrive_Cartesian(-1, 0, 0, oi.gyro.getAngle());
	}
	
	/**
	 * Drive the robot with the specified parameters.
	 * @param mag The magnitude of motion [-1,1].
	 * @param dir The direction of motion (degrees).
	 * @param rot Rotation to apply [-1,1].
	 */
	public void drive(double mag, double dir, double rot) {
		OI oi = OI.getInstance();
		oi.drive.mecanumDrive_Polar(mag, dir, rot);
	}
	
	/**
	 * Stop the robot.
	 */
	public void stop() {
		OI.getInstance().drive.tankDrive(0, 0);
	}
}