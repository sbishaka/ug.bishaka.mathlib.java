package com.trig;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrianglesTests {

	@Test
	public void test() {
		
		Triangle t = new Triangle("20,50","100,90", "70,150");
		assertTrue(t.isRightAngle());
		
		t.setTriangle("30,75", "25,0", "-50,45");
		assertFalse(t.isRightAngle());
	}

}
