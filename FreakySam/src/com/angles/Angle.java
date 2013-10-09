package com.angles;

import com.fractions.Fraction;

public abstract class Angle {
	
	public static final Fraction PI_FRAC = new Fraction("22/7");
	public static final Fraction PI_DOUBLE = new Fraction("3.14159265358979323846");
	protected Fraction value =  new Fraction("0");

	public void setValue(Fraction value) {
		// TODO Auto-generated method stub
		this.value = value;
	}

	public void setValue(String value)
	{
		this.value = new Fraction(value);
	}
	
	public static final Radian toRadians( String angle )
	{
		return new Degree(angle).toRadians();
	}
	
	/**
	 * Returns cos of angle in degrees
	 * if it is a Degree object and 
	 * in radians if it is a radian object
	 * */
	public Fraction cos()
	{
		Radian buff2 = null;
		
		if( this instanceof Radian)
			 buff2 = (Radian)this;
		else
		{
			Degree buff1 = (Degree)this;
			buff2 = buff1.toRadians();
		}
		
		return new Fraction(buff2.getValue().cos()+"");
	}

	/**
	 * Returns arc cos of angle in degrees
	 * if it is a Degree object and 
	 * in radians if it is a radian object
	 * */
	public Fraction acos()
	{
		Radian buff2 = new Radian(this.getValue().acos()+"");
		Fraction result = null;
		
		if( this instanceof Radian)
			 result = buff2.getValue();
		else
		{
			result = buff2.toDegrees().getValue();
		}

		return result;
	}

	
	/**
	 * Returns sin of angle in degrees
	 * if it is a Degree object and 
	 * in radians if it is a radian object
	 * */
	public Fraction sin()
	{
		Radian buff2 = null;
		
		if( this instanceof Radian)
			 buff2 = (Radian)this;
		else
		{
			Degree buff1 = (Degree)this;
			buff2 = buff1.toRadians();
		}
		
		return new Fraction(buff2.getValue().sin()+"");
	}
	
	/**
	 * Returns arc sin of angle in degrees
	 * if it is a Degree object and 
	 * in radians if it is a radian object
	 * */
	public Fraction asin()
	{
		Radian buff2 = new Radian(this.getValue().asin()+"");
		Fraction result = null;
		
		if( this instanceof Radian)
			 result = buff2.getValue();
		else
		{
			result = buff2.toDegrees().getValue();
		}

		return result;
	}

	
	/**
	 * Returns tan of angle in degrees
	 * if it is a Degree object and 
	 * in radians if it is a radian object
	 * */	
	public Fraction tan()
	{
		Radian buff2 = null;
		
		if( this instanceof Radian)
			 buff2 = (Radian)this;
		else
		{
			Degree buff1 = (Degree)this;
			buff2 = buff1.toRadians();
		}
		
		return new Fraction(buff2.getValue().tan()+"");
	}

	/**
	 * Returns arc tan of angle in degrees
	 * if it is a Degree object and 
	 * in radians if it is a radian object
	 * */
	public Fraction atan()
	{
		Radian buff2 = new Radian(this.getValue().atan()+"");
		Fraction result = null;
		
		if( this instanceof Radian)
			 result = buff2.getValue();
		else
		{
			result = buff2.toDegrees().getValue();
		}

		return result;
	}
	
	public static final Radian toRadians_prec( String angle )
	{
		return new Degree(angle).toRadians_prec();
	}
	
	public static final Degree toDegrees( String angle )
	{
		return new Radian(angle).toDegrees();
	}

	public static final Degree toDegrees_prec( String angle )
	{
		return new Radian(angle).toDegrees_prec();
	}

	public Fraction getValue() {
		return value;
	}
	
}
