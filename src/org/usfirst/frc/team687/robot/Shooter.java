package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;

public class Shooter{
	private TalonSRX m_shoot;
	private long lastTime;
	private Encoder m_encode;
	private DoubleSolenoid m_kick;
	private double lastTicks;
	public Shooter(TalonSRX shoot, Encoder shooterEncoder, DoubleSolenoid kick){
		m_shoot = shoot;
		m_encode = shooterEncoder;
		m_kick = kick;
	}
	//Calculate RPM using Java built in timer and Encoder class from WPILIB
	double getRPM(){
		double dt = (System.currentTimeMillis() - lastTime);
		double lastTime = System.currentTimeMillis();
		double currentTicks = m_encode.getRaw();
		double rate = (currentTicks - lastTicks)/dt;
		return (rate * 60 * 1000);	
	}	
	void setFlyPow(int in){
		m_shoot.set(in);
	}
	//Deliver the push that sends game piece or whatever is on your wheels flying
	void shoot(){
		m_kick.set(DoubleSolenoid.Value.kForward);
	}
}
