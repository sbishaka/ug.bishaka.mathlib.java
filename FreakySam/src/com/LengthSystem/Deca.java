package com.LengthSystem;

import com.fractions.Fraction;

public class Deca extends Length{

	public Deca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deca(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Deca(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Deca(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Deca(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return new Unit(this.getValue().mul(10));
	}

	
	
}
