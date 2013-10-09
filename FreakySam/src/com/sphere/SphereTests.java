package com.sphere;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fractions.Fraction;

public class SphereTests {

	@Test
	public void test() {
		
		Sphere a = new Sphere("50", "20", "0","30"), b = new Sphere("-10", "10", "0","20");
		assertFalse(a.collidesWith(b));
		
		a.setSphere_eqn("30", "20", "-10", "40");
		b.setSphere_eqn("0", "40", "-50", "50");
		assertTrue(a.collidesWith(b));

		/*Self assessment beginning
		 * */
		a.setSphere_eqn("70", "20", "0", "40");
		b.setSphere_eqn("50", "60", "0", "16");
		assertTrue(a.collidesWith(b));

		
		a.setSphere_eqn("50", "0", "-20", "40");
		b.setSphere_eqn("60", "70", "-50", "20");
		assertFalse(a.collidesWith(b));

		
	}

}
