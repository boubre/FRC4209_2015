
package org.usfirst.frc.team4209.robot;

import org.usfirst.frc.team4209.robot.commands.ExampleCommand;
import org.usfirst.frc.team4209.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

    Command autonomousCommand;
    Command mecanumDrive;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
		oi = OI.getInstance();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
    @Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    @Override
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    	oi.drive.tankDrive(0, 0);
    	oi.forkliftMotor.set(0);
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        double deadzone = 0.05;
        double x = deadzone(deadzone, oi.leftJoy.getX());
        double y = deadzone(deadzone, oi.leftJoy.getY());
        double r = deadzone(deadzone, oi.rightJoy.getX());
        oi.drive.mecanumDrive_Cartesian(x, y, r, 0);
        
        double lift = deadzone(deadzone, oi.utilityJoy.getY());
        oi.forkliftMotor.set(lift);
        
        SmartDashboard.putNumber("Gyro", oi.gyro.getAngle());
        
        if (oi.leftJoy.getRawButton(1)) {
        	oi.gyro.reset();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
     * Thresholds a value based on the specified deadzone.
     * @param tolerance The deadzone tolerance.
     * @param value The value to threshold.
     * @return The thresholded value. (0 if less than tolerance.)
     */
    private double deadzone(double tolerance, double value) {
    	return Math.abs(value) >= tolerance ? value : 0;
    }
}
