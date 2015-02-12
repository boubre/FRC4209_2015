package org.usfirst.frc.team4209.robot.commands;

import org.usfirst.frc.team4209.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultDrive extends Command {
	private static DriveTrain drivetrain = DriveTrain.getInstance();

	public DefaultDrive() {
		super("DefaultDrive");
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() { }

	@Override
	protected void execute() {
		drivetrain.drive();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.stop();
	}

	@Override
	protected void interrupted() {
		drivetrain.stop();
	}

}
