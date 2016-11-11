package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.TalonSRX;

public class BangBang implements Loopable {
	private double m_desiredRPM = 4000; //Random number, you'll have to test for the RPM that works best for you
	private Shooter m_shoot;
	/*
	 * Initialize control
	 */
	public BangBang(Shooter shooter){
		m_shoot = shooter;
	}
	// Main control all happens here
	@Override
	public void update() {
		if(m_shoot.getRPM() < m_desiredRPM){
			m_shoot.setFlyPow(1);
		}
		else{
			m_shoot.setFlyPow(0);
		}
		if(Math.abs(m_shoot.getRPM()-m_desiredRPM)<50){
			m_shoot.shoot();
		}
	}
}
