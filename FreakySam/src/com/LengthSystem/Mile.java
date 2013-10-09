package com.LengthSystem;

import com.fractions.Fraction;

public class Mile extends Length{
	
	public Mile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mile(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Mile(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Mile(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Mile(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Unit toUnit() {
		// TODO Auto-generated method stub
		return this.getInKilos().toUnit();
	}

	private Kilo getInKilos()
	{
		return new Kilo(this.getValue().mul((float)1.609344));
	}
}
