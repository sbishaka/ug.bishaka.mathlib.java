package com.Motion.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.LengthSystem.LENGTH_SLOT;
import com.LengthSystem.Mile;
import com.LengthSystem.Unit;
import com.Motion.Acceleration;
import com.Motion.Velocity;
import com.TimeSystem.Hour;
import com.TimeSystem.Sec;
import com.TimeSystem.TIME_SLOT;
import com.TimeSystem.Time;

public class AccelerationTests {

	@Test
	public void normal_acc_tests() {
		
		
		Velocity a = new Velocity(new Mile(80), new Hour(1)),
				 b = new Velocity(new Mile(100), new Hour(1));
		
		Time t = new Sec(8);
		
		Acceleration acc = new Acceleration(a, b, t);
		Unit exp_dist =  new Unit("5690891/5092065");
		
		System.out.println(acc.getAcceleration(LENGTH_SLOT.UNIT, TIME_SLOT.SEC).getFrac_f());
		assertEquals(exp_dist, acc.getAcceleration(LENGTH_SLOT.UNIT, TIME_SLOT.SEC));
	
		a.setVelocity(new Mile(40), new Hour(1));
		b.setVelocity(new Mile(0), new Hour(1));
		t.setValue(5);
		
		acc.setAcceleration(a, b, t);
		
		System.out.println(acc.getAcceleration(LENGTH_SLOT.UNIT, TIME_SLOT.SEC).getFrac_f());
		assertEquals(exp_dist, acc.getAcceleration(LENGTH_SLOT.UNIT, TIME_SLOT.SEC));
	}

}
