package com.angles;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fractions.Fraction;

public class AngleTests {

	@Test
	public void test() {
		
		/*
		 * 120 degrees = 2PI/3 radians
		 * */
		Degree d = new Degree("120");
		Fraction a = new Fraction("2"), b = new Fraction("3");
		
		Radian exp_r = new Radian( a.mul(Angle.PI_FRAC).div(b) );
		assertEquals(exp_r, d.toRadians());
		
		a.setFraction("6");
		b.setFraction("5");

		/*
		 * 6PI/5 radians = 216 degrees
		 * */
		Radian r = new Radian(a.mul(Angle.PI_FRAC).div(b));
		Degree exp_d = new Degree("216");
		assertEquals(exp_d, r.toDegrees());
		
		/*
		 * Self assessment degrees to radians
		 * */
		d.setValue("60");
		exp_r.setValue("22/21");
		assertEquals( exp_r, d.toRadians());

		d.setValue("270");
		exp_r.setValue("33/7");
		assertEquals( exp_r, d.toRadians());

		d.setValue("45");
		exp_r.setValue("11/14");
		assertEquals( exp_r, d.toRadians());

		/*
		 * Self assessment radians to degrees
		 * */
		a.setFraction("3");
		b.setFraction("4");
		exp_d.setValue("135");
		r.setValue(a.mul(Angle.PI_FRAC).div(b));
		assertEquals(exp_d, r.toDegrees());
	
		a.setFraction("1");
		b.setFraction("3");
		exp_d.setValue("60");
		r.setValue(a.mul(Angle.PI_FRAC).div(b));
		assertEquals(exp_d, r.toDegrees());
	
		a.setFraction("2");
		b.setFraction("5");
		exp_d.setValue("72");
		r.setValue(a.mul(Angle.PI_FRAC).div(b));
		assertEquals(exp_d, r.toDegrees());
		
		/*
		 * FULL TRIG TESTS
		 * */

		d.setValue("0");
		exp_r.setValue("0");
		assertEquals(exp_r, d.toRadians());
		
		d.setValue("30");
		exp_r.setValue(Angle.PI_FRAC.div(new Fraction("6")));
		assertEquals(exp_r, d.toRadians());
		
		d.setValue("45");
		exp_r.setValue(Angle.PI_FRAC.div(new Fraction("4")));
		assertEquals(exp_r, d.toRadians());
		
		d.setValue("60");
		exp_r.setValue(Angle.PI_FRAC.div(new Fraction("3")));
		assertEquals(exp_r, d.toRadians());
		
		d.setValue("120");
		exp_r.setValue(a.mul(Angle.PI_FRAC.div(new Fraction("3"))));
		assertEquals(exp_r, d.toRadians());
		
		d.setValue("180");
		exp_r.setValue(Angle.PI_FRAC.div(new Fraction("1")));
		assertEquals(exp_r, d.toRadians());
		
		d.setValue("270");
		a.setFraction("3");
		exp_r.setValue(a.mul(Angle.PI_FRAC.div(new Fraction("2"))));
		assertEquals(exp_r, d.toRadians());

		d.setValue("360");
		a.setFraction("2");
		exp_r.setValue(a.mul(Angle.PI_FRAC));
		assertEquals(exp_r, d.toRadians());

		
	}

}
