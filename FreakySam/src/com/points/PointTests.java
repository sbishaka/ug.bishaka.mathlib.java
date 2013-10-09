package com.points;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fractions.Fraction;

public class PointTests {

	@Test
	public void test() {
		
		Fraction exp = new Fraction("-2/1");
		assertEquals(exp, Point.getSlope("0,10", "5,0"));
		
		exp.setFraction("-2/1");
		assertEquals(exp, Point.getSlope("3,5", "1,9"));

		exp.setFraction("1/2");
		assertEquals(exp, Point.getSlope("2,-1", "6,1"));
		
		exp.setFraction("3");
		assertEquals(exp, Point.getSlope("-2,-5", "1,4"));

		exp.setFraction("3/2");
		assertEquals(exp, Point.getSlope("-3,5", "-4,7/2"));

		exp.setFraction("0");
		assertEquals(exp, Point.getSlope("9,8", "9,-7"));

		assertEquals(new Float(50), new Float(Point.distanceBetweenPoints("25,80", "55,40").getFract_f()));
		
		assertEquals(new Integer(86), new Integer((int) Point.distanceBetweenPoints("25,80,30", "55,40,100").getFract_f()));
		
		Point exp_point = new Point("40,60");
		assertEquals(exp_point, Point.getMidPoint("25,80", "55,40"));

		exp_point.setPoint("40, 60, 65");
		assertEquals(exp_point, Point.getMidPoint("25,80,30", "55,40,100"));
		
	}

}
