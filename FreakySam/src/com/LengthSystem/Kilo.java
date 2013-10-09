package com.LengthSystem;

import com.fractions.Fraction;

public class Kilo extends Length {

	public Kilo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kilo(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Kilo(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Kilo(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Kilo(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return new Unit(this.getValue().mul(1000));
	}
	
	

}
