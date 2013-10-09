package com.TimeSystem.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.TimeSystem.Day;
import com.TimeSystem.Min;
import com.TimeSystem.Sec;
import com.TimeSystem.Week;

public class TimeSystemTests {

	@Test
	public void weeks_to_seconds_test() {
		
		/*
		 *How many seconds in 2 weeks?
		 */
		Sec exp_secs = new Sec("1209600");
		Week act_sec = new Week("2");
		
		assertEquals("Testing the number of seconds in one week", exp_secs,act_sec.toSec());
	}
	
	@Test
	public void days_to_mins_test() {
		
		/*
		 *How many minutes are in 3 days?
		 */
		Min exp_val = new Min("4320");
		Day act_val = new Day("3");
		
		assertEquals("Testing the number of minutes in 3 days\n\n", exp_val,act_val.toMin());
	}

}
