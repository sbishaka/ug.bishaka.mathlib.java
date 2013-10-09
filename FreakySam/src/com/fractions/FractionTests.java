package com.fractions;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Test;

import com.angles.Degree;

public class FractionTests {
	
	@Test
	public void test() 
	{		
		float exp_f = 0;
		Degree d = new Degree("0");
		Fraction act_f = new Fraction("");
		DecimalFormat df = new DecimalFormat("#.###");
		
		d.setValue("0");
		act_f.setFraction(d.toRadians().getValue());
		
		exp_f = 0;
		assertTrue( exp_f <= act_f.sin() );
		
		exp_f = 1;
		assertTrue( exp_f <= act_f.cos() );
		
		exp_f = 0;
		assertTrue( exp_f <= act_f.tan() );

		
		
		d.setValue("30");
		act_f.setFraction(d.toRadians().getValue());
		
		exp_f = (float)0.5;
		df.applyPattern("#.#");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.sin())) );
		
		exp_f = (float)0.866;
		df.applyPattern("#.###");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.cos())) );
		
		exp_f = (float)0.578;
		df.applyPattern("#.###");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.tan())) );

		
		
		d.setValue("45");
		act_f.setFraction(d.toRadians().getValue());
		
		exp_f = (float)0.707;
		df.applyPattern("#.###");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.sin())) );
		
		exp_f = (float)0.707;
		df.applyPattern("#.###");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.cos())) );
		
		exp_f = (float)1;
		df.applyPattern("#");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.tan())) );

		
		
		d.setValue("60");
		act_f.setFraction(d.toRadians().getValue());
		
		exp_f = (float)0.866;
		df.applyPattern("#.###");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.sin())) );
		
		exp_f = (float)0.5;
		df.applyPattern("#.#");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.cos())) );
		
		
		exp_f = (float)1.734;
		df.applyPattern("#.###");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.tan())) );


		d.setValue("90");
		act_f.setFraction(d.toRadians().getValue());
		
		exp_f = (float)1;
		df.applyPattern("#");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.sin())) );
		
		exp_f = (float)0;
		df.applyPattern("#");
		assertTrue( exp_f == Float.parseFloat(df.format(act_f.cos())) );
		
		act_f.setFraction("22/7");
		
		exp_f = (float)3.142857;
		assertTrue( exp_f == act_f.getFract_f());
		
		exp_f = (float)3.1429;
		assertTrue( exp_f == act_f.getFract_f(4));
		
		exp_f = (float)3.143;
		assertTrue( exp_f == act_f.getFract_f(3));

		exp_f = (float)3.14;
		assertTrue( exp_f == act_f.getFract_f(2));

		assertEquals("Testing 0", true, act_f.isGreaterThan("0"));
		assertEquals("Testing 15", true, act_f.isLessThan("15"));
		
	}

}
