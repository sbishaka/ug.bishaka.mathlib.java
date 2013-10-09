package com.lines;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fractions.Fraction;
import com.points.Point;

public class LineTests {

	@Test
	public void test() {
		
		/**
		 * Eqn : y = 1/2x + 1
		 * Slope : 1/2
		 * */
		Line line = new Line("-1/2,1,1");
		Fraction exp = new Fraction("1/2");
		assertEquals("", exp, line.getSlope());

		/**
		 * Eqn 		: -3x + 6y = -12
		 * Slope	: 1/2
		 * */
		Line line2 = new Line("-3, 6, -12");
		assertEquals("", exp, line2.getSlope());
		
		/*
		 * parallel : true
		 * */
		assertTrue(line.isParallelTo(line2));
		
		/*
		 * Eqn 		: 2x + y = 5;
		 * Slope	: -2
		 * */
		line.setEqn("2,1,5");
		exp.setFraction("-2");		
		assertEquals("", exp, line.getSlope());
		
		/*
		 * Given two points ( 50, 200 ) and (150, 400)
		 * we should get a line with eqn
		 * y = 2x + 100
		 * */
		Line exp_line = new Line("-2,1,100");
		assertEquals(exp_line, Line.getEquation_lineObj(new Point("50, 200"), new Point("150, 400")));
	
		
		/*
		 * Just calculating slope
		 * */
		
		exp.setFraction("-2/3");
		assertEquals(exp, Line.getSlope("2,3,10"));

		exp.setFraction("1/5");
		assertEquals(exp, Line.getSlope("1,-5,0"));

		exp.setFraction("0");
		assertEquals(exp, Line.getSlope("0,2,8"));

		exp.setFraction("-1");
		assertEquals(exp, Line.getSlope("1,1,-7"));


		/*
		 * Calculating the equation of a line
		 * */

		exp_line.setEqn("2,1,10");
		assertEquals(exp_line, Line.getEquation_lineObj_pts_str("0,10","5,0"));

		exp_line.setEqn("2,1,11");
		assertEquals(exp_line, Line.getEquation_lineObj_pts_str("3,5","1,9"));

		exp_line.setEqn("-1,2,-2");
		assertEquals(exp_line, Line.getEquation_lineObj_pts_str("2,-1","6,1"));

		exp_line.setEqn("-3,1,1");
		assertEquals(exp_line, Line.getEquation_lineObj_pts_str("-2,-5","1,4"));

		
		/*
		 * Intersection between lines
		 * */
		Point exp_point = new Point("3,-1,0");
		try {
			assertEquals(exp_point, Line.getIntersectionPoint("2,3,3", "-1,3,-6"));
		} catch (LineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		line.setEqn("1,1,7");
		Fraction slope = new Fraction("-1");
		Fraction y_intercept = new Fraction("7");
		
		assertEquals("",slope, line.getSlope());
		assertEquals(y_intercept, line.getYcoordinate("0"));
		
		line.setEqn("1,-3,-6");
		slope.setFraction("1/3");
		y_intercept.setFraction("2");
		
		assertEquals("",slope, line.getSlope());
		assertEquals(y_intercept, line.getYcoordinate("0"));

		line.setEqn("1, 4, 8");
		slope.setFraction("-1/4");
		y_intercept.setFraction("2");
		
		assertEquals("",slope, line.getSlope());
		assertEquals(y_intercept, line.getYcoordinate("0"));
		
		
	}

}
