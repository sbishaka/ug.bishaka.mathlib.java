package com.points.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.points.Point;
import com.vectors.Vector;

public class PointTests {

	@Test
	public void displacement_tests() 
	{
		Vector exp_p = new Vector("500,-300"),
			 act_p = Vector.newVector_p("50,400", "550,100");

		assertEquals("Testing displacement between P(50,400) and P'(550,100)", exp_p, act_p);
		
		exp_p.setVector("250,250,-550");
		act_p.setVector_p("150,0,250", "400,250,-300");
		assertEquals("Testing displacement between P(150,0,250) and P'(400,250,-300)", exp_p, act_p);
	}

}
