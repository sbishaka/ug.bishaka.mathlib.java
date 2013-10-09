package com.LengthSystem;

import com.fractions.Fraction;

public class Deci extends Length{

	public Deci() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deci(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Deci(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Deci(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Deci(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return new Unit(this.getValue().mul((float) 0.1));
	}

	
	
}
