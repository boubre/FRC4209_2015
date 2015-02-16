package org.usfirst.frc.team4209.robot.subsystems;

import org.usfirst.frc.team4209.robot.OI;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The arm piston subsystem.
 */
public class Arm extends Subsystem {
	private static Arm instance = new Arm();
	
	/**
	 * @return The singleton instance of the arm.
	 */
	public static Arm getInstance() {
		return instance;
	}
	
	/**
	 * Create a new arm.
	 */
	private Arm() { }
	
	@Override
	protected void initDefaultCommand() { }

	public void open() {
		OI.getInstance().armPiston.set(Value.kForward);
	}
	
	public void close() {
		OI.getInstance().armPiston.set(Value.kReverse);
	}
}
