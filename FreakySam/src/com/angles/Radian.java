package com.angles;

import com.fractions.Fraction;

public class Radian extends Angle {

	
	public Radian(Fraction value) {
		super();
		setValue(value);
	}
	
	public Radian() {
		super();
	}

	public Radian(String value) {
		super();
		setValue(new Fraction(value));
	}
	
	public Degree toDegrees()
	{
		/*
		 * 1 radian = (180)/(PI) degrees
		 * */
		return new Degree( this.getValue().mul( new Fraction("180").div(PI_FRAC)));
	}

	public Degree toDegrees_prec()
	{
		/*
		 * 1 radian = (180)/(PI) degrees
		 * */
		return new Degree( this.getValue().mul( new Fraction("180").div(PI_DOUBLE)));
	}

	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Radian))
			throw new ClassCastException("A radian object is expected");
		
		Radian anotherAngle = (Radian) obj;
		return this.value.equals(anotherAngle.value);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value.getFract_f()+" radians";
	}

}
