package com.angles;

import com.fractions.Fraction;

public class Degree extends Angle{
	
	public Degree(Fraction value) {
		super();
		this.value = value;
	}
	
	public Degree() {
		super();
	}

	public Degree(String value) {
		super();
		setValue(new Fraction(value));
	}
	
	public Radian toRadians()
	{
		/*
		 * 1 degree = (PI)/(180) radians
		 * */
		return new Radian( this.getValue().mul(PI_FRAC.div(new Fraction("180"))) );
	}

	public Radian toRadians_prec()
	{
		/*
		 * 1 degree = (PI)/(180) radians
		 * */
		return new Radian( this.getValue().mul(PI_DOUBLE.div(new Fraction("180"))) );
	}

	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Degree))
			throw new ClassCastException("A degree object is expected");
		
		Degree anotherAngle = (Degree) obj;
		return this.value.equals(anotherAngle.value);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value.getFract_f() + " degrees";
	}
	
	

}
