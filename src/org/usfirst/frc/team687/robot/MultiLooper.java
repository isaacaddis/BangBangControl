package org.usfirst.frc.team687.robot;

import java.util.Vector;

/**
 * @author Team 254
 *
 */

public class MultiLooper implements Loopable {
	
	private Looper m_looper;
	private Vector<Loopable> m_loopables = new Vector<Loopable>();
	
	public MultiLooper(String name, double period)	{
		m_looper = new Looper(name, this, period);
	}
	
	@Override
	public void update() {
		for(int i = 0; i < m_loopables.size(); i++)	{
			m_loopables.get(i).update();
		}
	}
	
	public void addLoopable(Loopable loopable)	{
		m_loopables.add(loopable);
	}
	
	public void start()	{
		m_looper.start();
	}
	
	public void stop()	{
		m_looper.stop();
	}

}