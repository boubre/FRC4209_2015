package org.usfirst.frc.team4209.robot.commands;

import org.usfirst.frc.team4209.robot.OI;
import org.usfirst.frc.team4209.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DefaultArm extends Command {
	private static Arm arm = Arm.getInstance();
	private boolean isOpen = false;
	private Timer timer;
	private double deadTime = .5;
	private double lastTime = 0 - deadTime;
	
	public DefaultArm() {
		super("DefaultArm");
		requires(arm);
		timer = new Timer();
	}

	@Override
	protected void initialize() { 
		timer.start();
	}

	@Override
	protected void execute() {
		if (OI.getInstance().utilityJoy.getRawButton(2) &&
				timer.get() - lastTime > deadTime) {
			lastTime = timer.get();
			if (isOpen) {
				arm.close();
			} else {
				arm.open();
			}
			isOpen = !isOpen;
		}
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() { 
		timer.stop();
	}

	@Override
	protected void interrupted() { }	
}
