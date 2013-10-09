package com.app;

import com.LengthSystem.LENGTH_SLOT;
import com.LengthSystem.Mile;
import com.Motion.Acceleration;
import com.Motion.Velocity;
import com.TimeSystem.Hour;
import com.TimeSystem.Sec;
import com.TimeSystem.TIME_SLOT;
import com.TimeSystem.Time;

public class Main {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Velocity a = new Velocity(new Mile(50), new Hour(1)),
				 b = new Velocity(new Mile(10), new Hour(1));
		
		Time t = new Sec(3);
		
		Acceleration acc = new Acceleration(a, b, t);
		
		System.out.println(acc.getAcceleration(LENGTH_SLOT.UNIT, TIME_SLOT.SEC));
	}
		
}
