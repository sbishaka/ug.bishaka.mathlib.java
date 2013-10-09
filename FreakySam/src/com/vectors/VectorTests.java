package com.vectors;

import static org.junit.Assert.*;

import org.junit.Test;

import com.points.Point;

public class VectorTests {

	@Test
	public void test() {
		
		
		/*
		 * TRANSFORMATION TESTS
		 * */
		
		/*
		 * Vector 20m @ 30degrees
		 * x ~ 17.32(2dp)
		 * y ~ 10.0(1dp)
		 * */
		
		Vector t = new Vector("20", "30");
		float exp_x = (float)17.32,
			  exp_y = (float)10.0;
		
		assertEquals("Testing 20@30", exp_x, t.getCartesianInfo().getX().getFract_f(2), 0);
		assertEquals("Testing 20@30", exp_y, t.getCartesianInfo().getY().getFract_f(1), 0);
		
		
		/*
		 * Vector (3,4,0)
		 * magnitude = 5
		 * direction ~ 53.1 degrees
		 * */		
		t.setVector("3,4,0");
		float exp_mag = (float)5.0,
			  exp_dir = (float)53.1;	 

		assertEquals("Testing (3,4,0)", exp_mag, t.getMagnitude().getFract_f(1), 0);
		assertEquals("Testing (3,4,0)", exp_dir, t.getDirection_deg().getValue().getFract_f(1) , 0);

		t.setVector("6,8,0");
		exp_mag = (float)10.0;
		exp_dir = (float)53.1;	 

		assertEquals("Testing (3,4,0)", exp_mag, t.getMagnitude().getFract_f(1), 0);
		assertEquals("Testing (3,4,0)", exp_dir, t.getDirection_deg().getValue().getFract_f(1) , 0);
		
		
		/*
		 * ARITHMETIC TESTS
		 * */
		Point exp_p = new Point("13,15");
		Vector A = new Vector("8,3"),B = new Vector("5,12");
		assertEquals(exp_p, A.add(B).getCartesianInfo());
		
		A.setVector("9,5,-2");
		B.setVector("-2,1,4");
		exp_p.setPoint("7,6,2");
		assertEquals(exp_p, A.add(B).getCartesianInfo());
		
		exp_p.setPoint("11,4,-6");
		assertEquals(exp_p, A.sub(B).getCartesianInfo());
		
		A = Vector.newVector_p("1,4", "8,10");
		B = Vector.newVector_p("1,4", "7,3");
		
		exp_p.setPoint("13,5");
		assertEquals(exp_p, A.add(B).getCartesianInfo());
		
		A.setVector("2,-4,-1");
		B.setVector("-5,3,6");
		
		exp_p.setPoint("-3,-1,5");
		assertEquals(exp_p, A.add(B).getCartesianInfo());

		exp_p.setPoint("7,-7,-7");
		assertEquals(exp_p, A.sub(B).getCartesianInfo());
		
		A.setVector("12,4");

		exp_p.setPoint("6,2");
		assertEquals(exp_p, A.mul("1/2").getCartesianInfo());
		
		A.setVector("5,0,-12");

		exp_p.setPoint("5/13,0,-12/13");
		assertEquals(exp_p, A.normalize().getCartesianInfo());
		
		A.setVector("5,2,-3");
		B.setVector("8,1,-4");
		
		float exp_ang = (float)13.3;
		assertEquals( exp_ang, A.angleOfRot_deg(B).getValue().getFract_f(1),0);
	
	}

}
