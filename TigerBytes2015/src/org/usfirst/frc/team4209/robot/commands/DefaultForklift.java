package org.usfirst.frc.team4209.robot.commands;

import org.usfirst.frc.team4209.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultForklift extends Command {
	private static Forklift forklift = Forklift.getInstance();
	
	public DefaultForklift() {
		super("DefaultForklift");
		requires(forklift);
	}
	
	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		forklift.move();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		forklift.stop();
	}

	@Override
	protected void interrupted() {
		forklift.stop();
	}

}
