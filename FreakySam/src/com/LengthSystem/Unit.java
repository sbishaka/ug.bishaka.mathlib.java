package com.LengthSystem;

import com.fractions.Fraction;

public class Unit extends Length{

	
	
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unit(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Unit(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Unit(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Unit(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return this;
	}

}
