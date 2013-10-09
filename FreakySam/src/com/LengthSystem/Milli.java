package com.LengthSystem;

import com.fractions.Fraction;

public class Milli extends Length{

	public Milli() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Milli(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Milli(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Milli(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Milli(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return new Unit(this.getValue().mul((float)0.001));
	}

}
