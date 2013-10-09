package com.LengthSystem;

import com.fractions.Fraction;

public class Hecto extends Length{

	
	
	public Hecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hecto(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Hecto(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Hecto(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Hecto(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return new Unit(this.getValue().mul(100));
	}

}
