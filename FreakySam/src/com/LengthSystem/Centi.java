package com.LengthSystem;

import com.fractions.Fraction;

public class Centi extends Length{

	public Centi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Centi(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Centi(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Centi(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Centi(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return new Unit(this.getValue().mul((float)0.01));
	}


	
}
