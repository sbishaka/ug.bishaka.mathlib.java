package com.LengthSystem.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.LengthSystem.Centi;
import com.LengthSystem.Inch;
import com.LengthSystem.Mile;
import com.LengthSystem.Unit;
import com.TimeSystem.Hour;
import com.TimeSystem.Sec;
import com.fractions.Fraction;

public class LengthSystemTests {

	@Test
	public void miles_to_meters_test() {
		
		Unit exp_val = new Unit("8046.7207");
		Mile act_val = new Mile("5");
		
		assertEquals("Testing number of kilometers in 5 miles\n\n", exp_val, act_val.toUnit());
	}

	
	@Test
	public void speed_conversion_test() {
		
		/*
		 * Suppose you estimate that the car in your racing game is currently going 180mi/hr. 
		 * Your team has decided to program in metric units. What is its speed in m/s?
		 * */
		Mile dist = new Mile("180");
		Hour time = new Hour("1");
		Fraction exp_val = new Fraction("80.46719");
		Fraction act_val = dist.toUnit().getValue().div(time.toSec().getValue());
	
		assertEquals("Testing converting 180mi/hr to m/s\n\n", exp_val.getFract_f(), act_val.getFract_f(),0);
	}
	
	@Test
	public void miSec_to_miHour_conversion_test() {
		
		/*
		 * Suppose you estimate that the car in your racing game is currently going 180mi/hr. 
		 * Your team has decided to program in metric units. What is its speed in m/s?
		 * */
		Mile dist = new Mile("0.03125");
		Sec time = new Sec("1");
		Fraction exp_val = new Fraction("112.5");
		Fraction act_val = dist.getValue().div(time.toHour().getValue());
	
		System.out.println(act_val.getFract_f());
		
		assertEquals("Testing converting 180mi/hr to m/s\n\n", exp_val.getFract_f(), act_val.getFract_f(),0);
	}
	
	@Test
	public void acceleration_conversion_test() {
		
		/*
		 *Suppose you estimate that the car in your racing game is currently accelerating at a rate of 20,000mi/hr^2. 
		 *Unfortunately, your team has decided to program in metric units. What is the acceleration in m/s^2?
		 * */
		Mile dist = new Mile("20000");
		Hour time = new Hour("1");
		Fraction exp_val = new Fraction("2.48356");
		Fraction act_val = dist.toUnit().getValue().div(time.toSec().getValue().mul(time.toSec().getValue()));
	
		assertEquals("Testing converting 20000mi/hr^2 to m/s^2\n\n", exp_val.getFract_f(), act_val.getFract_f(5),0);
	}

	@Test
	public void centimeters_to_inches_test()
	{
		/*
		 * How many centimeters are in 10 inches?
		 */
		Centi exp_val = new Centi("25.4");
		Inch act_val = new Inch("10");
		assertEquals("Testing converting 10 inches to centimeters\n\n", exp_val.getValue().getFract_f(), act_val.toCenti().getValue().getFract_f(1),0);
	}
	
}
