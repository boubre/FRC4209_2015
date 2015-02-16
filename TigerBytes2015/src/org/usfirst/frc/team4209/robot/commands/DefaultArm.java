package org.usfirst.frc.team4209.robot.commands;

import org.usfirst.frc.team4209.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultArm extends Command {
	private static Arm arm = Arm.getInstance();
	private boolean isOpen = false;
	
	public DefaultArm() {
		super("DefaultArm");
		requires(arm);
	}

	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		if (isOpen) {
			arm.close();
		} else {
			arm.open();
		}
		isOpen = !isOpen;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() { }

	@Override
	protected void interrupted() { }	
}
