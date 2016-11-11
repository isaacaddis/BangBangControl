
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	//Declare variables at the top-most scope so it can be used by all the functions in this class
	TalonSRX talon;
	Encoder encode;
	Shooter shoot;
	BangBang bang;
	DoubleSolenoid kick;
    public void robotInit() {
    	talon = new TalonSRX(3); //Arbitary ports, consult with your robot for your own
    	encode = new Encoder(1, 0); //^ See above comment
    	kick = new DoubleSolenoid(1,2); //Again ^^
    	shoot = new Shooter(talon, encode,kick); //Init shooter
    	bang = new BangBang(shoot); //Initalize bangbang control
    }
    public void autonomousInit() {

    }
    public void autonomousPeriodic() {

    }
    public void teleopPeriodic() {
    	//This is where the magic occurs. The BangBang system runs periodically now during teleop
    	bang.update();
    }
    public void testPeriodic() {
    
    }
    
}
