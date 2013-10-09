package com.LengthSystem;

import com.fractions.Fraction;

public class Foot extends Length{

	public Foot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Foot(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Foot(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Foot(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Foot(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return this.getInMeters().toUnit();
	}

	private Unit getInMeters()
	{
		return new Unit(this.getValue().mul((float)0.3048));
	}
}
