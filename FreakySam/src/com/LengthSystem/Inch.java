package com.LengthSystem;

import com.fractions.Fraction;

public class Inch extends Length{

	
	
	public Inch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inch(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Inch(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Inch(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Inch(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return this.getInCentimeters().toUnit();
	}
	
	private Centi getInCentimeters()
	{
		return new Centi(this.getValue().mul((float)2.54));
	}

}
