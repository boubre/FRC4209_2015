package org.usfirst.frc.team4209.robot.subsystems;

import org.usfirst.frc.team4209.robot.OI;
import org.usfirst.frc.team4209.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The forklift subsystem.
 */
public class Forklift extends Subsystem{
	private static Forklift instance = new Forklift();
	
	/**
	 * @return The singleton instance of this subsystem.
	 */
	public static Forklift getInstance() {
		return instance;
	}
	
	/**
	 * Create a new forklift
	 */
	private Forklift() { }
	
	@Override
	protected void initDefaultCommand() { }
	
	/**
	 * Move the forklift based on joystick input.
	 */
	public void move() {
		OI oi = OI.getInstance();
		double lift = Robot.deadzone(Robot.DEADZONE, oi.utilityJoy.getY());
		if ((lift > 0 && oi.ceilingSwitch.get()) || (lift < 0 && oi.floorSwitch.get())) {
			lift = 0;
		}
        oi.forkliftMotor.set(lift);
	}
	
	/**
	 * Stop the forklift.
	 */
	public void stop() {
		OI.getInstance().forkliftMotor.set(0);
	}

}
