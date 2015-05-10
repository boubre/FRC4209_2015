package org.usfirst.frc.team4209.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static OI instance = null;
	
////CREATING BUTTONS
   // One type of button is a joystick button which is any button on a joystick.
   // You create one by telling it which joystick it's on and which button
   // number it is.
   // Joystick stick = new Joystick(port);
   // Button button = new JoystickButton(stick, buttonNumber);
	public Joystick leftJoy;
	public Joystick rightJoy;
	public Joystick utilityJoy;
	
	public DigitalInput ceilingSwitch;
	public DigitalInput floorSwitch;
	
	private SpeedController leftFrontTalon;
	private SpeedController rightFrontTalon;
	private SpeedController rightBackTalon;
	private SpeedController leftBackTalon;
	
	public SpeedController forkliftMotor;
	
	public RobotDrive drive;
	
	public Gyro gyro;
	
	//public Encoder forkliftEncoder;
	
	public DoubleSolenoid armPiston;
	
	public JoystickButton pistonToggle;
	
   // There are a few additional built in buttons you can use. Additionally,
   // by subclassing Button you can create custom triggers and bind those to
   // commands the same as any other Button.
   
   //// TRIGGERING COMMANDS WITH BUTTONS
   // Once you have a button, it's trivial to bind it to a button in one of
   // three ways:
   
   // Start the command when the button is pressed and let it run the command
   // until it is finished as determined by it's isFinished method.
   // button.whenPressed(new ExampleCommand());
   
   // Run the command while the button is being held down and interrupt it once
   // the button is released.
   // button.whileHeld(new ExampleCommand());
   
   // Start the command when the button is released  and let it run the command
   // until it is finished as determined by it's isFinished method.
   // button.whenReleased(new ExampleCommand());
	
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}
	
	private OI() {
		gyro = new Gyro(0);
		
		//forkliftEncoder = new Encoder(0, 1, false, CounterBase.EncodingType.k4X);
		//forkliftEncoder.setDistancePerPulse(1 / 720.0);
		
		leftJoy = new Joystick(0);
		rightJoy = new Joystick(1);
		utilityJoy = new Joystick(2);
		
		rightFrontTalon = new Talon(0);
		rightBackTalon = new Talon(1);
		leftFrontTalon = new Talon(2);
		leftBackTalon = new Talon(3);
		
		ceilingSwitch = new DigitalInput(1);
		//floorSwitch = new DigitalInput(0);
		
		
		forkliftMotor = new Victor(4);
		
		armPiston = new DoubleSolenoid(0,1);
		
		drive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
		
		pistonToggle = new JoystickButton(utilityJoy, 2);
	}
	
}
