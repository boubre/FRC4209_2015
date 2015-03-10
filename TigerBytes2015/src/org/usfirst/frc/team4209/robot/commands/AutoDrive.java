
package org.usfirst.frc.team4209.robot.commands;

import org.usfirst.frc.team4209.robot.OI;
import org.usfirst.frc.team4209.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives Forward Autonomously
 */
public class AutoDrive extends Command {
	private static DriveTrain drivetrain = DriveTrain.getInstance();
	private Timer timer;
	private double driveTime; //seconds
	
	/**
	 * Create a new AutoDrive
	 * @param time in seconds to drive
	 */
    public AutoDrive(double time) {
    	super("AutoDrive");
		requires(drivetrain);
		timer = new Timer();
		driveTime = time;
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    	OI.getInstance().gyro.reset();
    	timer.start();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
    	drivetrain.driveAuto();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return timer.get() >= driveTime;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    	drivetrain.stop();
    	timer.stop();
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    	drivetrain.stop();
    }
}
