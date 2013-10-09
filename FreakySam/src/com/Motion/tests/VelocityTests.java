package com.Motion.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.LengthSystem.Mile;
import com.LengthSystem.Unit;
import com.Motion.Velocity;
import com.TimeSystem.Hour;
import com.TimeSystem.Min;
import com.TimeSystem.Sec;

public class VelocityTests {

	@Test
	public void _65mi_hr_dist_in_15_min_test() {
		/*
		 * You're on a straight highway, and you decide to set the cruise control at 65mi/hr. 
		 * After 15 minutes, how far have you gone?
		 * */
		Velocity currVel = new Velocity(new Mile(65), new Hour(1));
		Mile exp_dist = new Mile("65/4");
				
		assertEquals(exp_dist, currVel.getDisplacement(new Min(15)));
		
	}

	@Test
	public void _neg5px_sec_200px_3sec_test()
	{
		/*
		 * Suppose you're programming a moving platform for the player to jump on. 
		 * The platform can move only left (–) and right (+). 
		 * The platform is moving at a constant velocity of –5px/s. 
		 * If it's currently at the 200-pixel mark, 
		 * where should it be 3 seconds later 
		 * (assuming that it hasn't reached the point where it turns around)?
		 * */
		Velocity currVel = new Velocity(new Unit("-5"), new Sec("1"));
		Unit exp_dist = new Unit(-15);
		
		assertEquals(exp_dist, currVel.getDisplacement(new Sec(3)));
	}
}
